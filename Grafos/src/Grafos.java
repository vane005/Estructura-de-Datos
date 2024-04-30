import java.util.*;

// Clase para representar un grafo no dirigido
class Grafos{
    private int V; // Número de vértices
    private LinkedList<Integer>[] adyacencia; // Lista de adyacencia para almacenar los vértices adyacentes a cada vértice

    // Constructor del grafo
    public Grafos(int v) {
        V = v;
        adyacencia = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adyacencia[i] = new LinkedList<>();
    }

    // Método para agregar una arista al grafo
    public void agregarArista(int v, int w) {
        adyacencia[v].add(w);
        adyacencia[w].add(v);
    }

    // Método para imprimir el grafo
    public void imprimirGrafo() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Lista de adyacencia del vértice " + i);
            System.out.print("Encabezado");
            for (Integer item : adyacencia[i]) {
                System.out.print(" -> " + item);
            }
            System.out.println("\n");
        }
    }
}
