/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.punto2;

public class NodoListaDoble {

    private Object data;
    private NodoListaDoble anterior = null;
    private NodoListaDoble proximo = null;


    public void setData (Object data) {
        this.data = data;
    }

    public Object getData () {
        return data;
    }

    public void setProximo (NodoListaDoble proximo) {
        this.proximo = proximo;
    }

    public NodoListaDoble getProximo () {
        return proximo;
    }

    public void setAnterior (NodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public NodoListaDoble getAnterior () {
        return anterior;
    }

}
