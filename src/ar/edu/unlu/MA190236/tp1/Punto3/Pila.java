/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto3;

public class Pila {

    private int cantNodos = 0;

    private NodoPila inicio = null;

    public boolean es_vacia () {

        return (inicio == null);

    }

    public int longitud () {

        return cantNodos;

    }

    public void apilar (Object data) {

        NodoPila nuevoNodo = new NodoPila();
        nuevoNodo.setData(data);

        if (this.es_vacia()) {

            inicio = nuevoNodo;

        } else {

            nuevoNodo.setProximo(inicio);
            inicio = nuevoNodo;

        }

        cantNodos++;

    }

    public Object desapilar () {

        Object data = null;

        if (this.es_vacia()) {

            System.out.println("No hay elementos para desapilar.");

        } else {

            data = inicio.getData();

            inicio = inicio.getProximo();

            cantNodos--;

        }

        return data;
    }

    public Object recuperarTope () {

        return inicio.getData();

    }

    public String toString () {

        String pila = new String();

        NodoPila pIterador = inicio;

        while (pIterador != null) {

            pila = pila.concat(pIterador.getData() + " ");
            pIterador = pIterador.getProximo();

        }

        return pila;

    }

}
