package com.mycompany.proyectil;

public abstract class Proyectil {

    protected double masa;
    protected double v0; //velocidad inicial
    protected double anguloTheta, anguloPhi;
    protected double cosTheta , cosPhi;
    protected double sinTheta, sinPhi;

    protected double v0X, v0Y,v0Z; // Componentes de la velocidad
    protected double[] x0, y0, z0; //posiciones iniciales

    protected static final double GRAVEDAD = 9.8; //9.8m/s^2 

    public Proyectil() {
        this.masa = 0.0;
        this.v0 = 0.0;

        this.anguloTheta = Math.toRadians(anguloTheta); //Angulo theta en radianes
        this.anguloPhi = Math.toRadians(anguloPhi); // Angulo phi en radianes
        this.cosTheta = Math.cos(anguloTheta); // coseno de theta 
        this.cosPhi = Math.cos(anguloPhi); // coseno de phi

        this.sinTheta = Math.sin(anguloTheta); // seno de Theta
        this.sinPhi = Math.sin(anguloPhi); // seno de phi

        this.v0X = 0.0;
        this.v0Y = 0.0;
        this.v0Z = 0.0;
    }


    public double getMasa() { return masa; }
    public double getV0() { return v0; }
    public double getAnguloTheta() { return Math.toDegrees(anguloTheta); }
    public double getAnguloPhi() { return Math.toDegrees(anguloPhi); }
    public double getCosTheta() { return cosTheta; }
    public double getCosPhi() { return cosPhi; }
    public double getSinTheta() { return sinTheta; }
    public double getSinPhi() { return sinPhi; }
    public double getV0X() { return v0X; }
    public double getV0Y() { return v0Y; }
    public double getV0Z() { return v0Z; }
    public double[] getX0() { return x0; }
    public double[] getY0() { return y0; }
    public double[] getZ0() { return z0; }
    public static double getGravedad() { return GRAVEDAD; }


    public void calculoVelocidadesIniciales(){
        v0X = v0 * cosTheta * cosPhi;
        v0Y = v0 * cosTheta * sinPhi;
        v0Z = v0 * sinTheta;
    }

    public abstract double calcularPosicionX(double t);
    public abstract double calcularPosicionY(double t);
    public abstract double calcularPosicionZ(double t);


    public void calcularTrayectoria(double[] tiempos, double[] posX, double[] posY, double [] posZ){
        for (int i = 0; i < tiempos.length; i++){
            posX[i] = calcularPosicionX(tiempos[i]);
            posY[i] = calcularPosicionY(tiempos[i]);
            posZ[i] = calcularPosicionZ(tiempos[i]);
        }
    }



}