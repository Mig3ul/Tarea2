package com.mycompany.proyectil;

public class Simulador {
    private double[] tiempos;
    private ProyectilSinResistenciaAlAire proyectilSinResistencia;
    private ProyectilConResistenciaAlAire proyectilConResistencia;
    
    // Arreglos para almacenar trayectorias
    private double[] posXSinRes, posYSinRes, posZSinRes;
    private double[] posXConRes, posYConRes, posZConRes;
    
    private boolean trayectoriaSinResCalculada = false;
    private boolean trayectoriaConResCalculada = false;
    
    public Simulador() {
        this.tiempos = null;
        this.proyectilSinResistencia = null;
        this.proyectilConResistencia = null;
    }
    
    public void ejecutar() {
        int opcion = 0;
        
        while (opcion != 5) {
            String menu = "\n========== SIMULADOR DE PROYECTILES 3D ==========\n"
                    + "1. Ingresar vector de tiempos\n"
                    + "2. Simular movimiento sin resistencia\n"
                    + "3. Simular movimiento con resistencia\n"
                    + "4. Mostrar ambas trayectorias\n"
                    + "5. Salir\n"
                    + "Seleccione una opcion:";
            
            opcion = IO.leerInt(menu);
            
            switch (opcion) {
                case 1:
                    ingresarTiempos();
                    break;
                case 2:
                    simularSinResistencia();
                    break;
                case 3:
                    simularConResistencia();
                    break;
                case 4:
                    mostrarAmbasTrayectorias();
                    break;
                case 5:
                    IO.mostrarMensaje("Gracias por usar el simulador. ¡Hasta pronto!");
                    break;
                default:
                    IO.mostrarMensaje("Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
    }
    
    private void ingresarTiempos() {
        int n = IO.leerInt("¿Cuantos puntos de tiempo desea ingresar?");
        
        if (n <= 0) {
            IO.mostrarMensaje("El numero de puntos debe ser mayor a 0");
            return;
        }
        
        tiempos = IO.leerArregloDouble("Ingrese los tiempos (en segundos)", n);
        IO.mostrarMensaje("Vector de tiempos ingresado correctamente.");
        
        // Resetear las banderas cuando se ingresan nuevos tiempos
        trayectoriaSinResCalculada = false;
        trayectoriaConResCalculada = false;
    }
    
    private void simularSinResistencia() {
        if (tiempos == null) {
            IO.mostrarMensaje("Primero debe ingresar el vector de tiempos (Opcion 1)");
            return;
        }
        
        // Leer parametros del proyectil
        double masa = IO.leerDouble("Ingrese la masa del proyectil (kg):");
        double v0 = IO.leerDouble("Ingrese la velocidad inicial (m/s):");
        double theta = IO.leerDouble("Ingrese el angulo theta - elevacion (grados):");
        double phi = IO.leerDouble("Ingrese el angulo phi - horizontal (grados):");
        double x0 = IO.leerDouble("Ingrese la posicion inicial X (m):");
        double y0 = IO.leerDouble("Ingrese la posicion inicial Y (m):");
        double z0 = IO.leerDouble("Ingrese la posicion inicial Z (m):");
        
        // Crear el proyectil
        proyectilSinResistencia = new ProyectilSinResistenciaAlAire(masa, v0, theta, phi, x0, y0, z0);
        
        // Inicializar arreglos para las posiciones
        posXSinRes = new double[tiempos.length];
        posYSinRes = new double[tiempos.length];
        posZSinRes = new double[tiempos.length];
        
        // Calcular trayectoria
        proyectilSinResistencia.calcularTrayectoria(tiempos, posXSinRes, posYSinRes, posZSinRes);
        
        trayectoriaSinResCalculada = true;
        
        // Mostrar trayectoria
        IO.mostrarTrayectoria("TRAYECTORIA SIN RESISTENCIA", tiempos, posXSinRes, posYSinRes, posZSinRes);
        
        // Calcular y mostrar valores especiales
        double alturaMax = proyectilSinResistencia.alturaMaximaAlcanzada();
        double tiempoAlturaMax = proyectilSinResistencia.tiempoParaAlturaMax();
        double alcanceMax = proyectilSinResistencia.alcanceHorizontalMaximo();
        
        IO.mostrarCalculosEspeciales(alturaMax, tiempoAlturaMax, alcanceMax);
    }
    
    private void simularConResistencia() {
        if (tiempos == null) {
            IO.mostrarMensaje("Primero debe ingresar el vector de tiempos (Opcion 1)");
            return;
        }
        
        // Leer parametros del proyectil
        double masa = IO.leerDouble("Ingrese la masa del proyectil (kg):");
        double v0 = IO.leerDouble("Ingrese la velocidad inicial (m/s):");
        double theta = IO.leerDouble("Ingrese el angulo theta - elevacion (grados):");
        double phi = IO.leerDouble("Ingrese el angulo phi - horizontal (grados):");
        double x0 = IO.leerDouble("Ingrese la posicion inicial X (m):");
        double y0 = IO.leerDouble("Ingrese la posicion inicial Y (m):");
        double z0 = IO.leerDouble("Ingrese la posicion inicial Z (m):");
        double k = IO.leerDouble("Ingrese el coeficiente de resistencia del aire k:");
        
        // Crear el proyectil
        proyectilConResistencia = new ProyectilConResistenciaAlAire(masa, v0, theta, phi, x0, y0, z0, k);
        
        // Inicializar arreglos para las posiciones
        posXConRes = new double[tiempos.length];
        posYConRes = new double[tiempos.length];
        posZConRes = new double[tiempos.length];
        
        // Calcular trayectoria
        proyectilConResistencia.calcularTrayectoria(tiempos, posXConRes, posYConRes, posZConRes);
        
        trayectoriaConResCalculada = true;
        
        // Mostrar trayectoria
        IO.mostrarTrayectoria("TRAYECTORIA CON RESISTENCIA", tiempos, posXConRes, posYConRes, posZConRes);
    }
    
    private void mostrarAmbasTrayectorias() {
        if (!trayectoriaSinResCalculada && !trayectoriaConResCalculada) {
            IO.mostrarMensaje("Debe simular al menos uno de los movimientos primero.");
            return;
        }
        
        if (trayectoriaSinResCalculada && !trayectoriaConResCalculada) {
            IO.mostrarMensaje("Solo ha simulado el movimiento SIN resistencia.");
            IO.mostrarTrayectoria("TRAYECTORIA SIN RESISTENCIA", tiempos, posXSinRes, posYSinRes, posZSinRes);
            return;
        }
        
        if (!trayectoriaSinResCalculada && trayectoriaConResCalculada) {
            IO.mostrarMensaje("Solo ha simulado el movimiento CON resistencia.");
            IO.mostrarTrayectoria("TRAYECTORIA CON RESISTENCIA", tiempos, posXConRes, posYConRes, posZConRes);
            return;
        }
        
        // Mostrar ambas trayectorias
        IO.mostrarTrayectoria("TRAYECTORIA SIN RESISTENCIA", tiempos, posXSinRes, posYSinRes, posZSinRes);
        IO.pausar();
        IO.mostrarTrayectoria("TRAYECTORIA CON RESISTENCIA", tiempos, posXConRes, posYConRes, posZConRes);
        
        // Mostrar comparacion
        String comparacion = "\n========== COMPARACION DE TRAYECTORIAS ==========\n";
        comparacion = comparacion + "Las trayectorias han sido calculadas.\n";
        comparacion = comparacion + "La resistencia del aire reduce el alcance y la altura del proyectil.\n";
        IO.mostrarMensaje(comparacion);
    }
    
    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        simulador.ejecutar();
    }
}