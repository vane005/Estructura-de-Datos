/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author vanee
 */
public class App {
    public static void main(String args[]) {
        int V = 5; // Número de vértices
        Grafos grafo = new Grafos(V);

        // Agregar aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        // Imprimir el grafo
        grafo.imprimirGrafo();
    }
}
