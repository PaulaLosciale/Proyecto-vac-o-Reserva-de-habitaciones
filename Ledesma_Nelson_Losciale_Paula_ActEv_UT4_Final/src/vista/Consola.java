package vista;

import controlador.ControladorCliente;
import controlador.ControladorReserva;
import controlador.ControladorHabitacion;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Reserva;

import java.util.Scanner;
import java.time.LocalDate;

public class Consola {
    private ControladorHabitacion controladorHabitacion;
    private ControladorCliente controladorCliente;
    private ControladorReserva controladorReserva;
    private Scanner scanner;

    public Consola(ControladorHabitacion controladorHabitacion, ControladorCliente controladorCliente, ControladorReserva controladorReserva) {
        this.controladorHabitacion = controladorHabitacion;
        this.controladorCliente = controladorCliente;
        this.controladorReserva = controladorReserva;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("1 - Crear una reserva");
            System.out.println("2 - Cancelar una reserva");
            System.out.println("3 - Buscar habitación por número, tipo o estado");
            System.out.println("4 - Buscar reservas activas de un cliente");
            System.out.println("5 - Listar historial de reservas de un cliente");
            System.out.println("6 - Mostrar resumen del hotel");
            System.out.println("7 - Calcular precio total de reserva");
            System.out.println("8 - Salir");
            System.out.println("-------------------------------------------------------");
            System.out.print("Digite la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearReserva();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    buscarHabitacion();
                    break;
                case 4:
                    buscarReservasCliente();
                    break;
                case 5:
                    listarHistorialReservas();
                    break;
                case 6:
                    mostrarResumenHotel();
                    break;
                case 7:
                    calcularPrecioReserva();
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema.");
                    break;
            }
        } while (opcion != 8);
    }

    private void crearReserva() {
        System.out.print("Ingrese ID de cliente: ");
        int clienteId = scanner.nextInt();
        Cliente cliente = controladorCliente.obtenerClientePorId(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        Habitacion habitacion = controladorHabitacion.obtenerHabitacionPorNumero(numeroHabitacion);
        if (habitacion == null || habitacion.getEstado() != Habitacion.estadoHabitacion.DISPONIBLE) {
            System.out.println("Habitación no disponible.");
            return;
        }

        System.out.print("Ingrese fecha de check-in (YYYY-MM-DD): ");
        String checkInStr = scanner.next();
        LocalDate checkIn = LocalDate.parse(checkInStr);

        System.out.print("Ingrese fecha de check-out (YYYY-MM-DD): ");
        String checkOutStr = scanner.next();
        LocalDate checkOut = LocalDate.parse(checkOutStr);

        try {
            controladorReserva.crearReserva(habitacion, cliente, checkIn, checkOut);
            System.out.println("Reserva creada con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelarReserva() {
        System.out.print("Ingrese ID de la reserva a cancelar: ");
        int idReserva = scanner.nextInt();
        try {
            controladorReserva.cancelarReserva(idReserva);
            System.out.println("Reserva cancelada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void buscarHabitacion() {
        System.out.print("Ingrese el número de habitación: ");
        int numero = scanner.nextInt();
        Habitacion habitacion = controladorHabitacion.obtenerHabitacionPorNumero(numero);
        if (habitacion != null) {
            System.out.println("Habitación encontrada: " + habitacion.getNumeroHabitacion() + ", Estado: " + habitacion.getEstado());
        } else {
            System.out.println("Habitación no encontrada.");
        }
    }

    private void buscarReservasCliente() {
        System.out.print("Ingrese ID del cliente: ");
        int clienteId = scanner.nextInt();
        Cliente cliente = controladorCliente.obtenerClientePorId(clienteId);
        if (cliente != null) {
            System.out.println("Reservas activas de " + cliente.getNombreCompleto());
            cliente.getReservasActivas().forEach(reserva ->
                    System.out.println("Reserva ID: " + reserva.getIdReserva() + ", Habitación: " + reserva.getHabitacion().getNumeroHabitacion()));
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void listarHistorialReservas() {
        System.out.print("Ingrese ID del cliente: ");
        int clienteId = scanner.nextInt();
        Cliente cliente = controladorCliente.obtenerClientePorId(clienteId);
        if (cliente != null) {
            System.out.println("Historial de reservas de " + cliente.getNombreCompleto());
            cliente.getReservasActivas().forEach(reserva ->
                    System.out.println("Reserva ID: " + reserva.getIdReserva() + ", Habitación: " + reserva.getHabitacion().getNumeroHabitacion()));
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void calcularPrecioReserva() {
        System.out.print("Ingrese ID de la reserva para calcular el precio: ");
        int idReserva = scanner.nextInt();
        Reserva reserva = controladorReserva.obtenerReservaPorId(idReserva);
        if (reserva != null) {
            double precio = controladorReserva.calcularPrecioReserva(reserva);
            System.out.println("El precio total de la reserva es: " + precio + "€");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    private void mostrarResumenHotel() {
        controladorHabitacion.mostrarResumenHabitaciones();
    }
}
