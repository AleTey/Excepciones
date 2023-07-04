/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionesej05;

import Entidad.Juego;
import Service.JuegoService;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ExcepcionesEj05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        JuegoService js = new JuegoService();

        Juego play = js.crearJuego();
        System.out.println(play.getNumAleatorio());
        boolean gameOver = false;
        int num = -1;
        do {

            System.out.println("numero: " + play.getNumAleatorio());
            System.out.println("Ingentos: " + play.getIntentos());
            TreeSet<Integer> lista = play.getNumerosElegidos();
            for (Integer integer : lista) {
                System.out.print(integer + " ,");
            }
            System.out.println("");
            try {
                System.out.println("Ingrese un numero entre 0 y 500");
                num = sc.nextInt();

                try {
                    js.ronda(play, num);
                    if (num == play.getNumAleatorio()) {
                        System.out.println("GANASTE!!");
                    } else {
                        js.mayorOMenorQ(play, num);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } catch (Exception ex) {
                System.out.println("Caracter erroneo. Debe ingresar un numero entre 0 y 500");
                sc.nextLine();
               
            }
            play.setIntentos(play.getIntentos() + 1);

        } while (!js.gameOver(play, num));

    }

}
