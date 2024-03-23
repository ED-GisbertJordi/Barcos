package barcos;

import java.util.Arrays;
import barcos.*;

/**
 * @author Jordi Gisbert Ferriz
 */
public class Flota {

    Barco[] barcos = new Barco[1];

    public Flota(Barco barcos) {
        this.barcos[0] = barcos;
    }

    public void mantenimientoGeneral(){
        for (Barco barco : barcos) {
            barco.realizarMantenimiento();
        }
    }
    
    public int calculoManteniemiento(){
        int total = 0;
        for (Barco barco : barcos) {
            if (barco instanceof BarcoPesca barcoPesca) {
                total += barcoPesca.horasMantenimiento*4;
            }
            if (barco instanceof BarcoGuerra barcoGuerra) {
                total += barcoGuerra.horasMantenimiento*6;
            }
        }
        return total;
    }
    
    public void mostrarBarcos(){
        System.out.println(Arrays.toString(barcos));
    }
    
    public void mostrarBarcosDeGuerra(){
        for (Barco barco : barcos) {
            if (barco instanceof BarcoGuerra) {
                System.out.println(barco);
            }
        }
    }
    
    public void mostrarBarcosDePesca(){
        for (Barco barco : barcos) {
            if (barco instanceof BarcoPesca) {
                System.out.println(barco);
            }
        }
    }
    
    
    private int buscarBarco(String matricula) {
        for (int i = 0; i < barcos.length; i++) {
            if (barcos[i].equals(new BarcoPesca("comprobador", matricula, new Data(), 0, 0))) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarInfoBarco(String matricula) {
        int indice = buscarBarco(matricula);
        if (indice != -1) {
            System.out.println(barcos[indice]);
        } else {
            System.out.println("No se econtro el Barco con matricula: " + matricula);
        }
    }

    public void eliminarBarco(String matricula) {
        int indice = buscarBarco(matricula);
        if (indice != -1) {
            Object[] ba = (Object[]) barcos;
            ba = borrarLinea(ba, indice);
            if (ba.length != 0) {
                this.barcos = Arrays.copyOf(ba, ba.length, Barco[].class);
            } else {
                this.barcos = new Barco[0];
            }
        }
    }

    public void anyadirBarco(Barco barco) {
        if (!existeBarco(barco)) {
            Object[] ba = (Object[]) barcos;
            Barco[] re = (Barco[]) anyadirFila(ba);
            re[re.length - 1] = barco;
            this.barcos = re;
        }
    }

    private boolean existeBarco(Barco barco) {
        for (Barco barco1 : barcos) {
            if (barco1.equals(barco)) {
                return true;
            }
        }
        return false;
    }

    private static Object[] anyadirFila(Object[] array) {
        Object[] resultado = Arrays.copyOf(array, array.length + 1);
        return resultado;
    }

    public Object[] borrarLinea(Object[] array, int indice) {
        if (indice < 0 || indice >= array.length) {
            return new Object[0];
        }
        Object[] resultado = new Object[array.length - 1];
        int indiceRe = 0;

        for (int i = 0; i < array.length; i++) {
            if (i != indice) {
                resultado[indiceRe++] = array[i];
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Flota: " + Arrays.toString(barcos);
    }

}
