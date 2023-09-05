/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.punto2;

public class ListaDobleEnlace {

    private NodoListaDoble inicio;
    private int cantNodos;

    //PRIVATE METHODS

    private NodoListaDoble last() {

        NodoListaDoble nIterador = inicio;

        while (nIterador.getProximo() != null) {

            nIterador = nIterador.getProximo();

        }

        return nIterador;
    }

    private NodoListaDoble getNodeN (int n) {

        NodoListaDoble nodoN = null;

        if ( !(this.es_vacia()) && !(this.longitud() < n) ) {

            nodoN = inicio;

            for (int i = 1; i < n; i++) {

                nodoN = nodoN.getProximo();

            }

        }

        return nodoN;
    }

    //PUBLIC METHODS

    public ListaDobleEnlace () {
        inicio = null;
        cantNodos = 0;
    }


    public boolean es_vacia() {
        return (inicio == null);
    }

    public int longitud () {
        return cantNodos;
    }

    public void agregar (Object data) {

        NodoListaDoble nuevoNodo = new NodoListaDoble();
        nuevoNodo.setData(data);

        if (this.es_vacia()) {

            inicio = nuevoNodo;

        } else {

            NodoListaDoble ultimo = this.last();

            ultimo.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);

        }

        cantNodos++;

    }

    public void borrar (Object data) {

        int eliminados = 0;

        if (this.es_vacia()) {

            System.out.println("Sin elementos eliminables.");

        } else if (cantNodos == 1) { //Sólo un nodo en lista

            if (inicio.getData().equals(data)) {

                inicio = null;
                eliminados++;

            }

        } else {

            while (inicio.getData().equals(data)) { //erases inicio as long as it contains the eliminable data

                inicio = inicio.getProximo();
                inicio.setAnterior(null);
                eliminados++;
                cantNodos--;

            }

            if (cantNodos > 1) {  //No entra si todos, excepto tal vez uno, los nodos a partir del inicio contenian data

                NodoListaDoble nActual = inicio;
                NodoListaDoble nAnterior = inicio;

                while (nActual != null) {

                    if (nActual.getData().equals(data)) {

                        nAnterior.setProximo(nActual.getProximo());
                        nActual = nActual.getProximo();

                        if(nActual != null) {

                            nActual.setAnterior(nAnterior);

                        }

                        eliminados++;
                        cantNodos--;

                    } else {

                        nAnterior = nActual;
                        nActual = nActual.getProximo();

                    }

                }

            }

        }

    }

    public Object recuperar (int posicion) {

        Object data = null;

        if (this.es_vacia()) {

            return data;

        } else if (posicion > cantNodos) {

            System.out.println("Posición inválida");

        } else {

            NodoListaDoble nodoN = this.getNodeN(posicion);
            data = nodoN.getData();

        }

        return data;
    }

    public void agregarEnPosicion (Object data, int posicion) {

        if ( (this.es_vacia()) || (posicion == cantNodos + 1) ) {

            this.agregar(data);

        } else if ( (posicion < 1) || (posicion > cantNodos+1) ) {

            System.out.println("Posicion no valida.");

        } else if (posicion == 1) {

            NodoListaDoble nuevoNodo = new NodoListaDoble();
            nuevoNodo.setData(data);

            nuevoNodo.setProximo(inicio);
            inicio.setAnterior(nuevoNodo);
            inicio = nuevoNodo;

            cantNodos++;

        } else {

            NodoListaDoble nAnterior = this.getNodeN(posicion - 1);
            NodoListaDoble nPosterior = nAnterior.getProximo();

            NodoListaDoble nuevoNodo = new NodoListaDoble();
            nuevoNodo.setData(data);

            nuevoNodo.setProximo(nPosterior);
            nuevoNodo.setAnterior(nAnterior);
            nPosterior.setAnterior(nuevoNodo);
            nAnterior.setProximo(nuevoNodo);

            cantNodos++;

        }


    }

    public String toString () {

        String cadenaLista = new String("Lista: ");
        NodoListaDoble nIterador = inicio;

        for (int i = 0; i < cantNodos; i++) {

            cadenaLista = cadenaLista.concat(nIterador.getData().toString()+" ");
            nIterador = nIterador.getProximo();

        }

        return cadenaLista;
    }

}
