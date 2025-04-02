package controlador;

import modelo.Habitacion;
import modelo.Habitacion.tipoHabitacion;
import modelo.Habitacion.estadoHabitacion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ControladorHabitacion {
    private ArrayList<Habitacion> habitaciones;

    // Constructor
    public ControladorHabitacion() {
        this.habitaciones = new ArrayList<>();
        inicializarHabitaciones();
    }

    // Inicializar habitaciones con datos de ejemplo
    public void inicializarHabitaciones() {
        habitaciones.add(new Habitacion(101, 50.0, 1, "Vista al jardín", tipoHabitacion.INDIVIDUAL, estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(202, 80.0, 2, "Cama doble", tipoHabitacion.DOBLE, estadoHabitacion.DISPONIBLE));
        habitaciones.add(new Habitacion(303, 150.0, 4, "Suite con jacuzzi", tipoHabitacion.SUITE, estadoHabitacion.RESERVADA));
    }

    // Mostrar todas las habitaciones disponibles
    public void mostrarHabitacionesDisponibles() {
        try {
            System.out.println("Habitaciones disponibles:");
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.getEstado() == estadoHabitacion.DISPONIBLE) {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Número: " + habitacion.getNumeroHabitacion() +
                            "| Tipo: " + habitacion.getTipo() +
                            "| Precio por noche: $" + habitacion.getPrecioPorNoche() +
                            "| Descripción: " + habitacion.getDescripcion());
                    System.out.println("--------------------------------------------------------------------------------");
                }
            }
            } catch (Exception NullPointerException) {
                System.out.println("Habitaciones actualmente no disponibles");
            }
    }

    // Mostrar todas las habitaciones en estados actual
    public void mostrarHabitacionesEnEstadoActual() {
        try {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Habitaciones disponibles:");
            for (Habitacion habitacion : habitaciones) {
                System.out.println("Número: " + habitacion.getNumeroHabitacion() +
                    "| Tipo: " + habitacion.getTipo() +
                    "| Precio por noche: $" + habitacion.getPrecioPorNoche() +
                    "| Descripción: " + habitacion.getDescripcion());
            }
            } catch (Exception NullPointerException) {
                System.out.println("Habitaciones actualmente no disponibles");
            }
    }

    // Reservar una habitación
    public void reservarHabitacion(int numeroHabitacion) {
        try {    
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                if (habitacion.getEstado() == estadoHabitacion.DISPONIBLE) {
                    habitacion.setEstado(estadoHabitacion.RESERVADA);
                    System.out.println("La habitación " + numeroHabitacion + " ha sido reservada exitosamente.");
                } else {
                    System.out.println("La habitación " + numeroHabitacion + " no está disponible.");
                }
                return;
            }
        }
            System.out.println("No se encontró una habitación con el número proporcionado.");
        
        } catch (Exception NullPointerException) {
            System.out.println("Actualmente no se puede acceder al servicio ");
        }
    }
}
