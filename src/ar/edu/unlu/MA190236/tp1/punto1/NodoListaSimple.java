/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.punto1;

public class NodoListaSimple {

    private Object data;
    private NodoListaSimple proximo = null;

    public void setData (Object data) {
        this.data = data;
    }

    public Object getData () {
        return data;
    }

    public void setProximo (NodoListaSimple proximo) {
        this.proximo = proximo;
    }

    public NodoListaSimple getProximo () {
        return proximo;
    }

}
