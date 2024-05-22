package org.example;

import java.util.HashMap;

    public class Grafo {
        public static final int INF = Integer.MAX_VALUE;
        public int[][] adjacencyMatrix;
        public int[][] predecessorMatrix;

        public Grafo(int size) {
            adjacencyMatrix = new int[size][size];
            predecessorMatrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        adjacencyMatrix[i][j] = 0;
                    } else {
                        adjacencyMatrix[i][j] = INF;
                    }
                    predecessorMatrix[i][j] = i;
                }
            }

        }



        public void addEdge(int from, int to, int weight) {
            if (isValidNode(from) && isValidNode(to) && weight >= 0) {
                adjacencyMatrix[from][to] = weight;
                predecessorMatrix[from][to] = from;
            } else {
                throw new IllegalArgumentException("Invalid edge parameters.");
            }
        }

        public void removeEdge(int from, int to) {
            if (isValidNode(from) && isValidNode(to)) {
                adjacencyMatrix[from][to] = INF;
                predecessorMatrix[from][to] = -1;
            } else {
                throw new IllegalArgumentException("Invalid node indices.");
            }
        }

        private boolean isValidNode(int node) {
            return node >= 0 && node < adjacencyMatrix.length;
        }

        public void floydWarshall() {
            int size = adjacencyMatrix.length;
            for (int k = 0; k < size; k++) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (adjacencyMatrix[i][k] != INF && adjacencyMatrix[k][j] != INF &&
                                adjacencyMatrix[i][k] + adjacencyMatrix[k][j] < adjacencyMatrix[i][j]) {
                            adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                            predecessorMatrix[i][j] = predecessorMatrix[k][j];
                        }
                    }
                }
            }
        }

        public void printMatrix() {
            for (int[] row : adjacencyMatrix) {
                for (int value : row) {
                    System.out.print((value == INF ? "INF" : value) + " ");
                }
                System.out.println();
            }
        }

        public int calculateGraphCenter() {
            int size = adjacencyMatrix.length;
            int[] maxDistances = new int[size];
            int centerNode = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                maxDistances[i] = findMaxDistanceFromNode(i);
            }

            for (int i = 0; i < size; i++) {
                if (maxDistances[i] < minDistance) {
                    minDistance = maxDistances[i];
                    centerNode = i;
                }
            }

            System.out.println("El centro del grafo es : " + centerNode);
            return centerNode;
        }

        private int findMaxDistanceFromNode(int node) {
            int maxDistance = 0;
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[node][j] != INF) {
                    maxDistance = Math.max(maxDistance, adjacencyMatrix[node][j]);
                }
            }
            return maxDistance;
        }

        public void printPath(int from, int to, HashMap<Integer, String> indexCityMap) {
            if (!isValidNode(from) || !isValidNode(to)) {
                throw new IllegalArgumentException("indices de los nodos inexistentes");
            }

            if (from == to) {
                System.out.print(indexCityMap.get(from));
            } else if (predecessorMatrix[from][to] == -1) {
                System.out.print("El camino no esta disponible ");
            } else {
                printPath(from, predecessorMatrix[from][to], indexCityMap);
                System.out.print(" -> " + indexCityMap.get(to));
            }
        }
    }


