package modelo;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombreCompleto;
    private ArrayList<Reserva> reservas;
    private ArrayList<Reserva> reservasActivas;

    public Cliente(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.reservas = new ArrayList<>();
        this.reservasActivas = new ArrayList<>();
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public ArrayList<Reserva> getReservas() { return reservas; }
    public ArrayList<Reserva> getReservasActivas() { return reservasActivas; }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reservasActivas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservasActivas.remove(reserva);
        reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
    }
}