/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto4;

public class Cola {

    private int cantNodos = 0;

    private NodoCola salida = null;

    private NodoCola entrada = null;

    public boolean es_vacia () {

        return (entrada == null);

    }

    public int longitud () {

        return cantNodos;

    }

    public void encolar (Object data) {

        NodoCola nuevoNodo = new NodoCola();
        nuevoNodo.setData(data);

        if (this.es_vacia()) {

            entrada = nuevoNodo;
            salida = nuevoNodo;

        } else {

            nuevoNodo.setProximo(entrada);
            entrada = nuevoNodo;

        }

        cantNodos++;

    }

    public Object desencolar () {

        Object data = null;

        if (this.es_vacia()) {

            System.out.println("no hay elementos para sacar de la cola.");

        } else if (cantNodos == 1) {

            data = salida.getData();
            entrada = null;
            salida = null;

        } else {

            data = salida.getData();

            NodoCola nAnterior = null;
            NodoCola nActual = entrada;

            while (nActual.getProximo() != null ) {

                nAnterior = nActual;
                nActual = nActual.getProximo();

            }

            nAnterior.setProximo(null);
            salida = null;

        }

        if (cantNodos > 0) {

            cantNodos--;

        }

        return data;

    }

    public Object recuperarSalida () {

        return salida.getData();
    }

    public String toString () {

        String cola = new String();

        NodoCola cIterador = entrada;

        while (cIterador != null) {

            cola = cola.concat(cIterador.getData() + " ");
            cIterador = cIterador.getProximo();

        }

        return cola;

    }

}
