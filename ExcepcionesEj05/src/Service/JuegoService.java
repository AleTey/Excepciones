package Service;

import Entidad.Juego;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class JuegoService {

    Scanner sc = new Scanner(System.in);

    public Juego crearJuego() {

        Random rand = new Random();

        int numAleatorio = rand.nextInt(500);

        TreeSet<Integer> numerosElegidos = new TreeSet();

        return new Juego(numAleatorio, 0, numerosElegidos);

    }

    public void ronda(Juego juego, int num) throws IllegalArgumentException {

        if (num < 0 || num > 500 || juego.getNumerosElegidos().contains(num)) {

            throw new IllegalArgumentException("El numero se encuentra fuera del rango o ya fue ingresado");
        }
        juego.getNumerosElegidos().add(num);

    }

    public boolean gameOver(Juego juego, int num) {

        boolean gameOver = false;
        if (num == juego.getNumAleatorio()) {
            gameOver = true;
        }
        return gameOver;
    }

    public void mayorOMenorQ(Juego juego, int num) {

        if (num < juego.getNumAleatorio()) {
            System.out.println("El numero X es mayor que " + num);
        } else {
            System.out.println("El numero X es menor que " + num);
        }
    }

}
