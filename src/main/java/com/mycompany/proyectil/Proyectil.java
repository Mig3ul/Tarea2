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

    public void calculoVelocidadesIniciales(){
        v0X = v0 * cosTheta * cosPhi;
        v0Y = v0 * cosTheta * sinPhi;
        v0Z = v0 * sinTheta;
    }

    public abstract double calcularPosicionX(double t);
    public abstract double calcularPosicionY(double t);
    public abstract double calcularPosicionZ(double t);
}