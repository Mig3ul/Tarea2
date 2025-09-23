package com.mycompany.proyectil;

public class ProyectilSinResistenciaAlAire extends Proyectil{

    


    public double calcularPosicionX(){
        return x0[0];
    }

    public double calcularPosicionY(){
        return y0[0];
    }

    public double calcularPosicionZ(){
        return z0[0];
    }

    @Override
    public double calcularPosicionX(double t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double calcularPosicionY(double t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double calcularPosicionZ(double t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
