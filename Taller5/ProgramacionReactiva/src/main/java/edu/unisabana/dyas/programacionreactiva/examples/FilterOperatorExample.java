package edu.unisabana.dyas.programacionreactiva.examples;
import io.reactivex.Observable;

public class FilterOperatorExample {
    public static void main(String[] args) {
        // Crea un Observable que emite una secuencia de números
        Observable.just(1, 2, 3, 4, 5)
                // Filtra los elementos que son pares
                .filter(item -> item % 2 == 0)
                // Se suscribe al Observable y imprime los resultados
                .subscribe(System.out::println);
    }
}
