package edu.unisabana.dyas.multithreading;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ImageProcessingExample {

    public static void main(String[] args) {
        // Lista de "imágenes" (simuladas como números)
        List<Integer> images = Arrays.asList(100, 200, 300, 400, 500);

        // Crear un pool de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear tareas para procesar cada imagen (en realidad, multiplicar un número por 2)
        List<Callable<String>> tasks = Arrays.asList(
            () -> processImage(0, images.get(0)),
            () -> processImage(1, images.get(1)),
            () -> processImage(2, images.get(2)),
            () -> processImage(3, images.get(3)),
            () -> processImage(4, images.get(4))
        );

        try {
            // Ejecutar las tareas en paralelo
            List<Future<String>> results = executor.invokeAll(tasks);

            // Mostrar los resultados de cada procesamiento
            for (Future<String> result : results) {
                System.out.println(result.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Finalizar el pool de hilos
        }
    }

    // Método que simula el procesamiento de una "imagen"
    private static String processImage(int imageIndex, int imageValue) {
        try {
            // Simulamos un "tiempo de procesamiento" con sleep
            Thread.sleep(1000);

            // Aplicamos un "filtro" (en este caso, multiplicamos por 2)
            int processedValue = imageValue * 2;

            return "Imagen " + imageIndex + " procesada. Valor final: " + processedValue;

        } catch (InterruptedException e) {
            return "Error al procesar la imagen " + imageIndex;
        }
    }
}
