/* GLORIA UT DEUS
 * conatus me
 */

package ar.edu.unlu.MA190236.tp1.Punto9;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class OperacionesFecha {

     //La resolución está basada en lo que vimos con el profesor en la clase del día 29/08/2023

     public LocalDate unaFecha (String fecha, int formato) {

         LocalDate fechaExtraida = null;

         if ( (formato != 1) & (formato != 2) ) {

             System.out.println("Formato inválido.");

         } else {

             DateTimeFormatter formatos[] = {DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                                             DateTimeFormatter.ofPattern("MM-dd-yyyy")};

             if (formato == 1) {

                 fechaExtraida = LocalDate.parse(fecha, formatos[0]);

             } else {

                 fechaExtraida = LocalDate.parse(fecha, formatos[1]);

             }

         }

         return fechaExtraida;

     }

     public static boolean estaEntreDos (LocalDate fechaMenor, LocalDate fechaMayor, LocalDate verificar) {

        return (esMenor(fechaMayor, verificar) & esMayor(fechaMenor, verificar));
     }

        public static boolean esMenor (LocalDate fechaMayor, LocalDate verificar) {

            return verificar.isBefore(fechaMayor);

        }

        public static boolean esMayor (LocalDate fechaMenor, LocalDate verificar) {

            return verificar.isAfter(fechaMenor);

        }


    //lo que sigue es el diseño que hice de fecha previo a ver lo de java.time
    //Desestimar (Además de que elimine los import correspondientes).

    /*
    private int dia;
    private int mes;
    private int anio;

    //------------------------------METODOS PRIVADOS------------------------------

    private void recibirAnio() {

        anio = 0;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Ingrese el anio de la fecha:");
            anio = sc.nextInt();

        } while ( !(verificarAnio(anio)) );

    }

    private void recibirMes() {

        mes = 0;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Ingrese el mes de la fecha[1-12]:");
            mes = sc.nextInt();

        } while ( !(verificarMes(mes)) );

    }

    private void recibirDia() {

        dia = 0;

        Scanner sc = new Scanner(System.in);

        int limiteDia = calcularLimiteDia(); //No es lo más limpio junto con verificarDia, pero lo requiere el souf.

        do {

            System.out.printf("Ingrese el día de la fecha[1-%d]: ", limiteDia);
            dia = sc.nextInt();

        } while ( !(verificarDia(dia)) );

    }

    private int calcularLimiteDia() {

        int limiteDia = 31;

        if (mes == 2) {

            limiteDia = limiteDiaFebrero();

        } else if ((mes == 4) | (mes == 6) | (mes == 9) | (mes == 11)) {

            limiteDia = 30;

        }

        return limiteDia;

    }

    private int limiteDiaFebrero() {

        int limiteDia = 0;

        if (anio%4 == 0) {

            limiteDia = 29;

        } else {

            limiteDia = 28;

        }

        return limiteDia;

    }

    private boolean verificarAnio(int anio) {

        return (anio >= 0);
    }

    private boolean verificarMes(int mes) {

        return ((mes > 0) & (mes < 13));
    }

    private boolean verificarDia(int dia) {

        int limiteDia = calcularLimiteDia();

        return ((dia > 0) & (dia <= limiteDia));

    }

    private boolean verificarFecha() {

        boolean fechaValida = true;

        if ( !(verificarAnio(anio)) | !(verificarMes(mes)) | !(verificarDia(dia)) ) {

            fechaValida = false;

        }

        return fechaValida;
    }

    //------------------------------CONSTRUCTORES------------------------------

    public Fecha() {

        recibirAnio();
        recibirMes();
        recibirDia();

    }

    public Fecha(int dia, int mes, int anio) {

        if ((verificarAnio(anio)) & (verificarMes(mes)) & (verificarDia(dia))) {

            this.anio = anio;
            this.mes = mes;
            this.dia = dia;

        } else {

            System.out.println("Parámetros incorrectos.");

        }


    }

    //------------------------------SETTERS Y GETTERS------------------------------
    public int getAnio() {

        return anio;
    }

    public int getMes() {

        return mes;
    }

    public int getDia() {

        return dia;
    }

    //------------------------------METODOS PUBLICOS------------------------------

    public boolean equals (Fecha fecha) {

        boolean mismaFecha = true;

        if ( (this.anio != fecha.getAnio() ) | ( this.mes != fecha.getMes() ) | ( this.dia != fecha.getDia() ) ) {

            mismaFecha = false;

        }

        return mismaFecha;

    }


    public Fecha stringAFecha (String cadenaFecha, int formato) {

        int anio = 0;
        int mes = 0;
        int dia = 0;

        anio = parseInt(cadenaFecha.substring(7, 10));

        if (formato == 1) {

            dia = parseInt(cadenaFecha.substring(1, 2));
            mes = parseInt(cadenaFecha.substring(4, 5));

        } else if (formato == 2) {

            mes = parseInt(cadenaFecha.substring(1, 2));
            dia = parseInt(cadenaFecha.substring(4, 5));

        } else {

            System.out.println("Formato inválido.");

        }

        return new Fecha(dia, mes, anio);

    }

    public String toString () {

        String fecha = new String();
        fecha = dia + "-" + mes + "-" + anio;

        return fecha;
    }

    public boolean esValida () {

        return verificarFecha();
    }

    public boolean menorA (Fecha fechaComparacion) {

        boolean esMenor = false;

        if (anio < fechaComparacion.getAnio()) {

            esMenor = true;

        } else if ((anio == fechaComparacion.getAnio()) & (mes < fechaComparacion.getMes())) {

            esMenor = true;

        } else if ( (anio == fechaComparacion.getAnio()) & (mes == fechaComparacion.getMes()) & (dia < fechaComparacion.getDia()) ) {

            esMenor = true;

        }

        return esMenor;
    }

    public boolean mayorA (Fecha fechaComparacion) {

        boolean esMayor = true;

        if (anio > fechaComparacion.getAnio()) {

            esMayor = true;

        } else if ( (anio == fechaComparacion.getAnio()) & (mes > fechaComparacion.getMes()) ) {

            esMayor = true;

        } else if ( (anio == fechaComparacion.getAnio()) & (mes == fechaComparacion.getMes()) & (dia > fechaComparacion.getDia()) ) {

            esMayor = true;

        }

        return esMayor;
    }

    public boolean estaEntre (Fecha fechaMenor, Fecha fechaMayor) {

        return ( (this.menorA(fechaMenor)) && (this.mayorA(fechaMayor)) );
    }

    */

}
