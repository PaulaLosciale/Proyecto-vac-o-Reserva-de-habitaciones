package modelo;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double precioTotal;
    private EstadoReserva estado;

    public enum EstadoReserva {
        ACTIVADA,
        CANCELADA,
        FINALIZADA
    }

    public Reserva(int idReserva, Habitacion habitacion, Cliente cliente, LocalDate checkIn, LocalDate checkOut) {
        this.idReserva = idReserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precioTotal = calcularPrecioTotal();
        this.estado = EstadoReserva.ACTIVADA;
    }

    public double calcularPrecioTotal() {
        long diasEstancia = java.time.temporal.ChronoUnit.DAYS.between(checkIn, checkOut);
        return habitacion.getPrecioPorNoche() * diasEstancia;
    }

    // Getters y setters
    public int getIdReserva() { return idReserva; }
    public Habitacion getHabitacion() { return habitacion; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public double getPrecioTotal() { return precioTotal; }
    public EstadoReserva getEstado() { return estado; }

    public void setEstado(EstadoReserva estado) { this.estado = estado; }
}
