package controlador;

import modelo.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class ControladorHabitacion {
    private List<Habitacion> habitaciones = new ArrayList<>();

    public ControladorHabitacion() {
        // Crear habitaciones del hotel
        habitaciones.add(new Habitacion(101, 50.0, 1, "Vista al mar", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(102, 80.0, 2, "Vista al jardín", Habitacion.tipoHabitacion.DOBLE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(103, 150.0, 1, "Jacuzzi incluido", Habitacion.tipoHabitacion.SUITE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(104, 50.0, 1, "Vista a la calle", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(105, 80.0, 2, "Vista al jardín", Habitacion.tipoHabitacion.DOBLE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(201, 80.0, 2, "Vista al mar", Habitacion.tipoHabitacion.DOBLE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(202, 50.0, 1, "Jacuzzi incluido", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(203, 50.0, 1, "Vista al jardín", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(204, 50.0, 1, "Vista a la calle", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(205, 80.0, 2, "Vista al jardín", Habitacion.tipoHabitacion.DOBLE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(301, 150.0, 1, "Vista al mar", Habitacion.tipoHabitacion.SUITE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(302, 50.0, 1, "Vista al jardín", Habitacion.tipoHabitacion.INDIVIDUAL, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(303, 80.0, 2, "Vista a la calle", Habitacion.tipoHabitacion.DOBLE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(304, 150.0, 1, "Vista al jardín", Habitacion.tipoHabitacion.SUITE, Habitacion.estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(305, 150.0, 1, "Jacuzzi incluido", Habitacion.tipoHabitacion.SUITE, Habitacion.estadoHabitacion.DISPONIBLE));

    }

    public void mostrarHabitacionesDisponibles() {
        habitaciones.stream()
                .filter(habitacion -> habitacion.getEstado() == Habitacion.estadoHabitacion.DISPONIBLE)
                .forEach(habitacion -> System.out.println(habitacion.getNumeroHabitacion()));
    }

    public void mostrarHabitacionesEnEstadoActual() {
        habitaciones.forEach(habitacion ->
                System.out.println("Habitación " + habitacion.getNumeroHabitacion() + " - Estado: " + habitacion.getEstado()));
    }

    public Habitacion obtenerHabitacionPorNumero(int numero) {
        return habitaciones.stream()
                .filter(habitacion -> habitacion.getNumeroHabitacion() == numero)
                .findFirst()
                .orElse(null);
    }

    public void mostrarResumenHabitaciones() {
        System.out.println("Resumen de Habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Número: " + habitacion.getNumeroHabitacion() +
                    " | Tipo: " + habitacion.getTipo() +
                    " | Estado: " + habitacion.getEstado());
        }
    }
}
