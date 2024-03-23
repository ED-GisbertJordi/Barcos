package main;
import barcos.*;

/**
 * @author Jordi Gisbert Ferriz
 */
public class main {
    
    public static void main(String[] args) {
        String[] armas = {"Pepino marino", "Trabuco pepinero"};
        BarcoGuerra ba = new BarcoGuerra("af", "dfs", new Data(),armas, 0, 0);
        Flota fl = new Flota(ba);
        fl.anyadirBarco(ba);
//        System.out.println(fl);
        BarcoGuerra ba2 = new BarcoGuerra("af", "pafs", new Data(),armas, 0, 0);
        fl.anyadirBarco(ba2);
        BarcoPesca ba3 = new BarcoPesca("pesca", "sdfsd", new Data(), 0, 0);
        fl.anyadirBarco(ba3);
//        System.out.println(fl);
//        fl.eliminarBarco("dfs");
//        System.out.println(fl);
//        fl.mostrarInfoBarco("pafs");
//        fl.mostrarBarcosDePesca();
        fl.mantenimientoGeneral();
        fl.mostrarBarcos();
        System.out.println(fl.calculoManteniemiento());
    }
    
}