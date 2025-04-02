package vista;

import modelo.Reserva;
import controlador.ControladorHabitacion;
import modelo.Cliente;
import modelo.Habitacion;
import java.util.Scanner;

public class Consola {
    private ControladorHabitacion controlador;
    private Scanner scanner;

    public Consola(ControladorHabitacion controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {

            Reserva reserva1 = new Reserva();
            //Cliente cliente1 = new Cliente();
            
            Scanner scanner = new Scanner(System.in);
            int opcion;
    
            do {

                System.out.println("-------------------------------------------------------");
                System.out.println("1 - Crear una reserva");
                System.out.println("2 - Cancelar una reserva (solo si aún no ha comenzado)");
                System.out.println("3 - Buscar una habitación por número, tipo o estado");
                System.out.println("4 - Buscar todas las reservas activas de un cliente");
                System.out.println("5 - Listar el historial de reservas de un cliente");
                System.out.println("6 - Mostrar un resumen del hotel");
                System.out.println("7 - Calcular el precio total de una reserva");
                System.out.println("8 - Salir");
                System.out.println("-------------------------------------------------------");
                System.out.println("Digite la opcion: ");
                opcion = scanner.nextInt();

                while (opcion <= 0 || opcion >= 9) {
                    System.out.println("--------------------------------------");
                    System.out.println("Error - Opción invalida");
                    System.out.println("Digite nuevamente: ");
                    System.out.println("--------------------------------------");
                    opcion = scanner.nextInt();
                }

                switch (opcion) {
                    case 1:
                        reserva1.probando();
                        break;
                    case 2:
                        //cliente1.probando1();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        //
                        controlador.mostrarHabitacionesEnEstadoActual();
                        break;
                    case 7:
                        
                        break;
                }

            } while (opcion != 3);
            scanner.close();
    }
}



/* System.out.println("\n--- Sistema de Reservas ---");
                System.out.println("1. Ver habitaciones disponibles");
                System.out.println("2. Reservar una habitación");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        controlador.mostrarHabitacionesDisponibles();
                        break;
                    case 2:
                        System.out.print("Ingrese el número de la habitación que desea reservar: ");
                        int numero = scanner.nextInt();
                        controlador.reservarHabitacion(numero);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                } */