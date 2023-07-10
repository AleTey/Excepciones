
package Entidad;

import Enum.Estado;
import Interfaz.Usar;
import Excepciones.EnergiaInsuficienteException;


public class Bota implements Usar{

    private Estado estado;
    private String lado;
    static int CONSUMO_ENERGIA_BASICA = 100;

    public Bota() {
    }

    public Bota(Estado estado) {
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
    
    
    
    public void caminar(Armadura armadura, int tiempo) throws EnergiaInsuficienteException{
       int energiaGastada = usar(1, tiempo);
       if(energiaGastada > armadura.getGenerador()) {
           throw new EnergiaInsuficienteException();
       }
        System.out.println("ENERGIA GASTADA: " + usar(1, tiempo));
       armadura.setGenerador(armadura.getGenerador() - energiaGastada);
    }
    
    @Override
    public int usar(int intensidad, int tiempo) {
        
        return CONSUMO_ENERGIA_BASICA * intensidad * tiempo;
    }

    @Override
    public String toString() {
        return "Bota "  + lado + " {" + "estado=" + estado + '}';
    }
    
    
    
}
