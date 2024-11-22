package edu.unisabana.dyas.programacionreactiva.examples;
import io.reactivex.Observable;

public class ZipOperatorExample {
    public static void main(String[] args) {
        // Crea dos Observables
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<String> observable2 = Observable.just("A", "B", "C");

        // Combina los elementos de ambos Observables en pares
        Observable.zip(observable1, observable2, (num, letter) -> num + letter)
                // Se suscribe al Observable combinado y imprime los resultados
                .subscribe(System.out::println);
    }
}
