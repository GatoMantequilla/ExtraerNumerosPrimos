package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class ACT1 {

    public static void main(String[] args) {
        int dimension;
        int primos = 0;

        dimension = leerDimension();
        int[] vector = new int[dimension];

        llenarVector(vector);
        System.out.println("Arreglo de numeros: ");
        mostrarVector(vector);

        for (int posicion = 0; posicion < vector.length; posicion++) {
            if (esPrimo(vector[posicion])) primos++;
        }

        if (primos == 0) {
            System.out.println("No existen numeros primos en este arreglo.");
        } else {
            int[] vectorPrimos = new int[primos];

            copiarVectores(vector, vectorPrimos);
            System.out.println("Numeros primos: ");
            mostrarVector(vectorPrimos);
        }
    }

    private static int leerDimension() {
        Scanner escaner = new Scanner(System.in);
        int dimension = 0;
        while (true) {
            try {
                System.out.print("Ingrese la dimension del arreglo: ");
                dimension = escaner.nextInt();
                if (dimension > 0) break;
                else System.out.println("Por favor, ingrese un entero positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un entero.");
                escaner.next();
            }
        }
        return dimension;
    }

    private static void llenarVector(int[] vector) {
        Random aleatorio = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = aleatorio.nextInt(100); // Generate numbers between -100 and 100
        }
    }

    private static void mostrarVector(int[] vector) {
        int contador = 0;
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
            contador++;
            if (contador % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int contador = 2; contador * contador <= numero; contador++) {
            if (numero % contador == 0) return false;
        }
        return true;
    }

    private static void copiarVectores(int[] vector, int[] otroVector) {
        int otraPosicion = 0;
        for (int posicion = 0; posicion < vector.length; posicion++) {
            if (esPrimo(vector[posicion])) {
                otroVector[otraPosicion] = vector[posicion];
                otraPosicion++;
            }
        }
    }
}