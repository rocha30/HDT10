package org.example;

import java.util.Scanner;

import static org.example.Controller.*;

public class App {
    private static final String path = "C:\\Users\\maroc\\OneDrive - Colegio Jacques Cousteu\\Documentos\\UVG\\ADA School\\HDT10\\src\\main\\java\\org\\example\\guategrafo.txt";

    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Inicializando el sistema de grafos para la distribución de suministros médicos.");

        readGraphFromFile(path);

        while (!exit) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar ruta más corta entre dos ciudades");
            System.out.println("2. Indicar ciudad centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Salir");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("ten en cuenta que los nombres como Cidad de Guatemala deben ir escrito todo junto ");
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.print("Opción: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findShortestPath(scanner);
                    break;

                case 2:
                    controller.displayGraphCenter();
                    break;
                case 3:
                    modifyGrafo(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
