package modelo;

import java.util.ArrayList;

public class Cliente {
    // Atributos
    private int id;
    private String nombreCompleto;
    private ArrayList<Reserva> Reservas;
    private ArrayList<Reserva> ReservaActiva;
    
    // Constructor
    public Cliente(int id, String nombreCompleto, ArrayList<Reserva> Reservas, ArrayList<Reserva> ReservaActiva) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.Reservas = Reservas;
        this.ReservaActiva = ReservaActiva;
    }

    public Cliente(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    // Getters y Setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ArrayList<Reserva> getReservas() {
        return Reservas;
    }

    public void setReservas( ArrayList<Reserva> Reservas) {
        this.Reservas = Reservas;
    }

    public ArrayList<Reserva> getReservasActiva() {
        return ReservaActiva;
    }

    public void setReservasActiva( ArrayList<Reserva> ReservasActiva) {
        this.ReservaActiva = ReservasActiva;
    }
}