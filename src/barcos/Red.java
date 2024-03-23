package barcos;

/**
 * @author Jordi Gisbert Ferriz
 */
public class Red {
    private TamañoRed tamanyo;
    private MaterialRed material;
    private TipoRed tipo;
    
    public Red(TamañoRed tamanyo, MaterialRed material, TipoRed tipo) {
        this.tamanyo = tamanyo;
        this.material = material;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Red de tamaño "+this.tamanyo+" hecha de "+this.material+" para pesca "+this.tipo;
    }
    
    public boolean isIgual(Red red){
        return (this.tamanyo.equals(red.tamanyo)&&this.material.equals(red.material)&&this.tipo.equals(red.tipo));
    }
}
