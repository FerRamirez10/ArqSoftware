package edu.unisabana.dyas.programacionreactiva.examples;
import io.reactivex.Observable;

public class MergeOperatorExample {
    public static void main(String[] args) {
        // Crea dos Observables
        Observable<Integer> observable1 = Observable.just(1, 3, 5);
        Observable<Integer> observable2 = Observable.just(2, 4, 6);

        // Combina los dos Observables y emite los elementos en el orden en que se producen
        Observable.merge(observable1, observable2)
                // Se suscribe al Observable combinado y imprime los resultados
                .subscribe(System.out::println);
    }
}
