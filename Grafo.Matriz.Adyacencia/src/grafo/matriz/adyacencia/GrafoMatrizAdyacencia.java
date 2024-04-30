/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo.matriz.adyacencia;

/**
 *
 * @author vanee
 */
public class GrafoMatrizAdyacencia {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Constructor
    public GrafoMatrizAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
        matrizAdyacencia[destino][origen] = 1;
    }

    public void imprimirMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoMatrizAdyacencia grafo = new GrafoMatrizAdyacencia(5);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        grafo.imprimirMatrizAdyacencia();
    }
}
