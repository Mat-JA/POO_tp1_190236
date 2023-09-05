/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto5;

import java.time.LocalDate;

public class Tarea {

    private String descripcion;
    private int prioridad;
    private boolean completa;
    private LocalDate fechaLimite;

    public Tarea () {

        completa = false;
        fechaLimite = null;

    }

    public Tarea (LocalDate fechaLimite) {

        completa = false;
        this.fechaLimite = fechaLimite;

    }

    public Tarea (String descripcion, int prioridad, LocalDate fechaLimite) {

        this.descripcion = descripcion;
        this.prioridad = prioridad;
        completa = false;
        this.fechaLimite = fechaLimite;

    }

    public void setDescripcion (String descripcion) {

        this.descripcion = descripcion;

    }

    public void setPrioridad (int prioridad) {

        this.prioridad = prioridad;

    }

    public void setFechaLimite(LocalDate fechaLimite) {

        this.fechaLimite = fechaLimite;
    }

    public int getPrioridad () {

        return prioridad;
    }

    public LocalDate getFechaLimite() {

        return fechaLimite;
    }

    public boolean vencida () {

        return ( (!completa) & (LocalDate.now().isAfter(fechaLimite)) );
    }

    public void completar () {

        completa = true;

    }

    public boolean estaCompleta () {

        return completa;
    }

    public String toString () {

        String tarea = descripcion;

        if (this.vencida()) {

            tarea = "(Vencida)... " + descripcion;

        }

        return tarea;
    }

}
