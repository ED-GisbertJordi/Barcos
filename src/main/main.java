package main;
import barcos.*;

/**
 * @author Jordi Gisbert Ferriz
 */
public class main {
    
    public static void main(String[] args) {
        Barco[] barcos = new Barco[] {
            new BarcoGuerra("Missiling", "AAAA",  new Data("1/1/2012"), new String[]{"Lanza cohetes", "Detector misiles", "Bombardero"}, 0,0),
            new BarcoGuerra("Naviero feroz", "BBBB", new Data("1/1/2013"), new String[]{"Bombardero", "Lanza cohetes", "Detector misiles"}, 0,0),
            new BarcoGuerra("Tiatomic", "CCCC",  new Data("1/1/2014"), new String[]{"Lanza cohetes", "Detector misiles", "Machete"}, 0,0),
            new BarcoGuerra("Hunter", "DDDD",  new Data("1/1/2015"), new String[]{"Lanza granadas", "Detector misiles"}, 0,0),
            new BarcoGuerra("Terrorific", "EEEE",  new Data("1/1/2016"), new String[]{"Bombardero", "Detector misiles"}, 0,0),
            new BarcoPesca("Sardina Express", "SE-123",  new Data("1/1/2005"), 0, 80),
            new BarcoPesca("Pez Payaso", "PP-456", new Data("1/1/2010") , 0, 70),
            new BarcoPesca("Calamar Cautivador", "CC-789",  new Data("1/1/2018"), 0,85),
            new BarcoPesca("Bacalao Bromista", "BB-101", new Data("1/1/2008"), 0, 75),
            new BarcoPesca("Atún Travieso", "AT-234", new Data("1/1/2015"), 0, 65)
        };
        
        // Crear una instancia de Flota y pasar los barcos
        Flota flota = new Flota(barcos);
        
        // Mostrar todos los barcos
        System.out.println("------ Todos Los Barcos --------");
        flota.mostrarBarcos();
        System.out.println("--------------------------------\n\n------ Coste de mantenimiento actual --------");
        
        System.out.printf("El coste total en manteniemiento es %.2f €\n",flota.calculoManteniemiento() );
        System.out.println("------------------------\n\n------ Mantenimiento generalizado --------");
        flota.mantenimientoGeneral();
        System.out.printf("El coste total en mantenimientos es %.2f €\n",flota.calculoManteniemiento() );

        
        System.out.println("\n------ Todos los barcos de guerra --------");
        flota.mostrarBarcosDeGuerra();
        
        System.out.println("\n------ Todos los barcos pesqueros --------");
        flota.mostrarBarcosDePesca();
        
        System.out.println("\n------ Eliminar barco con matrícula PP-456 y mostrar todos los barcos -------");
        flota.eliminarBarco("PP-456");
        flota.mostrarBarcos();
    }
    
}