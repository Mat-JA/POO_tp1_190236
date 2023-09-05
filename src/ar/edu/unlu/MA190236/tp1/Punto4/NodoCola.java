/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto4;

public class NodoCola {

    private Object data;
    private NodoCola proximo = null;

    public void setData (Object data) {
        this.data = data;
    }

    public Object getData () {
        return data;
    }

    public void setProximo (NodoCola proximo) {
        this.proximo = proximo;
    }

    public NodoCola getProximo () {
        return proximo;
    }

}
