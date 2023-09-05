/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto3;

public class NodoPila {

    private Object data;
    private NodoPila proximo = null;

    public void setData (Object data) {
        this.data = data;
    }

    public Object getData () {
        return data;
    }

    public void setProximo (NodoPila proximo) {
        this.proximo = proximo;
    }

    public NodoPila getProximo () {
        return proximo;
    }
}
