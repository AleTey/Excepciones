
package Entidad;

import Enum.Estado;
import Interfaz.Usar;


public class Guante implements Usar{

    private Estado estado;
    private String lado;
    static int CONSUMO_ENERGIA_BASICO = 100;

    public Guante() {
    }

    public Guante(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }
    
    
    
    @Override
    public int usar(int intensidad, int tiempo) {
        
        return CONSUMO_ENERGIA_BASICO * intensidad * tiempo;
    }

    @Override
    public String toString() {
        return "Guante " + lado + " {" + "estado=" + estado + '}';
    }
    
    
    
}
