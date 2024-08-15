package taller1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practica  {

    public static void main(String[] args) {
        // Crear la lista de tareas
        List<String> tareas = new ArrayList<>();

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // Menú de opciones para la gestión de tareas
        do {
            System.out.println("\n---- Menú ----");
            System.out.println("1. Agregar una tarea");
            System.out.println("2. Eliminar una tarea completada");
            System.out.println("3. Mostrar todas las tareas pendientes");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    // Agregar una tarea
                    System.out.print("Introduce la tarea a agregar: ");
                    String nuevaTarea = scanner.nextLine();
                    agregarTarea(tareas, nuevaTarea);
                    break;
                case 2:
                    // Eliminar una tarea completada
                    System.out.print("Introduce el número de la tarea completada para eliminar: ");
                    mostrarTareas(tareas);
                    int indiceEliminar = scanner.nextInt();
                    eliminarTarea(tareas, indiceEliminar);
                    break;
                case 3:
                    // Mostrar todas las tareas pendientes
                    mostrarTareas(tareas);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona otra.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Función para agregar una tarea
    public static void agregarTarea(List<String> listaDeTareas, String tarea) {
        listaDeTareas.add(tarea);
        System.out.println("La tarea ha sido agregada.");
    }

    // Función para eliminar una tarea
    public static void eliminarTarea(List<String> listaDeTareas, int indice) {
        if (indice > 0 && indice <= listaDeTareas.size()) {
            String tareaEliminada = listaDeTareas.remove(indice - 1);
            System.out.println("La tarea '" + tareaEliminada + "' ha sido eliminada.");
        } else {
            System.out.println("Número de tarea inválido. No se eliminó ninguna tarea.");
        }
    }

    // Función para mostrar todas las tareas pendientes
    public static void mostrarTareas(List<String> listaDeTareas) {
        if (listaDeTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("\nTareas pendientes:");
            for (int i = 0; i < listaDeTareas.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeTareas.get(i));
            }
        }
    }
}
