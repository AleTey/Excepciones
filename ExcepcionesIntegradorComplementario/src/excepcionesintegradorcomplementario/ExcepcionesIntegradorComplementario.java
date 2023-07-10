/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionesintegradorcomplementario;

import Entidad.Armadura;
import Entidad.Bota;
import Entidad.Casco;
import Entidad.Guante;
import Enum.Estado;
import Excepciones.ArmaduraDestruidaException;
import Service.ArmaduraService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Excepciones.EnergiaInsuficienteException;
import java.util.InputMismatchException;
import Excepciones.ArmaduraNullException;
import Excepciones.GuantesDestruidosException;
import Excepciones.ObjetivoFueraDeAlcanceException;
import Service.BotaService;
import Service.GuantesService;

public class ExcepcionesIntegradorComplementario {

    ArmaduraService as = new ArmaduraService();
    BotaService bs = new BotaService();
    GuantesService gs = new GuantesService();

    Scanner sc = new Scanner(System.in);
//    static TreeSet<Armadura> listaArmaduras = new TreeSet();
    static ArrayList<Armadura> listaArmaduras = new ArrayList();

    public static void main(String[] args) {

        Bota botaI1 = new Bota(Estado.OPTIMO);
        Bota botaD1 = new Bota(Estado.OPTIMO);
        Guante guanteI1 = new Guante(Estado.OPTIMO);
        Guante guanteD1 = new Guante(Estado.OPTIMO);
        Casco casco = new Casco(Estado.OPTIMO);
        Armadura armaduraOriginal = new Armadura("Rojo", "Amarillo", 80, 100, 10000000, botaI1, botaD1, guanteI1, guanteD1, casco);
//Float.MAX_VALUE
        listaArmaduras.add(armaduraOriginal);

        menuPrincipal();
    }

