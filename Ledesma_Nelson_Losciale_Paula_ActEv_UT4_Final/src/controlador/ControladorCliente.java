package controlador;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Habitacion;

class ControladorCliente {
    private ArrayList<Cliente> clientes;

    // Constructor
    public ControladorCliente() {
        this.clientes = new ArrayList<>();
        inicializarClientes();
    }

    // Inicializar habitaciones con datos de ejemplo
    public void inicializarClientes() {
        clientes.add(new Cliente(1234, "Julian Alvarez"));
        clientes.add(new Cliente(5678, "Lionel Messi"));
        clientes.add(new Cliente(4123, "Paula Losciale"));
    } 

    public void probando1() {
        System.out.println("Funciona che");
    }
    
    public void clientes() {
        
    }
}