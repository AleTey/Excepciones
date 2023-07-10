package Service;

import Entidad.Objeto;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ObjetoService {

    Scanner sc = new Scanner(System.in);
    ArmaduraService as = new ArmaduraService();
    static ArrayList<Objeto> listaObjetos = new ArrayList();

    public Objeto crearObjeto() {
        Random rand = new Random();
        int min = 1000;
        int max = 1000;
        int maxZ = 100;
        int x = rand.nextInt(10001) - 5000;
        int y = rand.nextInt(10001) - 5000;
        int z = rand.nextInt(maxZ - 1);
        int n = rand.nextInt(10 - 1);
        boolean hostil;
        if (n % 2 == 0) {
            hostil = true;
        } else {
            hostil = false;
        }
        int resistencia;
        if (hostil) {
            resistencia = rand.nextInt(100 - 60 - 1) + 60;
        } else {
            resistencia = rand.nextInt(100 - 5) + 5;
        }

        return new Objeto(x, y, z, hostil, resistencia);
    }

    public void llenarArraylist() {
//        if(listaObjetos.size() < 10) {
        while (listaObjetos.size() < 10) {
            listaObjetos.add(crearObjeto());
        }
//        }
    }

    public ArrayList getArraylist() {
        llenarArraylist();
        return listaObjetos;
    }
    
    public Objeto seleccionarObjetivo() {
        llenarArraylist();
        for (int i = 0; i < listaObjetos.size(); i++) {
            double distancia = as.getDistancia(listaObjetos.get(i).getCoorX(), listaObjetos.get(i).getCoorY(), listaObjetos.get(i).getCoorZ());
            DecimalFormat formato = new DecimalFormat("#.00");
            String numeroFormateado = formato.format(distancia);
            
            System.out.println(i + ". " +listaObjetos.get(i) + "DISTANCIA: " + numeroFormateado);
        }
        System.out.println("Seleccione objetivo");
        int objeto = sc.nextInt();
        return listaObjetos.get(objeto);
    }
    
    public void objetoEliminado(Objeto objeto) {
        listaObjetos.remove(objeto);
    }
}
