package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class Fecha {

   private int dia;
    private int mes;
    private int anno;
    /*  un atributo estatico cambia cambia el valor que diagos en todos los objetos de la misma clase.
     Comparten esa información.*/
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anno = a;
    }

    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;//PONEMOS +1 POR FEBRERO. PARA QUE PONGA EN VEZ DE MES 1, MES 2
        anno = c.get(Calendar.YEAR);
    }

    /* public void cambio() {
        diasMes[1] = 77;
    }*/
    public void bisiesto() {
        if ((anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int anno) {
        if ((anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     * Comprueba la fecha correcta
     *
     * @param d es el día del mes
     * @param m es el mes del año
     * @param a es el año
     * @return nos devuelve si es correcto o no
     */
    public boolean comprobarFecha(int a, int m, int d) {
        boolean resultado = false;
        if (a > 1900 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                /*Ponemos ",-1" porque el array va desde la posición 0 a la 11, es decir,
                 que si metemos la fecha 12-2-2015, nos va a llevar a la posción 3
                 del array que corresponde al mes Marzo. Por eso restamos -1, para que si ponemos mes 2,
                 nos diga que es febreoo y no marzo*/
                if (d >= 1 && d <= diasMes[m - 1]) {
                    resultado = true;
                    dia = d;
                    mes = m;
                    anno = a;
                }
            }
        }
        return resultado;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    /**
     * Te compara dos fechas. Te compara el dia, mes y año de cada fecha
     *
     * @param f objeto de tipo clase Fechas
     * @return devuelve el rsultado final de la comparación
     */
    public int compararFechas(Fecha f) {
        int resultado;
        if (anno > f.getAnno()) {
            resultado = 1;
            /*f.* es la fecha actual y anno es la fecha que introduce el usuario*/
        } else if (anno < f.getAnno()) {
            resultado = -1;
        } else if (mes > f.getMes()) {
            resultado = 1;
        } else if (mes < f.getMes()) {
            resultado = -1;
        } else if (dia > f.getDia()) {
            resultado = 1;
        } else {
            resultado = -1;
        }
        return resultado;
    }

    public int calcularAnnos(int annos,int mess,int dias) {
        Fecha f = new Fecha();
        annos = f.getAnno() - anno;
        if (f.getMes() < mess || f.getMes() == mess && f.getDia() < dias) {
            annos--;
        }
        return annos;
    }

    public int calcularTrienios(int annos) {
        annos = calcularAnnos(anno,mes,dia);
        int trienios;
        trienios = annos / 3;
        return trienios;
    }
}
