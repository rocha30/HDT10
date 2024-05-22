package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Controller {
    public static Grafo grafo;
    public static HashMap<String, Integer> cityIndexMap;
    public static HashMap<Integer, String> indexCityMap;




    public static void readGraphFromFile(String filePath) {
        File file = new File("C:\\Users\\maroc\\OneDrive - Colegio Jacques Cousteu\\Documentos\\UVG\\ADA School\\HDT10\\src\\main\\java\\org\\example\\guategrafo.txt");

        try (Scanner fileScanner = new Scanner(file)) {
            cityIndexMap = new HashMap<>();
            indexCityMap = new HashMap<>();
            int index = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                String city1 = parts[0];
                String city2 = parts[1];

                if (!cityIndexMap.containsKey(city1)) {
                    cityIndexMap.put(city1, index);
                    indexCityMap.put(index, city1);
                    index++;
                }
                if (!cityIndexMap.containsKey(city2)) {
                    cityIndexMap.put(city2, index);
                    indexCityMap.put(index, city2);
                    index++;
                }
            }

            int size = cityIndexMap.size();
            grafo   = new Grafo(size);

            try (Scanner fileScanner2 = new Scanner(file)) {
                while (fileScanner2.hasNextLine()) {
                    String line = fileScanner2.nextLine();
                    String[] parts = line.split(" ");
                    int from = cityIndexMap.get(parts[0]);
                    int to = cityIndexMap.get(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    grafo.addEdge(from, to, weight);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public static void modifyGrafo(Scanner scanner) {
        System.out.println("1. Interrupción de tráfico entre dos ciudades");
        System.out.println("2. Establecer conexión entre dos ciudades");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        System.out.print("Ingrese el nombre de la ciudad origen: ");
        String fromCity = scanner.next();
        System.out.print("Ingrese el nombre de la ciudad destino: ");
        String toCity = scanner.next();
        if (option == 1) {
            grafo.removeEdge(cityIndexMap.get(fromCity), cityIndexMap.get(toCity));
        } else if (option == 2) {
            System.out.print("Ingrese el peso del arco: ");
            int weight = scanner.nextInt();
            grafo.addEdge(cityIndexMap.get(fromCity), cityIndexMap.get(toCity), weight);
        } else {
            System.out.println("Opción no válida.");
        }
        grafo.floydWarshall(); // Recalcula las rutas más cortas
        int center = grafo.calculateGraphCenter();
        System.out.println("El nuevo centro del grafo es: " + indexCityMap.get(center));
    }

    public static void findShortestPath(Scanner scanner) {
        System.out.print("Ingrese el nombre de la ciudad origen: ");
        String fromCity = scanner.next();
        System.out.print("Ingrese el nombre de la ciudad destino: ");
        String toCity = scanner.next();
        if (cityIndexMap == null ){
            System.out.println("no ha sido inicializado correctamente");
            return;
        }

        int from = cityIndexMap.get(fromCity);
        int to = cityIndexMap.get(toCity);
        int[][] distances = grafo.adjacencyMatrix;
        if (distances[from][to] == Grafo.INF) {
            System.out.println("No hay ruta disponible entre " + fromCity + " y " + toCity);
        } else {
            System.out.println("La distancia más corta entre " + fromCity + " y " + toCity + " es " + distances[from][to]);
            System.out.print("Ruta: ");
            grafo.printPath(from, to, indexCityMap);
            System.out.println();
        }
    }

    public void displayGraphCenter() {
        int center = grafo.calculateGraphCenter();
        System.out.println("El centro del grafo es: " + indexCityMap.get(center));
    }
}

