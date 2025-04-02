package controlador;

import modelo.Reserva;
import modelo.Cliente;
import modelo.Habitacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControladorReserva {
    public List<Reserva> reservas = new ArrayList<>();

    public void crearReserva(Habitacion habitacion, Cliente cliente, LocalDate checkIn, LocalDate checkOut) throws Exception {
        if (checkIn.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de check-in no puede ser pasada.");
        }
        if (checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("La fecha de check-out no puede ser antes del check-in.");
        }
        if (cliente.getReservasActivas().size() >= 3) {
            throw new IllegalStateException("El cliente ya tiene 3 reservas activas.");
        }
        if (habitacion.getEstado() != Habitacion.estadoHabitacion.DISPONIBLE) {
            throw new IllegalStateException("La habitación no está disponible.");
        }

        Reserva nuevaReserva = new Reserva(generarIdReserva(), habitacion, cliente, checkIn, checkOut);
        reservas.add(nuevaReserva);
        cliente.agregarReserva(nuevaReserva);
        habitacion.setEstado(Habitacion.estadoHabitacion.RESERVADA);
    }

    public void cancelarReserva(int idReserva) throws Exception {
        Reserva reserva = obtenerReservaPorId(idReserva);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva no encontrada.");
        }
        if (reserva.getCheckIn().isBefore(LocalDate.now())) {
            throw new IllegalStateException("No se puede cancelar una reserva que ya comenzó.");
        }
        reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
        reserva.getHabitacion().setEstado(Habitacion.estadoHabitacion.DISPONIBLE);
    }

    public Reserva obtenerReservaPorId(int idReserva) {
        return reservas.stream()
                .filter(reserva -> reserva.getIdReserva() == idReserva)
                .findFirst()
                .orElse(null);
    }

    private int generarIdReserva() {
        return reservas.size() + 1;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double calcularPrecioReserva(Reserva reserva) {
        long diasEstadia = ChronoUnit.DAYS.between(reserva.getCheckIn(), reserva.getCheckOut());
        return diasEstadia * reserva.getHabitacion().getPrecioPorNoche();
    }
}
