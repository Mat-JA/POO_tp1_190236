/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto13;

import java.util.ArrayList;
public class Colaborador {

    private String razonSocial;
    private ArrayList<Tarea3_0> tareasRealizadas;

    public Colaborador (String razonSocial) {

        this.razonSocial = razonSocial;
        tareasRealizadas = new ArrayList<Tarea3_0>();

    }

    public void setRazonSocial (String razonSocial) {

        this.razonSocial = razonSocial;

    }

    public String getRazonSocial () {

        return razonSocial;
    }

    public void registrarTarea (Tarea3_0 tarea) {

        tareasRealizadas.add(tarea);

    }

    //No estoy de acuerdo con que esta función siquiera exista, pero consigna dice 'obtener',
    //no 'mostrar'
    public ArrayList<Tarea3_0> getTareas () {

        return tareasRealizadas;
    }

    public String toString () {

        String aMostrar = "\nEl colaborador: " + razonSocial + "\nRealizo las tareas: ";

        for (Tarea3_0 tarea: tareasRealizadas) {

            aMostrar = aMostrar.concat("\n-" + tarea.getDescripcion());

        }

        return aMostrar;
    }

}
