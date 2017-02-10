package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class Fecha {

    int dias;
    int mes;
    int anno;

    public Fecha(int dias, int mes, int anno) {
        this.dias = dias;
        this.mes = mes;
        this.anno = anno;
    }

    public Fecha() {
        /*Con esta clase (la clase Calendar) que ya tiene java incluida, tomamos la fecha actual del sistema.*/
        Calendar c = new GregorianCalendar();
        dias = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        anno = c.get(Calendar.YEAR);
    }

}
