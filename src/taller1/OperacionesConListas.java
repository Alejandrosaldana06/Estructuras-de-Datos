package taller1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacionesConListas {

    public static void main(String[] args) {
        // Crear la lista de nombres
        List<String> nombres = new ArrayList<>();

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que agregue al menos 5 nombres
        System.out.println("Por favor, introduce al menos 5 nombres:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce el nombre " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            nombres.add(nombre);
        }

        // Preguntar si desea agregar más nombres opcionalmente
        String respuesta;
        do {
            System.out.print("¿Desea agregar otro nombre? (s/n): ");
            respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.print("Introduce el nombre: ");
                String nombre = scanner.nextLine();
                nombres.add(nombre);
            }
        } while (respuesta.equalsIgnoreCase("s"));

        // Menú de opciones
        int opcion = 0;
        do {
            System.out.println("\n---- Menú de Operaciones ----");
            System.out.println("1. Imprimir lista de nombres");
            System.out.println("2. Buscar un nombre");
            System.out.println("3. Agregar un nombre");
            System.out.println("4. Eliminar un nombre");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    // Imprimir todos los nombres
                    imprimirNombres(nombres);
                    break;
                case 2:
                    // Buscar un nombre en la lista
                    System.out.print("Introduce el nombre a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    buscarNombre(nombres, nombreBuscado);
                    break;
                case 3:
                    // Agregar un nuevo nombre si no existe
                    System.out.print("Introduce el nombre a agregar: ");
                    String nuevoNombre = scanner.nextLine();
                    agregarNombreSiNoExiste(nombres, nuevoNombre);
                    break;
                case 4:
                    // Eliminar un nombre de la lista
                    System.out.print("Introduce el nombre a eliminar: ");
                    String nombreAEliminar = scanner.nextLine();
                    eliminarNombre(nombres, nombreAEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona otra.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Función para imprimir los nombres
    public static void imprimirNombres(List<String> listaDeNombres) {
        System.out.println("\nLista de nombres:");
        for (String nombre : listaDeNombres) {
            System.out.println(nombre);
        }
    }

    // Función para buscar un nombre en la lista
    public static void buscarNombre(List<String> listaDeNombres, String nombreBuscado) {
        if (listaDeNombres.contains(nombreBuscado)) {
            System.out.println("El nombre '" + nombreBuscado + "' fue encontrado en la lista.");
        } else {
            System.out.println("El nombre '" + nombreBuscado + "' no fue encontrado en la lista.");
        }
    }

    // Función para agregar un nombre si no existe en la lista
    public static void agregarNombreSiNoExiste(List<String> listaDeNombres, String nuevoNombre) {
        if (!listaDeNombres.contains(nuevoNombre)) {
            listaDeNombres.add(nuevoNombre);
            System.out.println("El nombre '" + nuevoNombre + "' ha sido agregado a la lista.");
        } else {
            System.out.println("El nombre '" + nuevoNombre + "' ya existe en la lista, no se agregó.");
        }
    }

    // Función para eliminar un nombre de la lista
    public static void eliminarNombre(List<String> listaDeNombres, String nombreAEliminar) {
        if (listaDeNombres.remove(nombreAEliminar)) {
            System.out.println("El nombre '" + nombreAEliminar + "' ha sido eliminado de la lista.");
        } else {
            System.out.println("El nombre '" + nombreAEliminar + "' no se encontró en la lista, no se eliminó.");
        }
    }
}
