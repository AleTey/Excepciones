
package Entidad;

import java.util.TreeSet;

public class Juego {
    
    private int numAleatorio;
    private int intentos;
    private TreeSet<Integer> numerosElegidos;

    public Juego() {
    }

    public Juego(int numAleatorio, int intentos, TreeSet<Integer> numerosElegidos) {
        this.numAleatorio = numAleatorio;
        this.intentos = intentos;
        this.numerosElegidos = numerosElegidos;
    }

    

    public int getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(int numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public TreeSet<Integer> getNumerosElegidos() {
        return numerosElegidos;
    }

    public void setNumerosElegidos(TreeSet<Integer> numerosElegidos) {
        this.numerosElegidos = numerosElegidos;
    }

    @Override
    public String toString() {
        return "Juego{" + "numAleatorio=" + numAleatorio + ", intentos=" + intentos + ", numerosElegidos=" + numerosElegidos + '}';
    }
    
    

   
    
    
}
