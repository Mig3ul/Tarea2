public class Proyectil {
    protected double masa;
    protected double velocidadInicial;
    protected double posicionInicialX;
    protected double posicionInicialY;
    protected double posicionInicialZ;
    protected double anguloElevacion;
    protected double anguloHorizontal;
    protected double velocidadInicialX;
    protected double velocidadInicialY;
    protected double velocidadInicialZ;
    protected double gravedad;

    public Proyectil(double anguloElevacion, double anguloHorizontal, double gravedad, double masa, double posicionInicialX, double posicionInicialY, double posicionInicialZ, double velocidadInicial, double velocidadInicialX, double velocidadInicialY, double velocidadInicialZ) {
        this.anguloElevacion = anguloElevacion;
        this.anguloHorizontal = anguloHorizontal;
        this.gravedad = gravedad;
        this.masa = masa;
        this.posicionInicialX = posicionInicialX;
        this.posicionInicialY = posicionInicialY;
        this.posicionInicialZ = posicionInicialZ;
        this.velocidadInicial = velocidadInicial;
        this.velocidadInicialX = velocidadInicialX;
        this.velocidadInicialY = velocidadInicialY;
        this.velocidadInicialZ = velocidadInicialZ;
    }

    public void calcularVelocidadesIniciales(){
        
    }

}
