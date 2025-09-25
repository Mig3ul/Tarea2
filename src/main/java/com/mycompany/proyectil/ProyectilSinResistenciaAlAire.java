package com.mycompany.proyectil;

public class ProyectilSinResistenciaAlAire extends Proyectil{

    public ProyectilSinResistenciaAlAire(double masa, double v0, double anguloTheta, double anguloPhi, double x0, double y0, double z0) {
        super(masa, v0, anguloTheta, anguloPhi, x0, y0, z0);
    }



    public double alturaMaxima(double t){ 
        //Vz(t) = v0z - gt
        return v0Z - GRAVEDAD * t;
    }

    public double tiempoParaAlturaMax(){
        // tmax = (v0 sin(theta))/g
        return (v0*sinTheta)/GRAVEDAD;
    }

    public double alturaMaximaAlcanzada(){
        // zMax = (v0^2) (sin^2(theta)) / 2g
        return ((v0*v0)*(sinTheta*sinTheta))/2*GRAVEDAD;
    }

    public double tiempoTotalDeVuelo(){
        //tTotal = (2v0 sin(theta))/g
        return (2*v0*sinTheta)/GRAVEDAD;
    }

    public double distanciaHorizontalRecorridaEjeX(){ 
        //Rx = v0 cos(theta) cos(phi)* (2v0 sin(theta)/ g)
        return v0 * cosTheta * cosPhi * ((2 * v0 * sinTheta)/(GRAVEDAD));
    }

    public double distanciaHorizontalRecorridaEjeY(){
        //Ry = v0 cos(theta) sin(Phi) * (2v0 sin(Theta)/g)
        return v0 * cosTheta * sinPhi * ((2 * v0 * sinTheta)/(GRAVEDAD));
    }

    public double alcanceHorizontalMaximo(){
        //R = ((v0^2) sin(2theta)) / g
        //sin(2*theta) = 2 sin(theta) * cos (theta)

        return ((v0*v0) * 2*sinTheta*cosTheta)/GRAVEDAD;

    }




    @Override
    public double calcularPosicionX(double t) {
           // x(t) = x0 + v0x * t
       return this.x0 + this.v0X * t;
    }

    @Override
    public double calcularPosicionY(double t) {
           // y(t) = y0 + v0y * t - 0.5 * g * t^2
       return this.y0 + this.v0Y * t - 0.5 * GRAVEDAD * t * t;
    }

    @Override
    public double calcularPosicionZ(double t) {
           // z(t) = z0 + v0z * t
       return this.z0 + this.v0Z * t;
    }





}