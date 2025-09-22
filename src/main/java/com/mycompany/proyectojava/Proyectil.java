package com.mycompany.proyectojava;

public abstract class Proyectil {

        protected double masa;
        protected double velocidadInicial; //v0
        protected double v0X, v0Y,v0Z;
        protected double[] posX, pozY, posZ;
        protected double anguloTheta, anguloPhi; //angulo Theta y angulo Phi
        protected double cosenoTheta , cosenoPhi;
        protected double senoTheta, senoPhi;

        protected static final double GRAVEDAD = 9.8; //9.8m/s^2 

        public Proyectil() {
            this.masa = 0.0;
            this.velocidadInicial = 0.0;
            v0X = 0.0;
            v0Y = 0.0;
            v0Z = 0.0;

            this.anguloTheta = Math.toRadians(anguloTheta); //Angulo Theta en radianes
            this.anguloPhi = Math.toRadians(anguloPhi); // Angulo phi en radianes
            this.cosenoTheta = Math.cos(anguloTheta); // coseno de theta 
            this.cosenoPhi = Math.cos(anguloPhi); // coseno de phi

            this.senoTheta = Math.sin(anguloTheta);
            this.senoPhi = Math.sin(anguloPhi);
        }

        

}