    public static void menuPrincipal() {

        System.out.println("MAIN MENU");
        System.out.println("----------");
        Scanner sc = new Scanner(System.in);
        Armadura armaduraElegida = null;
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Escoger Armadura");
            System.out.println("2. Crear nueva armadura");
            System.out.println("3. Usar Armadura");
            int option = 0;
            try {
                option = sc.nextInt();
            } catch (NumberFormatException nfe) {
                System.out.println("Caracter erroneo");
            }

            switch (option) {
                case 1:

//                    List<Armadura> armaduras = new ArrayList(listaArmaduras);
                    for (Armadura armadura : listaArmaduras) {
                        System.out.println(listaArmaduras.indexOf(armadura));
                        System.out.println(armadura.toString());

                    }
                    int opcionArmadura = 0;

                    System.out.println("Elija una armadura");
                    opcionArmadura = sc.nextInt();
                    try {
                        armaduraElegida = listaArmaduras.get(opcionArmadura);
                        System.out.println(armaduraElegida.toString());
                    } catch (IndexOutOfBoundsException ioobe) {
                        System.out.println("Dato invalido");
                    }
                    break;
                case 2:

                    break;
                case 3:
                    try {
//                        usarArmadura = true;
                        menuAcciones(armaduraElegida);
                    } catch (ArmaduraNullException ane) {
                        System.out.println(ane.getMessage());
//                        System.out.println("ACAA");
//                        usarArmadura = false;
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Opcion invalida");
                    }
                    break;
                case 4:
                    exit = true;
            }
        }
    }

    public static void menuAcciones(Armadura armadura) throws ArmaduraNullException, EnergiaInsuficienteException, InputMismatchException {

        Scanner sc = new Scanner(System.in);
        ArmaduraService as = new ArmaduraService();
        GuantesService gs = new GuantesService();

        if (armadura == null) {
            throw new ArmaduraNullException();
        }

        boolean volverPrincipal = false;

        while (!volverPrincipal) {
            System.out.println("");
            System.out.println("");
            System.out.println("       MENU ACCIONES");
            System.out.println("       -------------");

            System.out.println("1. Caminar");
            System.out.println("2. Correr");
            System.out.println("3. Propulsarse");
            System.out.println("4. Volar");
            System.out.println("5. Disparar con los guantes");
            System.out.println("6. Pedir estado de la armadura");
            System.out.println("7. Ver objetos");
            System.out.println("8. Atacar");
            System.out.println("9. Volver al menu principal");

            int option = sc.nextInt();

            switch (option) {
// LA EXCEPTION DE ARMADURA DANIADA SE LANZA EN ARMADURA.SERVICE ANTES DE PEDIR EL TIEMPO DE USO DEL METODO
                case 1:

                    if (!as.checkArmadura(armadura).isEmpty()) {
                        as.repararArmadura(armadura);
                    }
                    try {
                        armadura.caminar(armadura, as.tiempoDeAccion(armadura, 1));
                    } catch (InputMismatchException ime) {
                        System.out.println("Dato ingresado invalido");
                        sc.nextLine();
                    } catch (ArmaduraDestruidaException ade) {
                        System.out.println(ade.getMessage());
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 2:

                    if (!as.checkArmadura(armadura).isEmpty()) {
                        as.repararArmadura(armadura);
                    }
                    try {
                        armadura.correr(armadura, as.tiempoDeAccion(armadura, 2));
                    } catch (InputMismatchException ime) {
                        System.out.println("Dato ingresado invalido");
                        sc.nextLine();
                    } catch (ArmaduraDestruidaException ade) {
                        System.out.println(ade.getMessage());
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 3:

                    if (!as.checkArmadura(armadura).isEmpty()) {
                        as.repararArmadura(armadura);
                    }
                    try {
                        armadura.propulsarse(armadura, as.tiempoDeAccion(armadura, 3));
                    } catch (InputMismatchException e) {
                        System.out.println("Error en dato ingresado");
                    } catch (ArmaduraDestruidaException ade) {
                        System.out.println(ade.getMessage());
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 4:

                    if (!as.checkArmadura(armadura).isEmpty()) {
                        as.repararArmadura(armadura);
                    }
                    try {
                        armadura.volar(armadura, as.tiempoDeAccion(armadura, 4));
                    } catch (ArmaduraDestruidaException ade) {
                        System.out.println(ade.getMessage());
                    } catch (InputMismatchException ime) {
                        System.out.println("Error en dato ingresado");
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 5:

                    if (!as.checkArmadura(armadura).isEmpty()) {
                        as.repararArmadura(armadura);
                    }
                    try {
                        armadura.disparar(armadura, as.tiempoDeAccion(armadura, 5));
                    } catch (ArmaduraDestruidaException ade) {
                        System.out.println(ade.getMessage());
                    } catch (InputMismatchException ime) {
                        System.out.println("Error en dato ingresado");
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 6:
                    as.estadoDeArmadura(armadura);
                    if (as.checkArmadura(armadura).size() > 0) {
                        System.out.println("1. Intentar reparar objetos daniados");
                        System.out.println("2. Volver a menu de acciones");
                        int reparar = sc.nextInt();
                        switch (reparar) {
                            case 1:
                                as.repararArmadura(armadura);
                                as.estadoDeArmadura(armadura);
                                break;
//                            default:
//                                throw new AssertionError();
                        }

                    }
                    break;

                case 7:
                    armadura.objetivos();
                    break;

                case 8:
                    if (!gs.checkGuantesDaniados(armadura).isEmpty()) {
                        gs.repararGuantes(gs.checkGuantesDaniados(armadura));
                    }
                    try {
                        armadura.atacar(armadura);
                    } catch (GuantesDestruidosException gde) {
                        System.out.println(gde.getMessage());
                    } catch (ObjetivoFueraDeAlcanceException ofdae) {
                        System.out.println(ofdae.getMessage());
                    } catch (InputMismatchException ime) {
                        System.out.println("Error en dato ingresado");
                    } catch (EnergiaInsuficienteException eie) {
                        System.out.println(eie.getMessage());
                    } finally {
                        as.dispositivosDaniados(armadura);
                    }
                    break;

                case 9:
                    volverPrincipal = true;
                    break;

            }
        }
    }
}
