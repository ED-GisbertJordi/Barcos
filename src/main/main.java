package main;
import barcos.*;

/**
 * @author Jordi Gisbert Ferriz
 */
public class main {
    
    public static void main(String[] args) {
        System.out.println("---- Se crean tres barcos, uno de cada tipo. En el barco de guerra,\ncomprueba que funciona tanto la eliminación de armas repetidas, como la\ncreación de un barco de guerra con más tripulantes actuales que máximo.\nTambién deberás comprobar que el barco pesquero no tiene ninguna red dada de alta ----");
        Barco[] barco = new Barco[3];
       barco[0] = new Barco("La molinera", "XXXX", new Data("1/2/2005"));
        String[] armas = {"Lanza torpedos"};
        barco[1] = new BarcoGuerra("Arrasator", "YYYYY", new Data("1/2/2017"),armas,0,100);
        barco[2] = new BarcoPesca("Faenero", "ZZZZZ", new Data("1/2/2001"),0, 40);
        System.out.println("");
        imprimirBarcos(barco);

        System.out.println("\n\n---- Incrementa las horas de mantenimiento de los tres barcos, y del pesquero una vez más ----\n");
        
        manteniemientoBarcos(barco);
        barco[2].realizarMantenimiento();
        imprimirBarcos(barco);
        
        System.out.println("\n\n---- Añade 2 redes diferentes al barco pesquero y un armamento compuesto\npor 2 armas iguales al barco de guerra, pero diferente a la que ya tiene registrada ----\n");
        String[] armas2 = {"Misil de crucero", "Misil de crucero"};
        BarcoGuerra bG= (BarcoGuerra) barco[1];
        bG.anyadirArmamento(armas2);
        barco[1] = bG;
        System.out.println(barco[1]);
        
        Red r1 = new Red(TamañoRed.mediana,MaterialRed.poliamida, TipoRed.carpfishing);
        Red r2 = new Red(TamañoRed.pequeña,MaterialRed.poliéster, TipoRed.submarina);
        BarcoPesca bP= (BarcoPesca) barco[2];
        bP.anyadirNuevaRed(r1);
        bP.anyadirNuevaRed(r2);
        barco[2] = bP;
        System.out.println(barco[2]);
        
        System.out.println("\n\n---- Barco de pesca después de eliminar su primera red ----\n");
        
        bP.eliminarRed(r1);
        barco[2] = bP;
        System.out.println(barco[2]);
    }
    
    private static void imprimirBarcos(Barco[] barcos){
        for (int i = 0; i < barcos.length; i++) {
            System.out.println(barcos[i]);
        }
    }
    
    private static void manteniemientoBarcos(Barco[] barcos){
        for (int i = 0; i < barcos.length; i++) {
            barcos[i].realizarMantenimiento();
        }
    }
    
}