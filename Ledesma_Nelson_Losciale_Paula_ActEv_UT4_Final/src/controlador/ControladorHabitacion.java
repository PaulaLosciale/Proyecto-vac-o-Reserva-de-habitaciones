package controlador;

class ControladorHabitacion {

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
    
    void infomacioHabitacion() {
        System.out.println("-------------------------------------");
        System.out.println("Numero de habitación: " + numeroHabitacion);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Cantidad de personas: " + cantidadPersonas);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tipo de habitación: " + tipo);
        System.out.println("Estado de habitación: " + estado);
        System.out.println("-------------------------------------");
    }

}