package barcos;

import java.util.Arrays;

/**
 * @author Jordi Gisbert Ferriz
 */
public class BarcoGuerra extends Barco{
    private String[] listadoArmas;
    private int tripulacionMax;
    private int tripulacionActual;
    
    
    public BarcoGuerra(String nombre, String matricula, Data anyoConstruccion, String[] listadoArmas,  int tripulacionMax,  int tripulacionActual) {
        super(nombre, matricula, anyoConstruccion);
        this.tripulacionMax = tripulacionMax;
        aumentarTripulantes(tripulacionActual);
        this.listadoArmas = sinDuplicados(listadoArmas);
    }
    
    public void aumentarTripulantes(int tripulacionActual){
        this.tripulacionActual = (tripulacionActual <= this.tripulacionMax)? tripulacionActual : this.tripulacionMax;
    }
    
    public void aumentarMaximoDeTripulantes(int tripulacionMax){
        this.tripulacionMax = tripulacionMax;
    }
    
    public void anyadirArmamento(String[] listadoArmas){
        this.listadoArmas = sinDuplicados(fusionarArray(this.listadoArmas, listadoArmas));
    }
    
    private static String[] fusionarArray(String[] array1, String[] array2){
        for (int i = 0; i < array2.length; i++) {
            array1 = anyadirFila(array1);
            array1[array1.length-1] = array2[i];
        }
        return array1;
    }
    
    @Override
    public String toString() {
        return  super.toString()+", Armas a bordo: "+Arrays.toString(this.listadoArmas)+", Número de tripulantes: "+this.tripulacionActual;
    }
    
    private static String[] sinDuplicados(String[] array){
        String[] re = new String[1];
        re[0] = array[0];
        for (String array1 : array) {
            boolean no = false;
            for (String re1 : re) {
                if (re1.equals(array1)) {
                    no = true;
                    break;
                }
            }
            if (!no) {
                re = anyadirFila(re);
                re[re.length-1] = array1;
            }
        }
        return re;
    }
    
    private static String[] anyadirFila(String[] array) {
        String[] resultado;
        resultado = new String[array.length+1];
        System.arraycopy(array, 0, resultado, 0, array.length);
        return resultado;
    }
    
    @Override
    public void realizarMantenimiento() {
        super.horasMantenimiento += 300;
    }
    
    
}
