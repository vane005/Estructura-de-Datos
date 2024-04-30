
package validar_parentesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Validar_parentesis {
    public static void main(String[] args) throws IOException {
        BufferedReader expresion = new BufferedReader(new InputStreamReader(System.in));
        String input = expresion.readLine();
        String resultado = resolverOperaciones(input);
        if (resultado != null && checarparentesis(input)) {
            System.out.println("Los paréntesis están balanceados y el resultado es: " + resultado);
        } else {
            System.out.println("Los paréntesis no están balanceados o la expresión es inválida.");
        }
    }
    
    static boolean checarparentesis(String input){
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }
        return pila.isEmpty(); 
    }
    
    static String resolverOperaciones(String input) {
        Stack<Character> pilaOperadores = new Stack<>();
        Stack<Integer> pilaOperandos = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                pilaOperadores.push(c);
            } else if (c == ')') {
                StringBuilder operacion = new StringBuilder();
                while (pilaOperadores.peek() != '(') {
                    char operador = pilaOperadores.pop();
                    int b = pilaOperandos.pop();
                    int a = pilaOperandos.pop();
                    pilaOperandos.push(realizarOperacion(a, b, operador));
                }
                pilaOperadores.pop();
            } else if (esOperador(c)) {
                while (!pilaOperadores.isEmpty() && precedencia(c) <= precedencia(pilaOperadores.peek())) {
                    char operador = pilaOperadores.pop();
                    int b = pilaOperandos.pop();
                    int a = pilaOperandos.pop();
                    pilaOperandos.push(realizarOperacion(a, b, operador));
                }
                pilaOperadores.push(c);
            } else if (Character.isDigit(c)) {
                StringBuilder numero = new StringBuilder();
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    numero.append(input.charAt(i));
                    i++;
                }
                i--; 
                pilaOperandos.push(Integer.parseInt(numero.toString()));
            }
        }

        while (!pilaOperadores.isEmpty()) {
            char operador = pilaOperadores.pop();
            int b = pilaOperandos.pop();
            int a = pilaOperandos.pop();
            pilaOperandos.push(realizarOperacion(a, b, operador));
        }
        return String.valueOf(pilaOperandos.peek());
    }
    
    static int realizarOperacion(int a, int b, char operador) {
        if (operador == '+') return a + b;
        else if (operador == '-') return a - b;
        else if (operador == '*') return a * b;
        else if (operador == '/') return a / b;
        else return 0;
    }
    
    static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    static int precedencia(char operador) {
        if (operador == '+' || operador == '-') return 1;
        else if (operador == '*' || operador == '/') return 2;
        else return 0;
    }
}
