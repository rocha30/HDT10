import org.example.Grafo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    private Grafo graph;

    @Before
    public void setUp() {
        graph = new Grafo(5); // Suponiendo un grafo con 5 nodos
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 0, 7);
    }

    @Test
    public void testAddEdge() {
        graph.addEdge(1, 3, 6);
        assertEquals(6, graph.adjacencyMatrix[1][3]);
    }

    @Test
    public void testRemoveEdge() {
        graph.removeEdge(0, 1);
        assertEquals(Grafo.INF, graph.adjacencyMatrix[0][1]);
    }

    @Test
    public void testFloyd() {
        graph.floydWarshall();
        assertEquals(6, graph.adjacencyMatrix[0][2]);
        assertEquals(7, graph.adjacencyMatrix[0][3]);
    }

    @Test
    public void testCalculateGraphCenter() {
        graph.floydWarshall(); // Asegurar que Floyd se ejecutó para actualizar las distancias
        int center = graph.calculateGraphCenter();
        System.out.println("Centro calculado: " + center);
        assertEquals(0, center); // Dependerá de tu estructura específica del grafo y distancias
    }

    @Test
    public void testShortestPath() {
        graph.floydWarshall();
        int distance = graph.adjacencyMatrix[1][4];
        assertEquals(8, distance);
    }

    @Test
    public void testNoPath() {
        graph.removeEdge(2, 3);
        graph.floydWarshall();
        assertEquals(Grafo.INF, graph.adjacencyMatrix[1][4]);
    }



    @Test
    public void testSelfLoop() {
        graph.addEdge(3, 3, 0);
        assertEquals(0, graph.adjacencyMatrix[3][3]);
    }

    @Test
    public void testEdgeWeightUpdate() {
        graph.addEdge(4, 0, 5);
        assertEquals(5, graph.adjacencyMatrix[4][0]);
    }


}
