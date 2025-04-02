import controlador.ControladorHabitacion;
import modelo.Habitacion;
import modelo.Habitacion.tipoHabitacion;
import vista.Consola;


public class Main {
    public static void main(String[] args) {
    
            // Crear el controlador
            ControladorHabitacion controlador = new ControladorHabitacion();
    
            // Crear la vista y mostrar el menú
            Consola vista = new Consola(controlador);
            vista.mostrarMenu();

    }
}