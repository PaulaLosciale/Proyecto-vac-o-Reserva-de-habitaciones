import controlador.*;
import modelo.*;
import vista.Consola;

public class Main {
    public static void main(String[] args) {
        // Inicializar controladores
        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorHabitacion controladorHabitacion = new ControladorHabitacion();
        ControladorReserva controladorReserva = new ControladorReserva();

        // Crear la vista
        Consola consola = new Consola(controladorHabitacion, controladorCliente, controladorReserva);
        consola.mostrarMenu();
    }
}