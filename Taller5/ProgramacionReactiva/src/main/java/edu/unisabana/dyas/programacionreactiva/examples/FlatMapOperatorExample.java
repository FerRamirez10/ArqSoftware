package edu.unisabana.dyas.programacionreactiva.examples;
import io.reactivex.Observable;

public class FlatMapOperatorExample {
    public static void main(String[] args) {
        // Crea un Observable que emite una secuencia de números
        Observable.just(1, 2, 3)
                // Transforma cada número en un Observable y lo aplana
                .flatMap(item -> Observable.just(item * 10, item * 20))
                // Se suscribe al Observable y imprime los resultados
                .subscribe(System.out::println);
    }
}
