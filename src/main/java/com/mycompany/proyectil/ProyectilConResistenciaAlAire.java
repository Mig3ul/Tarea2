package com.mycompany.proyectil;

public class ProyectilConResistenciaAlAire extends ProyectilSinResistenciaAlAire {
    private double k; 
    
    public ProyectilConResistenciaAlAire(double masa, double v0, double anguloTheta, double anguloPhi, double x0, double y0, double z0, double k) {
        super(masa, v0, anguloTheta, anguloPhi, x0, y0, z0);
        this.k = k;
    }
    
    public double getK() {
        return k;
    }
    
    public void setK(double k) {
        this.k = k;
    }
    
    @Override
    public double calcularPosicionX(double t) {
        double exponente = -k * t / masa;
        return x0 + (masa / k) * v0X * (1 - Math.pow(Math.E, exponente));
    }
    
    @Override
    public double calcularPosicionY(double t) {
        double exponente = -k * t / masa;
        double cal1 = y0;
        double cal2 = (masa * GRAVEDAD / k) * (t + (masa / k) * (1 - Math.pow(Math.E, exponente)));
        double cal3 = (masa / k) * v0Y * (1 - Math.pow(Math.E, exponente));
        return cal1 + cal2 + cal3;
    }
    
    @Override
    public double calcularPosicionZ(double t) {
        double exponente = -k * t / masa;
        return z0 + (masa / k) * v0Z * (1 - Math.pow(Math.E, exponente));
    }
}