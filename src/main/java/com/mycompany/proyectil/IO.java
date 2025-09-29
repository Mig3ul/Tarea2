package com.mycompany.proyectil;

/*
import javax.swing.JOptionPane;
public class IO {

    //leer una cadena de texto
    public static String leerTexto(String msg){
        String entrada;
        entrada = JOptionPane.showInputDialog(null, msg);
        return entrada;
    }
    //leer un numero
    public static double leerDouble(String msg){
        double entrada;
        entrada = Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    //leer un entero
    public static int leerEntero(String msg){
        int entrada;
        entrada = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    //leer char
    public static char leerChar(String msg){
        char entrada;
        entrada = JOptionPane.showInputDialog(msg).charAt(0);
        return entrada;
    }
    //mostrar un mensaje
    public static void mostrarMensaje(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    //leer arreglos double
    public static double[] leerArregloDouble(String msg, int tamaño){
        double[] arreglo = new double[tamaño];
        
        for (int i = 0; i < tamaño; i++){
            String entrada = JOptionPane.showInputDialog(msg);
            arreglo[i] = Double.parseDouble(entrada);
        }
        return arreglo;
    }



    /*
    public static double[] leerArregloDouble(String msg, int tamaño) {
        double[] arreglo = new double[tamaño];
        
            for (int i = 0; i < tamaño; i++) {
                String entrada = JOptionPane.showInputDialog(msg + " - Elemento " + (i + 1));
                arreglo[i] = Double.parseDouble(entrada);
            }
        
        return arreglo;

    }
        */
        /*
}

*/

import javax.swing.JOptionPane;

public class IO {
    
    // Leer int
    public static int leerInt(String msg) {
        int entrada;
        entrada = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    
    // Leer double
    public static double leerDouble(String msg) {
        double entrada;
        entrada = Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    
    // Leer arreglo de doubles
    public static double[] leerArregloDouble(String msg, int tamanio) {
        double[] arreglo = new double[tamanio];
        for (int i = 0; i < tamanio; i++) {
            arreglo[i] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                msg + "\nIngrese el valor para la posición [" + i + "]:"));
        }
        return arreglo;
    }
    
    // Mostrar mensaje
    public static void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    // Pausar (esperar que el usuario presione OK)
    public static void pausar() {
        JOptionPane.showMessageDialog(null, "Presione OK para continuar...");
    }
    
    // Mostrar trayectoria
    public static void mostrarTrayectoria(String titulo, double[] tiempos, 
                                        double[] posX, double[] posY, double[] posZ) {
        String mensaje = "\n========== " + titulo + " ==========\n";
        mensaje = mensaje + "Tiempo(s)       X(m)            Y(m)            Z(m)\n";
        mensaje = mensaje + "------------------------------------------------------------\n";
        
        for (int i = 0; i < tiempos.length; i++) {
            mensaje = mensaje + tiempos[i] + "       " + posX[i] + "       " + posY[i] + "       " + posZ[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    // Mostrar cálculos especiales
    public static void mostrarCalculosEspeciales(double alturaMax, double tiempoAlturaMax, 
                                                double alcanceMax) {
        String mensaje = "\n========== CÁLCULOS ESPECIALES ==========\n";
        mensaje = mensaje + "Altura máxima: " + alturaMax + " m\n";
        mensaje = mensaje + "Tiempo para altura máxima: " + tiempoAlturaMax + " s\n";
        mensaje = mensaje + "Alcance horizontal máximo: " + alcanceMax + " m\n";
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
}