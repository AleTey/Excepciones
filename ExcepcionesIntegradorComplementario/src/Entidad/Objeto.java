
package Entidad;

public class Objeto {
    
    private int coorX;
    private int coorY;
    private int coorZ;
    private boolean hostil;
    private double resistencia;

    public Objeto() {
    }

    public Objeto(int coorX, int coorY, int coorZ, boolean hostil, int resistencia) {
        this.coorX = coorX;
        this.coorY = coorY;
        this.coorZ = coorZ;
        this.hostil = hostil;
        this.resistencia = resistencia;
    }

    public int getCoorX() {
        return coorX;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public int getCoorZ() {
        return coorZ;
    }

    public void setCoorZ(int coorZ) {
        this.coorZ = coorZ;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Objeto" 
                +"Posicion: "+ "X=" + coorX + ", Y=" + coorY + ", Z=" + coorZ 
                + ", hostil=" + hostil 
                + ", resistencia=" + resistencia;
    }
    
    
    
}
