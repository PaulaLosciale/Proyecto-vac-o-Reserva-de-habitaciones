package modelo;

public class Habitacion {

    // Atributos
    private int numeroHabitacion;
    private double precioPorNoche;
    private int cantidadPersonas;
    private String descripcion;
    private tipoHabitacion tipo;
    private estadoHabitacion estado;
    
    // Enum tipo habitacion
    public enum tipoHabitacion {
        INDIVIDUAL,
        DOBLE,
        SUITE
    }
    
    // Enum estado habitacion
    public enum estadoHabitacion {
        DISPONIBLE,
        RESERVADA,
        OCUPADA
    }
    
    // Constructor
    public Habitacion(int numeroHabitacion, double precioPorNoche, int cantidadPersonas, String descripcion, tipoHabitacion tipo, estadoHabitacion estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.cantidadPersonas = cantidadPersonas;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public tipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(tipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public estadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(estadoHabitacion estado) {
        this.estado = estado;
    }

}