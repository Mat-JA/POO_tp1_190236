/* GLORIA UT DEUS
 * conatus me
 */


package ar.edu.unlu.MA190236.tp1.Punto12;

import ar.edu.unlu.MA190236.tp1.Punto10.Tarea2_0;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class AdminTarea {

    private ArrayList<Tarea2_0> tareas;
    int asignadorCodigo; //Se utiliza para asignar un código único a las tareas dentro de tareas

    //METODOS PRIVADOS

    private boolean esTareaValida (Tarea2_0 tarea, ArrayList<Tarea2_0> tareasProcesadas) {

        boolean esValida = true;

        if (!tareasProcesadas.isEmpty()) {

            for (Tarea2_0 tarea2 : tareasProcesadas) {

                if (tarea.equals(tarea2)) {

                    esValida = false;

                }

            }

        }

        if (tarea.vencida()) {

            esValida = false;

        }


        return esValida;
    }

    private void intercambiarTareas (ArrayList<Tarea2_0> tareas, int i) {

        if (tareas.get(i).getPrioridad() < tareas.get(i-1).getPrioridad()) {

            Collections.swap(tareas, i, i-1);

        } else if (tareas.get(i).getPrioridad() == tareas.get(i-1).getPrioridad()) {

            if (tareas.get(i).getFechaRecordatorio().isBefore(tareas.get(i-1).getFechaRecordatorio())) {

                Collections.swap(tareas, i, i-1);

            }

        }

    }

    private void ordenarTareas (ArrayList<Tarea2_0> tareas) {

        for (int i = 0; i < (int) tareas.size(); i++) {

            for (int j = 1; j < (int) tareas.size() - i; j++) {

                intercambiarTareas(tareas, j);

            }

        }

    }

    //CONSTRUCTORES

    public AdminTarea () {

        tareas = new ArrayList<Tarea2_0>();
        asignadorCodigo = 0;

    }

    //METODOS PUBLICOS
    public void crearTarea (LocalDate fechaLimite) {

        asignadorCodigo++;
        tareas.add(new Tarea2_0(fechaLimite, asignadorCodigo));

    }
    public void crearTarea (String descripcion, int prioridad,
                            LocalDate fechaLimite, LocalDate fechaRecordatorio) {

        asignadorCodigo++;
        tareas.add(new Tarea2_0(descripcion, prioridad, fechaLimite,
                                fechaRecordatorio, asignadorCodigo));


    }

    public ArrayList<Tarea2_0> tareasOrdenadas () {

        ArrayList<Tarea2_0> tareasEnOrden = new ArrayList<Tarea2_0>();

        //La resolucion de conflictos segun prioridad se resuelve mediante fecha de vencimiento

        for (Tarea2_0 tarea : tareas) {

            if (esTareaValida(tarea, tareasEnOrden)) {

                tareasEnOrden.add(tarea);

            }

        }

        ordenarTareas(tareasEnOrden);

        return tareasEnOrden;
    }

    public void marcarTareaNCompletada (int n) {

        if ((n < 1) | (n > tareas.size())) {

            System.out.println("Número de tarea no válido.");

        } else {

            tareas.get(n-1).completar();

        }

    }

    public Tarea2_0 buscarTareaPorTitulo (String titulo) {

        Tarea2_0 tareaBuscada = null;
        Tarea2_0 tarea;

        int i = 0;

        while ( (tareaBuscada == null) & (i < tareas.size())) {

            tarea = tareas.get(i);

            if (tarea.getDescripcion().equals(titulo)) {

                tareaBuscada = tarea;

            }

            i++;

        }

        return tareaBuscada;
    }

}
