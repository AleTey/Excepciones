/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidad.Armadura;
import Entidad.Bota;
import Entidad.Casco;
import Entidad.Guante;
import Interfaz.Usar;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import Enum.Estado;
import Excepciones.ArmaduraDestruidaException;
import java.text.DecimalFormat;

public class ArmaduraService {

    Scanner sc = new Scanner(System.in);

    public int tiempoDeAccion(Armadura armadura, int accion) throws ArmaduraDestruidaException, InputMismatchException {
        if (accion == 1 || accion == 2 || accion == 3 || accion == 4) {
            if (!checkDispositivosDestruidos(armadura, accion).isEmpty()) {
                throw new ArmaduraDestruidaException();
            }
        }
        if(accion == 5) {
            if(checkDispositivosDestruidos(armadura, accion).size() > 1) {
                throw new ArmaduraDestruidaException();
            }
        }
        System.out.println("Cuanto tiempo?");
        int tiempo = sc.nextInt();

        return tiempo;
    }

    public boolean danioPorUso() {

        double probabilidadDeDanio = 0.3;
        Random random = new Random();
        double resultado = random.nextDouble();

        if (resultado <= probabilidadDeDanio) {
            return true;
        } else {
            return false;
        }
    }

    public void estadoDeArmadura(Armadura armadura) {

        System.out.println("INFO ESTADO"
                + "\n Bateria restante: " + armadura.getGenerador() + " " + (armadura.getGenerador() * 100) / 10000000 + "%"
                + "\n Casco: " + armadura.getCasco().getEstado()
                + "\n BotaD: " + armadura.getBotaD().getEstado()
                + "\n BotaI: " + armadura.getBotaI().getEstado()
                + "\n GuanteD: " + armadura.getGuanteD().getEstado()
                + "\n GuanteI: " + armadura.getGuanteI().getEstado());
    }

    public ArrayList checkDispositivosDestruidos(Armadura armadura, int accion) {
        ArrayList<Usar> objetosDestruidos = new ArrayList<>();

        if (accion == 4) {
            if (armadura.getBotaD().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getBotaD());
            }
            if (armadura.getBotaI().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getBotaI());
            }
            if (armadura.getGuanteD().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getGuanteD());
            }
            if (armadura.getGuanteI().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getGuanteI());
            }
        }
        if (accion == 1 || accion == 2 || accion == 3) {
            if (armadura.getBotaD().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getBotaD());
            }
            if (armadura.getBotaI().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getBotaI());
            }
        }
        if (accion == 5) {
            if (armadura.getGuanteD().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getGuanteD());
            }
            if (armadura.getGuanteI().getEstado().equals(Estado.DESTRUIDO)) {
                objetosDestruidos.add(armadura.getGuanteI());
            }
        }
        return objetosDestruidos;
    }

//    public ArrayList checkBotasDestruidas(Armadura armadura) {
//        ArrayList<Bota> botasDestruidas = new ArrayList();
//
//    }

    public ArrayList checkArmadura(Armadura armadura) {
        ArrayList<Usar> objetosDaniados = new ArrayList<>();

        if (armadura.getBotaD().getEstado().equals(Estado.DAÑADO)) {
            objetosDaniados.add(armadura.getBotaD());
        }
        if (armadura.getBotaI().getEstado().equals(Estado.DAÑADO)) {
            objetosDaniados.add(armadura.getBotaI());
        }
        if (armadura.getGuanteD().getEstado().equals(Estado.DAÑADO)) {
            objetosDaniados.add(armadura.getGuanteD());
        }
        if (armadura.getGuanteI().getEstado().equals(Estado.DAÑADO)) {
            objetosDaniados.add(armadura.getGuanteI());
        }

        return objetosDaniados;
    }

    public void dispositivosDaniados(Armadura armadura) {
        if (!checkArmadura(armadura).isEmpty()) {
            ArrayList<Usar> objetosDaniados = checkArmadura(armadura);
            System.out.println("Dispositivos dañados");
            for (Object object : objetosDaniados) {
//                Class<?> bota = Bota.class;
//                Class<?> guante = Guante.class;
//                if (object.getClass().equals(bota) || object.getClass().equals(guante)) {
                System.out.println(object.toString());
//                }el
            }
        }
    }

    public boolean armaduraDaniada(Armadura armadura) {
        if (checkArmadura(armadura).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean chancesReparacion() {
        double probabilidadReparacion = 0.6;
        Random rand = new Random();
        double resultado = rand.nextDouble();
        if (resultado <= probabilidadReparacion) {
            return true;
        } else {
            return false;
        }
    }

    public void repararArmadura(Armadura armadura) {
        ArrayList<Usar> objetosDaniados = checkArmadura(armadura);

        for (Object objeto : objetosDaniados) {
            if (objeto instanceof Bota) {
                Bota objetoBota = (Bota) objeto;
                if (chancesReparacion()) {
                    objetoBota.setEstado(Estado.OPTIMO);
                } else {
                    objetoBota.setEstado(Estado.DESTRUIDO);
                }
            } else if (objeto instanceof Guante) {
                Guante objetoGuante = (Guante) objeto;
                if (chancesReparacion()) {
                    objetoGuante.setEstado(Estado.OPTIMO);
                } else {
                    objetoGuante.setEstado(Estado.DESTRUIDO);
                }
            } else if (objeto instanceof Casco) {
                Casco objetoCasco = (Casco) objeto;
                if (chancesReparacion()) {
                    objetoCasco.setEstado(Estado.OPTIMO);
                } else {
                    objetoCasco.setEstado(Estado.DESTRUIDO);
                }
            }
        }
    }
    
    public double getDistancia(int x, int y, int z) {
        double distancia = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2) + Math.pow(z - 0, 2));
//        DecimalFormat formato = new DecimalFormat("#.00");
//        formato.format(distancia);
        return distancia;
    }
}
