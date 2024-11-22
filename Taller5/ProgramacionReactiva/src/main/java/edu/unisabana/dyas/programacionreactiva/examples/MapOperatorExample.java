package edu.unisabana.dyas.programacionreactiva.examples;
import io.reactivex.Observable;

public class MapOperatorExample {
    public static void main(String[] args) {
        // Crea un Observable que emite una secuencia de números
        Observable.just(1, 2, 3, 4, 5)
                // Aplica la transformación (multiplica cada número por 2)
                .map(item -> item * 2)
                // Se suscribe al Observable e imprime los resultados
                .subscribe(System.out::println);
    }
}