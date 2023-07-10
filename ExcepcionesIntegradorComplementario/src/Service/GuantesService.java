package Service;

import Entidad.Armadura;
import Entidad.Guante;
import Enum.Estado;
import java.util.ArrayList;
import java.util.Scanner;

public class GuantesService {

    Scanner sc = new Scanner(System.in);

    ArmaduraService as = new ArmaduraService();

    public void guantesLuegoDeUso(Guante guanteD, Guante guanteI) {
        if (!guanteD.getEstado().equals(Estado.DESTRUIDO)) {
            if (as.danioPorUso()) {
                guanteD.setEstado(Estado.DAÑADO);
            }
        }
        if (!guanteI.getEstado().equals(Estado.DESTRUIDO)) {
            if (as.danioPorUso()) {
                guanteI.setEstado(Estado.DAÑADO);
            }
        }
    }

    public int tiempoAtaque() {
        System.out.println("Ingrese tiempo de ataque");
        int tiempo = sc.nextInt();
        return tiempo;
    }

    public double danio(int potencia, double distancia, int tiempo) {
        return (potencia / distancia) * tiempo;
    }

    public ArrayList checkGuantesDaniados(Armadura armadura) {
        ArrayList<Guante> guantesDaniados = new ArrayList<>();
        if (armadura.getGuanteD().getEstado().equals(Estado.DAÑADO)) {
            guantesDaniados.add(armadura.getGuanteD());
        }
        if (armadura.getGuanteI().getEstado().equals(Estado.DAÑADO)) {
            guantesDaniados.add(armadura.getGuanteI());
        }
        return guantesDaniados;
    }

    public void repararGuantes(ArrayList<Guante> guantesDaniados) {
        for (Guante guantesDaniado : guantesDaniados) {
            if (as.chancesReparacion()) {
                guantesDaniado.setEstado(Estado.OPTIMO);
            } else {
                guantesDaniado.setEstado(Estado.DESTRUIDO);
            }
        }
    }
}
