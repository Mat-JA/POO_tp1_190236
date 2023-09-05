/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.punto1;

public class ListaSimpleEnlace {

    private NodoListaSimple inicio;
    private int cantNodos;

    //PRIVATE METHODS

    //Returns the last element of the list
    private NodoListaSimple last() {

        NodoListaSimple nIterador = inicio;

        while (nIterador.getProximo() != null) {

            nIterador = nIterador.getProximo();

        }

        return nIterador;
    }

    //returns node in position n
    //Originalmente lo disenie para erase, pero termine sin necesitarlo
    private NodoListaSimple getNodeN (int n) {

        NodoListaSimple nodoN = null;

        if ( !(this.es_vacia()) && !(this.longitud() < n) ) {

            nodoN = inicio;

            for (int i = 1; i < n; i++) {

                nodoN = nodoN.getProximo();

            }

        }

        return nodoN;
    }

    //PUBLIC METHODS

    public ListaSimpleEnlace () {
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

        NodoListaSimple nuevoNodo = new NodoListaSimple();
        nuevoNodo.setData(data);

        if (this.es_vacia()) {

            inicio = nuevoNodo;

        } else {

            this.last().setProximo(nuevoNodo);

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
                eliminados++;
                cantNodos--;

            }

            if (cantNodos > 1) {  //No entra si todos, excepto tal vez uno, los nodos a partir del inicio contenian data

                NodoListaSimple nActual = inicio;
                NodoListaSimple nAnterior = inicio;

                while (nActual != null) {

                    if (nActual.getData().equals(data)) {

                        nAnterior.setProximo(nActual.getProximo());
                        nActual = nActual.getProximo();
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

            NodoListaSimple nodoN = this.getNodeN(posicion);
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

            NodoListaSimple nuevoNodo = new NodoListaSimple();
            nuevoNodo.setData(data);

            nuevoNodo.setProximo(inicio);
            inicio = nuevoNodo;

            cantNodos++;

        } else {

            NodoListaSimple nAnterior = this.getNodeN(posicion - 1);
            NodoListaSimple nPosterior = nAnterior.getProximo();

            NodoListaSimple nuevoNodo = new NodoListaSimple();
            nuevoNodo.setData(data);

            nuevoNodo.setProximo(nPosterior);
            nAnterior.setProximo(nuevoNodo);

            cantNodos++;

        }


    }

    public String toString () {

        String cadenaLista = new String("Lista: ");
        NodoListaSimple nIterador = inicio;

        for (int i = 0; i < cantNodos; i++) {

            cadenaLista = cadenaLista.concat(nIterador.getData().toString()+" ");
            nIterador = nIterador.getProximo();

        }

        return cadenaLista;
    }

}
