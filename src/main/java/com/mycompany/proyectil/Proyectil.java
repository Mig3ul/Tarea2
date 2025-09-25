package com.mycompany.proyectil;

public abstract class Proyectil {
    protected double masa;
    protected double v0; 
    protected double anguloTheta, anguloPhi; 
    protected double cosTheta, cosPhi;
    protected double sinTheta, sinPhi;
    protected double v0X, v0Y, v0Z; 
    protected double x0, y0, z0; 
    protected static final double GRAVEDAD = 9.8; 
    
    public Proyectil() {
        this.masa = 0.0;
        this.v0 = 0.0;
        this.anguloTheta = 0.0;
        this.anguloPhi = 0.0;
        this.x0 = 0.0;
        this.y0 = 0.0;
        this.z0 = 0.0;

        this.cosTheta = Math.cos(Math.toRadians(0.0)); 
        this.sinTheta = Math.sin(Math.toRadians(0.0));
        this.cosPhi = Math.cos(Math.toRadians(0.0));   
        this.sinPhi = Math.sin(Math.toRadians(0.0));   
        
        this.v0X = 0.0;
        this.v0Y = 0.0;
        this.v0Z = 0.0;
    }

    public Proyectil(double masa, double v0, double anguloTheta, double anguloPhi, 
                    double x0, double y0, double z0) {
        this.masa = masa;
        this.v0 = v0;
        this.anguloTheta = anguloTheta; 
        this.anguloPhi = anguloPhi; 
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        
        double thetaRad = Math.toRadians(anguloTheta);
        double phiRad = Math.toRadians(anguloPhi);
        this.cosTheta = Math.cos(thetaRad);
        this.sinTheta = Math.sin(thetaRad);
        this.cosPhi = Math.cos(phiRad);
        this.sinPhi = Math.sin(phiRad);

        this.v0X = v0 * cosTheta * cosPhi;
        this.v0Y = v0 * cosTheta * sinPhi;
        this.v0Z = v0 * sinTheta;
    }



    //getters
    public double getMasa() { return masa; }
    public double getV0() { return v0; }
    public double getAnguloTheta() { return anguloTheta; }
    public double getAnguloPhi() { return anguloPhi; }
    public double getCosTheta() { return cosTheta; }
    public double getCosPhi() { return cosPhi; }
    public double getSinTheta() { return sinTheta; }
    public double getSinPhi() { return sinPhi; }
    public double getV0X() { return v0X; }
    public double getV0Y() { return v0Y; }
    public double getV0Z() { return v0Z; }
    public double getX0() { return x0; }
    public double getY0() { return y0; }
    public double getZ0() { return z0; }
    public static double getGravedad() { return GRAVEDAD; }
    


    //setters
    public void setMasa(double masa) { 
        this.masa = masa; 
    }
    public void setV0(double v0) { 
        this.v0 = v0; 
        this.v0X = v0 * cosTheta * cosPhi;
        this.v0Y = v0 * cosTheta * sinPhi;
        this.v0Z = v0 * sinTheta;
    }
    public void setAnguloTheta(double anguloTheta) { 
        this.anguloTheta = anguloTheta;
        double thetaRad = Math.toRadians(anguloTheta);
        this.cosTheta = Math.cos(thetaRad);
        this.sinTheta = Math.sin(thetaRad);
        this.v0X = v0 * cosTheta * cosPhi;
        this.v0Y = v0 * cosTheta * sinPhi;
        this.v0Z = v0 * sinTheta;
    }
    public void setAnguloPhi(double anguloPhi) { 
        this.anguloPhi = anguloPhi;
        double phiRad = Math.toRadians(anguloPhi);
        this.cosPhi = Math.cos(phiRad);
        this.sinPhi = Math.sin(phiRad);
        this.v0X = v0 * cosTheta * cosPhi;
        this.v0Y = v0 * cosTheta * sinPhi;
        this.v0Z = v0 * sinTheta;
    }
    public void setX0(double x0) { this.x0 = x0; }
    public void setY0(double y0) { this.y0 = y0; }
    public void setZ0(double z0) { this.z0 = z0; }





    public void calculoVelocidadesIniciales() {
        this.v0X = v0 * cosTheta * cosPhi;
        this.v0Y = v0 * cosTheta * sinPhi;
        this.v0Z = v0 * sinTheta;
    }
    
    public abstract double calcularPosicionX(double t);
    public abstract double calcularPosicionY(double t);
    public abstract double calcularPosicionZ(double t);
    
    public void calcularTrayectoria(double[] tiempos, double[] posX, double[] posY, double[] posZ) {
        for (int i = 0; i < tiempos.length; i++) {
            posX[i] = calcularPosicionX(tiempos[i]);
            posY[i] = calcularPosicionY(tiempos[i]);
            posZ[i] = calcularPosicionZ(tiempos[i]);
        }
    }


    


}