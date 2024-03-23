package barcos;
import java.time.LocalDate;
import java.util.StringTokenizer;

/**
 *
 * @author Jordi Gisbert Ferriz
 */


public class Data {
    private int dia;
    private int mes;
    private int any;

    private static final String[] DIES_TEXT = new String[] {"diumenge", "dilluns", "dimarts", "dimecres", "dijous", "divendres",
                    "dissabte"};
    private static final String[] MESOS_TEXT = new String[] { "gener", "febrer", "març", "abril", "maig", "juny",
                    "juliol", "agost", "setembre", "octubre", "novembre", "desembre" };

    /**
     *  Constructor por defecto
     *  Inicializa una fecha a dia 1-1-1970
     */
    public Data() {
        LocalDate fechaActual = LocalDate.now();
        this.dia = fechaActual.getDayOfMonth();
        this.mes = fechaActual.getMonthValue();
        this.any = fechaActual.getYear();
    }

    /**
     *  Inicializa la fecha
     *  @param dia de la semana
     *  @param mes del año
     *  @param anyo
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
               * Tienes que utilizar las funciones de *String o consultar la documentación oficial y hacerlo OBLIGATORIAMENTE 
               * con la clase StringTokenizer. 
               * Si el formato recibido no es el correcto, creará la fecha por defecto.
     * @param fecha
     */
    public Data(String data) {
        StringTokenizer token = new StringTokenizer(data, "/");
        int dia = 1;
        int mes = 1;
        int any = 1970;
        if (token.countTokens()==3) {
            dia = Integer.parseInt(token.nextToken());
            mes = Integer.parseInt(token.nextToken());
            any = Integer.parseInt(token.nextToken());
        }

        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    
    @Override
    public String toString() {
        return this.dia+"/"+this.mes+"/"+this.any;
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     */
    public void set(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Obtiene una fecha con los mismos atributos que la fecha actual
     * @return
     */
    public Data clone() {
        return new Data(this.dia, this.mes, this.any);
    }

    /**
     * Devuelve el día de la semana que representa por la Fecha actual
     * @return @dia
     */
    public int getDia() {
            return this.dia;
    }

    /**
     * Devuelve el mes que representa la Fecha actual
     * @return @mes
     */
    public int getMes(){
        return this.mes;
    }

    /**
     * Devuelve el año que representa la Fecha actual
     * @return @mes
     */
    public int getAny(){
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarEnFormatES()  {
        System.out.printf("%02d-%02d-%04d\n", this.dia, this.mes, this.any);
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        System.out.printf("%04d-%02d-%02d\n", this.any,this.mes,this.dia);
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy
     * Ej. 1 enero de 1970
     */
    public void mostrarEnFormatText() {
        System.out.printf("%02d-"+MESOS_TEXT[this.mes-1]+"-%04d\n", this.dia, this.any);
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
     * argumento
     *
     * @return boolean
     */
    public boolean isIgual(Data otraFecha) {
        if (this.dia==otraFecha.dia) {
            if (this.mes==otraFecha.mes) {
                if (this.any==otraFecha.any) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retorna un String que representa el dia de la setmana en format text (dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge).
     * L'algorisme de resolució d'aquest mètode es troba al enunciat.
     * @return String
     */
    public String getDiaSetmana() {
        int a = (14 - this.mes) / 12;
        int y = this.any - a;
        int m = this.mes + 12 * a - 2;
        
        return DIES_TEXT[ (this.dia + y + y/4 - y/100 + y/400 + (31*m)/12) % 7];
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual és festiva. Es considerarà festiu si el dia de la setmana és dissabte o diumenge
     * @return boolean
     */
    public boolean isFestiu() {
        return getDiaSetmana().equals(DIES_TEXT[DIES_TEXT.length-1]) || getDiaSetmana().equals(DIES_TEXT[0] );
    }

    /**
     * Retorna el número de la setmana dins de l'any actual. 
     * Es considera una setmana l'interval de dates entre una data que siga dilluns i la següent data en ordre cronològic que siga diumenge. 
     * També es comptabilitza com a setmana tant la primera setmana de l'any com l'última (inclusivament en aquells anys en què la primera i/o 
     * última setmana no conté set dies en total).
     *
     * @return int dia semana
     */
    public int getNumeroSetmana() {
        return getDiesTranscorregutsEnAny()/7+1;
    }

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant d'afegir el nombre de dies passats com a argument a la data que representa l'objecte actual. 
     * Haurem de tindre en compte els dies que té el mes actual i si l'any és de traspàs (bisiesto) 
     * amb la finalitat de construir el nou objecte amb la data correcta. 
     * El màxim nombre de dies que podrem afegir serà 30 i no podrem afegir un nombre negatiu de dies. 
     *
     * @return boolean
     */
    public Data afegir(int numDias){
        if (numDias>0&&numDias<=30) {
            int dias = this.getDiesTranscorregutsEnAny();
            if (dias+numDias>getDiesAny(this.any)) {
                dias = (dias+numDias)-getDiesAny(this.any);
                return getFechaDeDiasAnyo(numDias-1, this.any+1);
            }
            dias = dias+numDias;
            return getFechaDeDiasAnyo(dias, any);
        }
        return null;
    }

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant de restar el nombre de dies passats com a argument a la data que representa l'objecte actual. 
     * Haurem de tindre en compte els dies que té el mes actual i si l'any és de traspàs (bisiesto) amb la finalitat de construir el nou objecte amb la data correcta.  
     * El màxim nombre de dies que podrem restar serà 30 i no podrem restar un nombre negatiu de dies. 
     * @return boolean
     */
    public Data restar(int numDias){
        if (numDias>0&&numDias<=30) {
            int dias = this.getDiesTranscorregutsEnAny();
            if (dias==numDias) {
                return new Data(1, 1, this.any-1);
            }
            if (dias<numDias) {
                numDias = getDiesAny(this.any-1) - dias;
                return getFechaDeDiasAnyo(numDias, this.any-1);
            }
            dias = dias-numDias;
            return getFechaDeDiasAnyo(dias, any);
        }
        return null;
    }
    
    /*
    * Metodo mio, Calcular Fecha, con dias y año.
    */

    private Data getFechaDeDiasAnyo(int diasTranscurridos, int anyo) {
        int mes;
        for (mes = 1; mes <= 12 && diasTranscurridos > 0; mes++) {
            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    if (diasTranscurridos<=31) {
                        return new Data(diasTranscurridos, mes, anyo);
                    }
                    diasTranscurridos -= 31;
                }
                case 2 -> {
                    if(isBisiesto(anyo)&&diasTranscurridos<=29|| !isBisiesto(anyo)&&diasTranscurridos<= 28){
                        return new Data(diasTranscurridos, mes+1, anyo);
                    }
                    diasTranscurridos -= (isBisiesto(anyo)) ? 29 : 28;
                }
                case 4, 6, 9, 11 -> {
                    if (diasTranscurridos<=30) {
                        return new Data(diasTranscurridos, mes+1, anyo);
                    }
                    diasTranscurridos -= 30;
                }
            }   
        }
        return new Data(diasTranscurridos, mes - 1, anyo);
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual és correcta. 
     * No oblides comprovar que el dia es trobe dins del rang dels dies que té el mes tenint en compte si l'any és de traspàs(bisiesto) o no.
     * @return 
     */
    public boolean isCorrecta(){
        if (this.any>0) {
            if (this.mes>=1&&this.mes<=12) {
                if (this.dia>0) {
                    switch (this.mes) {
                        case 1,3,5,7,8,10,12 -> {
                            return (this.dia<=31);
                        }
                        case 2 -> {
                            if (isBisiesto(this.any)) {
                                return (this.dia<=29);
                            }else{
                                return (this.dia<=28);
                            }
                        }
                        case 4,6,9,11 -> {
                            return (this.dia<=30);
                        }
                    }
                } 
            }             
        }
        return false;
    }

    /**
     * Retorna el mes del año en formato text (enero, febrero, marzo,...)
     * @return char
     */
    private String getMesEnFormatText() {
        return MESOS_TEXT[this.mes-1];
    }

    /**
     * Devuelve el número de dias transcurridos desde el 1-1-1
     *
     * @return int
     */
    private int getDiesTranscorregutsOrigen() {
        int bisiestos = 0;
        for (int y = 1; y <= this.any; y++) {
            if (isBisiesto(y)) {
                bisiestos++;
            }
        }
        return (this.any-1)*365+(bisiestos)+(this.dia-1);
    }

    /**
     * Devuelve el número de dias transcurridos en el anyo que representa el objeto
     *
     * @return int
     */
    private int getDiesTranscorregutsEnAny() {
        int dias = 0;
        for (int i = 1; i < this.mes; i++) {
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> dias += 31;
                case 2 -> dias += (isBisiesto(this.any)) ? 29 : 28;
                case 4, 6, 9, 11 -> dias += 30;
            }
        }
        return dias+this.dia;
    }

    /**
     * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si es divisible por 4
     * pero no es divisible entre 100 o es divisible entre 4 entre 100 y entre 400
     *
     * @return boolean
     */
    public static boolean isBisiesto(int anyo){
        return anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0);
    }

    /**
     *  Calcula el número de días que tiene el @mes en el @año pasado como argumento
     *  Deberás hacer uso del métodos isBisiesto
     *
     *  @return int total dias mes en curso
     */
    public static int getDiesMes (int mes, int anyo) {
        return switch (mes) {
            case 1,3,5,7,8,10,12 -> 31;
            case 2 -> (isBisiesto(anyo)? 29:28);
            case 4,6,9,11 -> 30;
            default -> -1;
        };
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @return int total dias anyo en curso
     */
    public static int getDiesAny (int anyo){
        return (isBisiesto(anyo)? 366:365);
    }
}
