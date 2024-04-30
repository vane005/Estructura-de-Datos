/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafodirigido;

import java.util.LinkedList;

/**
 *
 * @author vanee
 */
public class GrafoDirigido {
    private int V; // Número de vértices
    private LinkedList<Integer>[] adj; 

    // Constructor
    public GrafoDirigido(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public void agregarArista(int origen, int destino) {
        adj[origen].add(destino);
    }

    public void imprimirGrafo() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Relaciones de la persona " + i + ":");
            for (Integer vecino : adj[i]) {
                System.out.println(i + " -> " + vecino);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        GrafoDirigido grafo = new GrafoDirigido(6);

        grafo.agregarArista(0, 1); 
        grafo.agregarArista(0, 2); 
        grafo.agregarArista(1, 3); 
        grafo.agregarArista(2, 3); 
        grafo.agregarArista(3, 4); 
        grafo.agregarArista(4, 5); 

        // Imprimimos el grafo
        grafo.imprimirGrafo();
    }
}
