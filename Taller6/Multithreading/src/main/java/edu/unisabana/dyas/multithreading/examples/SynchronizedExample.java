package edu.unisabana.dyas.multithreading.examples;
public class SynchronizedExample {
    private static int counter = 0;

    public static synchronized void increment() {
        counter++; // Incrementa el contador de manera sincronizada
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // Llama al método increment() 1000 veces
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Espera a que thread1 termine
            thread2.join(); // Espera a que thread2 termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter); // Imprime el valor final del contador
    }
}
