
package Entidad;

import Enum.Estado;
import Interfaz.Usar;

public class Casco implements Usar {
    
    private Estado estado;
    
    
    public Casco() {
    }

    public Casco(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int usar(int intensidad, int tiempo) {
        
        return intensidad * tiempo;
    }

    @Override
    public String toString() {
        return "Casco{" + "estado=" + estado + '}';
    }
    
    
    
    
}
