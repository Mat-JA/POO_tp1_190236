/*
 *
 */

package ar.edu.unlu.MA190236.tp1.Punto11;

import java.util.ArrayList;

public class Jugador {

    private String nick;
    private int puntaje;
    private ArrayList<String> palabras;

    //CONSTRUCTORES
    public Jugador() {

        puntaje = 0;
        palabras = new ArrayList<String>();

    }

    public Jugador(String nick) {

        this.nick = nick;
        puntaje = 0;
        palabras = new ArrayList<String>();

    }

    //SETTERS Y GETTERS
    public void setNick (String nick) {

        this.nick = nick;

    }

    public String getNick () {

        return nick;
    }

    public int getPuntaje () {

        return puntaje;
    }

    public String getPalabraN (int n) {

        String palabra = null;

        if ((n < 1) | (n > palabras.size())) {

            System.out.println("Posición no válida.");

        } else {

            palabra = palabras.get(n-1);

        }

        return palabra;
    }

    //METODOS PUBLICOS
    public void formarPalabra (String palabra, int puntaje) {

        palabras.add(palabra);
        this.puntaje += puntaje;

    }

}
