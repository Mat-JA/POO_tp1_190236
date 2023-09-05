/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class AdminTarea2_0 {

    private ArrayList<Tarea3_0> tareas;
    private ArrayList<Colaborador> colaboradores;
    int asignadorCodigo; //Se utiliza para adignar un código único a las tareas dentro de tareas

    //METODOS PRIVADOS

    private boolean esTareaValida (Tarea3_0 tarea, ArrayList<Tarea3_0> tareasProcesadas) {

        boolean esValida = true;

        if (!tareasProcesadas.isEmpty()) {

            for (Tarea3_0 tarea2 : tareasProcesadas) {

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

    private void intercambiarTareas (ArrayList<Tarea3_0> tareas, int i) {

        if (tareas.get(i).getPrioridad() < tareas.get(i-1).getPrioridad()) {

            Collections.swap(tareas, i, i-1);

        } else if (tareas.get(i).getPrioridad() == tareas.get(i-1).getPrioridad()) {

            if (tareas.get(i).getFechaRecordatorio().isBefore(tareas.get(i-1).getFechaRecordatorio())) {

                Collections.swap(tareas, i, i-1);

            }

        }

    }

    private void ordenarTareas (ArrayList<Tarea3_0> tareas) {

        for (int i = 0; i < (int) tareas.size(); i++) {

            for (int j = 1; j < (int) tareas.size() - i; j++) {

                intercambiarTareas(tareas, j);

            }

        }

    }

    //CONSTRUCTORES

    public AdminTarea2_0 () {

        tareas = new ArrayList<Tarea3_0>();
        colaboradores = new ArrayList<Colaborador>();
        asignadorCodigo = 0;

    }

    //METODOS PUBLICOS
    public void crearTarea (LocalDate fechaLimite) {

        asignadorCodigo++;
        tareas.add(new Tarea3_0(fechaLimite, asignadorCodigo));

    }
    public void crearTarea (String descripcion, int prioridad,
                            LocalDate fechaLimite, LocalDate fechaRecordatorio) {

        asignadorCodigo++;
        tareas.add(new Tarea3_0(descripcion, prioridad, fechaLimite,
                fechaRecordatorio, asignadorCodigo));


    }

    public void aniadirColaborador (Colaborador colaborador) {

        colaboradores.add(colaborador);

    }

    public String getColaboradorM (int m) {

        String colaborador = "";

        if ((m < 1) | (m > colaboradores.size())) {

            System.out.println("Número de colaborador erróneo.");

        } else {

            colaborador = colaboradores.get(m-1).getRazonSocial();

        }

        return colaborador;

    }

    public ArrayList<Tarea3_0> tareasOrdenadas () {

        ArrayList<Tarea3_0> tareasEnOrden = new ArrayList<Tarea3_0>();

        //La resolucion de conflictos segun prioridad se resuelve mediante fecha de vencimiento

        for (Tarea3_0 tarea : tareas) {

            if (esTareaValida(tarea, tareasEnOrden)) {

                tareasEnOrden.add(tarea);

            }

        }

        ordenarTareas(tareasEnOrden);

        return tareasEnOrden;
    }

    //n posicion en tareas de tarea completada
    //m posicion en colaboradores de colaborador que completa tarea
    public void marcarTareaNCompletada (int n, int m, LocalDate fechaFinalizacion) {

        if ((n < 1) | (n > tareas.size())) {

            System.out.println("Número de tarea no válido.");

        } else if ((m < 1) | (m > colaboradores.size())) {

            System.out.println("Número de colaborador erróneo");

        } else {

            tareas.get(n-1).completar(colaboradores.get(m-1), fechaFinalizacion);
            colaboradores.get(m-1).registrarTarea(tareas.get(n-1));

        }

    }

    //De nuevo, no estoy de acuerdo con esto, pero sigo consigna (ver getTareas() en Colaborador)
    public ArrayList<Tarea3_0> getTareasCompletadasPorM (int m) {

        ArrayList<Tarea3_0> tareas = new ArrayList<Tarea3_0>();

        if ((m < 1) | (m > colaboradores.size())) {

            System.out.println("Número de colaborador erróneo.");

        } else {

            tareas = colaboradores.get(m-1).getTareas();

        }

        return tareas;
    }

    public Tarea3_0 buscarTareaPorTitulo (String titulo) {

        Tarea3_0 tareaBuscada = null;
        Tarea3_0 tarea;

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
