package barcos;

import java.util.Arrays;

/**
 * @author Jordi Gisbert Ferriz
 */
public class BarcoPesca extends Barco{
    private Red[] listadoRedes = new Red[0];
    private double capacidadCargaMetrosCubicos;
    private double porcentajeCapturasExitosas;
    
    
    public BarcoPesca(String nombre, String matricula, Data anyoConstruccion, double capacidadCargaMetrosCubicos, double porcentajeCapturasExitosas) {
        super(nombre, matricula, anyoConstruccion);
        this.capacidadCargaMetrosCubicos = capacidadCargaMetrosCubicos;
        this.porcentajeCapturasExitosas = porcentajeCapturasExitosas;
    }
    
    public void eliminarRed(Red red){
        for (int i = 0; i < this.listadoRedes.length; i++) {
            if (this.listadoRedes[i].isIgual(red)) {
                this.listadoRedes[i] = null;
                break;
            }
        }
    }
    
    public void anyadirNuevaRed(Red red){
        this.listadoRedes = anyadirFila(this.listadoRedes);
        this.listadoRedes[this.listadoRedes.length-1] = red;
    }
    
    private static Red[] anyadirFila(Red[] array) {
        Red[] resultado;
        resultado = new Red[array.length+1];
        System.arraycopy(array, 0, resultado, 0, array.length);
        return resultado;
    }
    
    @Override
    public String toString() {
        return super.toString()+", Redes: "+Arrays.toString(this.listadoRedes)+", Porcentaje de éxito en capturas: "+this.porcentajeCapturasExitosas+"%";
    }
    
    @Override
    public void realizarMantenimiento() {
        for (int i = 0; i < 2; i++) {
            super.realizarMantenimiento();
        }
    }

    
    
    
}
