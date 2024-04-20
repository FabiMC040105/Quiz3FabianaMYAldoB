package Quiz3FabianaMYAldoB;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] elementos = generarElementos(10000); // Cambia el tamaño según lo indicado por el profesor
        LinkedList listaEnlazada = new LinkedList();
        BinarySearchTree arbolBST = new BinarySearchTree();

        // Insertar elementos en ambas estructuras
        for (int elemento : elementos) {
            listaEnlazada.insert(elemento);
            arbolBST.insert(elemento);
        }

        // Realizar búsquedas aleatorias y medir el tiempo
        Random rand = new Random();
        final int NUM_BUSQUEDAS = 100; // Cambia según lo indicado por el profesor
        long tiempoLista = 0;
        long tiempoArbol = 0;

        for (int i = 0; i < NUM_BUSQUEDAS; i++) {
            int elementoBuscar = elementos[rand.nextInt(elementos.length)]; // Elemento aleatorio a buscar

            long startTime = System.nanoTime();
            listaEnlazada.search(elementoBuscar);
            long endTime = System.nanoTime();
            tiempoLista += endTime - startTime;

            startTime = System.nanoTime();
            arbolBST.search(elementoBuscar);
            endTime = System.nanoTime();
            tiempoArbol += endTime - startTime;
        }

        // Imprimir resultados
        System.out.println("Tiempo promedio de búsqueda en lista enlazada: " + (tiempoLista / NUM_BUSQUEDAS) + " nanosegundos");
        System.out.println("Tiempo promedio de búsqueda en árbol binario de búsqueda: " + (tiempoArbol / NUM_BUSQUEDAS) + " nanosegundos");
    }

    // Método para generar elementos aleatorios
    public static int[] generarElementos(int cantidad) {
        int[] elementos = new int[cantidad];
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            elementos[i] = rand.nextInt(1000000); // Generar números aleatorios entre 0 y 999999
        }
        return elementos;
    }
}

