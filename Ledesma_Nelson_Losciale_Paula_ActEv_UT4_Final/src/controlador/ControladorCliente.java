package controlador;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ControladorCliente {

    private List<Cliente> clientes;

    public ControladorCliente() {
        this.clientes = new ArrayList<>();
        agregarClientesDeEjemplo();
    }

    // Agregamos 3 clientes de ejemplo
    private void agregarClientesDeEjemplo() {
        Cliente cliente1 = new Cliente(1234, "Juan Pérez");
        Cliente cliente2 = new Cliente(2433, "Ana Gómez");
        Cliente cliente3 = new Cliente(3447, "Carlos Díaz");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
    }

    // Obtener todos los clientes
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Obtener un cliente por su ID
    public Cliente obtenerClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;  // Si no se encuentra el cliente
    }
}
