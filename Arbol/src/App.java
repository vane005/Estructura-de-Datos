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
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido en preorden:");
        arbol.preorden();
        System.out.println("\nRecorrido en inorden:");
        arbol.inorden();
        System.out.println("\nRecorrido en postorden:");
        arbol.postorden();
    }
}
