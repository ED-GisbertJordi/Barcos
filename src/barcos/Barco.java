package barcos;

/**
 * @author Jordi Gisbert Ferriz
 */
public abstract class Barco{
    protected String nombre;
    protected String matricula;
    protected Data anyoConstruccion;
    protected Data anyoAdquisicion;
    protected int horasMantenimiento;
    
    public Barco(String nombre, String matricula, Data anyoConstruccion) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.anyoConstruccion = anyoConstruccion;
        this.anyoAdquisicion = new Data();
        this.horasMantenimiento = 0;
    }
    
    
    
    @Override
    public String toString() {
        return "Tipo de Barco: "+this.getClass().getSimpleName()+", Nombre: "+this.nombre+", Matricula: "+this.matricula+", Año de construcción: "+this.anyoConstruccion.getAny()+", Horas de mantenimiento: "+this.horasMantenimiento;
    }
    
    public void realizarMantenimiento(){
        this.horasMantenimiento += 100;
    }
    
    @Override
    public boolean equals(Object object) {
        Barco barco = (Barco) object;
        return (this.matricula.equals(barco.matricula));
    }
    
    
}