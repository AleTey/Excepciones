
package Servicio;

import Entidad.ClaseConArray;
import java.util.Scanner;


public class ClaseConArrayService {
    
    Scanner sc = new Scanner(System.in);
    
    public void verVector() throws ArrayIndexOutOfBoundsException {
    
        ClaseConArray cca = new ClaseConArray();
        String[] vector = new String[] {"hola","chau","buenas"};
        cca.setArrayPalabras(vector);
        System.out.println("Cuantas palabras contenidas en el vector decea ver? la cantidad maxima es " + vector.length);
        int cant;
        try {
        cant = sc.nextInt() - 1;
        for (int i = 0; i < cant; i++) {
            System.out.println(vector[i]);            
        }
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Numero incorrecto");
        }catch(Exception e) {
            System.out.println("Dato ingresado invalido");
        }
        
    }
}
