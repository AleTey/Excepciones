package Entidad;

import Excepciones.ArmaduraDestruidaException;
import Excepciones.EnergiaInsuficienteException;
import Excepciones.GuantesDestruidosException;
import Excepciones.ObjetivoFueraDeAlcanceException;
import Interfaz.Usar;
import Service.ArmaduraService;
import Service.BotaService;
import Service.GuantesService;
import Service.ObjetoService;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Armadura implements Usar {

    private String colorP;
    private String colorS;
    private int resistenciaR;
    private int vida;
    private double generador;
    private Bota botaI;
    private Bota botaD;
    private Guante guanteI;
    private Guante guanteD;
    private Casco casco;

    private ArmaduraService as;
    private BotaService bs;
    private GuantesService gs;
    private ObjetoService os;

    public Armadura(BotaService botaService, GuantesService guanteService) {
        this.bs = new BotaService();
        this.gs = new GuantesService();
    }

    public Armadura() {
    }

    public Armadura(String colorP, String colorS, int resistenciaR, int vida, double generador, Bota botaI, Bota botaD, Guante guanteI, Guante guanteD, Casco casco) {
        this.colorP = colorP;
        this.colorS = colorS;
        this.resistenciaR = resistenciaR;
        this.vida = vida;
        this.generador = generador;
        this.botaI = botaI;
        this.botaI.setLado("I");
        this.botaD = botaD;
        this.botaD.setLado("D");
        this.guanteI = guanteI;
        this.guanteI.setLado("I");
        this.guanteD = guanteD;
        this.guanteD.setLado("D");
        this.casco = casco;
        this.as = new ArmaduraService();
        this.bs = new BotaService();
        this.gs = new GuantesService();
        this.os = new ObjetoService();
    }

    public String getColorP() {
        return colorP;
    }

    public void setColorP(String colorP) {
        this.colorP = colorP;
    }

    public String getColorS() {
        return colorS;
    }

    public void setColorS(String colorS) {
        this.colorS = colorS;
    }

    public int getResistenciaR() {
        return resistenciaR;
    }

    public void setResistenciaR(int resistenciaR) {
        this.resistenciaR = resistenciaR;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getGenerador() {
        return generador;
    }

    public void setGenerador(double generador) {
        this.generador = generador;
    }

    public Bota getBotaI() {
        return botaI;
    }

    public void setBotaI(Bota botaI) {
        this.botaI = botaI;
    }

    public Bota getBotaD() {
        return botaD;
    }

    public void setBotaD(Bota botaD) {
        this.botaD = botaD;
    }

    public Guante getGuanteI() {
        return guanteI;
    }

    public void setGuanteI(Guante guanteI) {
        this.guanteI = guanteI;
    }

    public Guante getGuanteD() {
        return guanteD;
    }

    public void setGuanteD(Guante guanteD) {
        this.guanteD = guanteD;
    }

    public Casco getCasco() {
        return casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    public void caminar(Armadura armadura, int tiempo) throws EnergiaInsuficienteException {
//        if(as.armaduraDaniada(armadura)) {
//            throw new ArmaduraDaniadaException();
//        }
        int gastoEnergia = armadura.getBotaD().usar(1, tiempo) + armadura.getBotaI().usar(1, tiempo);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        armadura.getBotaD().caminar(armadura, tiempo);
        armadura.getBotaI().caminar(armadura, tiempo);
        armadura.bs.botasLuegoDeUso(armadura);
//        bs.botasLuegoDeUso(armadura);
        energiaConsumida(gastoEnergia);
    }

    public void correr(Armadura armadura, int tiempo) throws EnergiaInsuficienteException {
        int gastoEnergia = armadura.getBotaD().usar(2, tiempo) + armadura.getBotaI().usar(2, tiempo);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        armadura.setGenerador(armadura.getGenerador() - gastoEnergia);
        armadura.bs.botasLuegoDeUso(armadura);
        energiaConsumida(gastoEnergia);
    }

    public void propulsarse(Armadura armadura, int tiempo) throws EnergiaInsuficienteException {
        int gastoEnergia = armadura.getBotaD().usar(3, tiempo) + armadura.getBotaI().usar(3, tiempo);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        armadura.setGenerador(armadura.getGenerador() - gastoEnergia);
        armadura.bs.botasLuegoDeUso(armadura);
        energiaConsumida(gastoEnergia);
    }

    public void volar(Armadura armadura, int tiempo) throws EnergiaInsuficienteException {
        int gastoEnergia = armadura.getBotaD().usar(3, tiempo) + armadura.getBotaI().usar(3, tiempo) + armadura.getGuanteD().usar(2, tiempo) + armadura.getGuanteI().usar(2, tiempo);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        armadura.setGenerador(armadura.getGenerador() - gastoEnergia);
        armadura.bs.botasLuegoDeUso(armadura);
        armadura.gs.guantesLuegoDeUso(this.guanteD, this.guanteI);
        energiaConsumida(gastoEnergia);
    }

    public void disparar(Armadura armadura, int tiempo) throws EnergiaInsuficienteException {
        int gastoEnergia = armadura.getGuanteD().usar(3, tiempo) + armadura.getGuanteI().usar(3, tiempo);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        armadura.setGenerador(armadura.getGenerador() - gastoEnergia);
        armadura.gs.guantesLuegoDeUso(guanteD, guanteI);
        energiaConsumida(gastoEnergia);
    }

    public void objetivos() {
        ArrayList<Objeto> listaObjetos = os.getArraylist();
        for (Objeto object : listaObjetos) {
            System.out.println(object.toString());
            double distancia = Math.sqrt(Math.pow(object.getCoorX() - 0, 2) + Math.pow(object.getCoorY() - 0, 2) + Math.pow(object.getCoorZ() - 0, 2));
            System.out.println("DISTANCIA: " + distancia);

        }
    }

    public void atacar(Armadura armadura) throws EnergiaInsuficienteException, InputMismatchException, GuantesDestruidosException, ObjetivoFueraDeAlcanceException {
        if(as.checkDispositivosDestruidos(armadura, 5).size() == 2) {
            throw new GuantesDestruidosException();
        }
        if(as.checkDispositivosDestruidos(armadura, 5).size()== 1) {
            System.out.println("Solo tienes un guante en buen estado, potencia de disparo al 50%");
        }
        Objeto objetivo = os.seleccionarObjetivo();
        if(as.getDistancia(objetivo.getCoorX(), objetivo.getCoorY(), objetivo.getCoorZ()) > 5000) {
            throw new ObjetivoFueraDeAlcanceException();
        }
        int tiempoAtaque = gs.tiempoAtaque();
        int gastoEnergia = armadura.getGuanteD().usar(3, tiempoAtaque) + armadura.getGuanteI().usar(3, tiempoAtaque);
        if (gastoEnergia > armadura.getGenerador()) {
            throw new EnergiaInsuficienteException();
        }
        double distanciaObjetivo = as.getDistancia(objetivo.getCoorX(), objetivo.getCoorY(), objetivo.getCoorZ());
        double danio = gs.danio(1000, distanciaObjetivo, tiempoAtaque);
        if(as.checkDispositivosDestruidos(armadura, 5).size() == 0 && as.checkArmadura(armadura).size() == 0) {
            danio = danio * 2;
        }
        objetivo.setResistencia(objetivo.getResistencia() - danio);
        if (danio > 0 && !objetivo.isHostil()) {
            System.out.println("Estas dañando un objeto neutral");
        }
        if (objetivo.getResistencia() <= 0) {
            System.out.println("------------------");
            System.out.println("OBJETIVO ELIMINADO");
            System.out.println("-------------------");
            os.objetoEliminado(objetivo);
        }
        armadura.setGenerador(armadura.getGenerador() - gastoEnergia);
        armadura.gs.guantesLuegoDeUso(guanteD, guanteI);
        energiaConsumida(gastoEnergia);
    }

    public void energiaConsumida(int energiaConsumida) {
        System.out.println(energiaConsumida);
    }

    @Override
    public int usar(int intencidad, int tiempo) {

        return intencidad * tiempo;
    }

    @Override
    public String toString() {
        return "Armadura"
                + "colorP=" + colorP
                + "\n colorS=" + colorS
                + "\n  resistenciaR=" + resistenciaR
                + "\n  vida=" + vida
                + "\n  generador=" + generador
                + "\n  botaI=" + botaI + ", botaD=" + botaD
                + "\n  guanteI=" + guanteI.toString() + ", guanteD=" + guanteD
                + "\n  casco=" + casco;
    }

}
