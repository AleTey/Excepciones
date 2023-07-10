
package Entidad;

public class Usuario {
    
    private String Nombre;
    private Armadura armadura;

    public Usuario() {
    }

    public Usuario(String Nombre, Armadura armadura) {
        this.Nombre = Nombre;
        this.armadura = armadura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }
    
    
}
