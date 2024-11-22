package edu.unisabana.dyas.programacionreactiva;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

class TemperatureReading {
    private final String sensorId;
    private final double temperatureCelsius;  // Temperatura en Celsius
    private final String zone;

    public TemperatureReading(String sensorId, double temperatureCelsius, String zone) {
        this.sensorId = sensorId;
        this.temperatureCelsius = temperatureCelsius;
        this.zone = zone;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public String getZone() {
        return zone;
    }

    // Método para convertir Celsius a Fahrenheit
    public double toFahrenheit() {
        return (temperatureCelsius * 9 / 5) + 32;
    }
}

public class CityTemperatureMonitoring {

    public static void main(String[] args) {
        // Crear algunas lecturas de temperatura para diferentes sensores y zonas
        List<TemperatureReading> readings = Arrays.asList(
                new TemperatureReading("Sensor1", 32.5, "North"),
                new TemperatureReading("Sensor2", 28.0, "South"),
                new TemperatureReading("Sensor3", 35.0, "East"),
                new TemperatureReading("Sensor4", 27.0, "West"),
                new TemperatureReading("Sensor5", 33.5, "North"),
                new TemperatureReading("Sensor6", 29.0, "South"),
                new TemperatureReading("Sensor7", 32.5, "East"), // Duplicado de temperatura
                new TemperatureReading("Sensor8", 30.0, "West")
        );

        // Empezamos creando un Observable a partir de la lista de lecturas
        Observable<TemperatureReading> temperatureObservable = Observable.fromIterable(readings);

        // 1. Filtramos las lecturas que son mayores a 30°C
        Observable<TemperatureReading> highTemperatureObservable = temperatureObservable
                .filter(reading -> reading.getTemperatureCelsius() > 30);

        // 2. Convertimos las temperaturas de Celsius a Fahrenheit
        Observable<Double> fahrenheitObservable = highTemperatureObservable
                .map(TemperatureReading::toFahrenheit);

        // 3. Agrupamos las lecturas por zona usando flatMap
        Observable<String> groupedByZoneObservable = highTemperatureObservable
                .flatMap(reading -> Observable.just(reading.getZone() + " - " + reading.getSensorId()));

        // 4. Combinamos las lecturas de temperatura de zonas diferentes usando merge
        Observable<String> mergedZonesObservable = Observable.merge(
                highTemperatureObservable.filter(reading -> "North".equals(reading.getZone())),
                highTemperatureObservable.filter(reading -> "South".equals(reading.getZone()))
        ).map(reading -> reading.getZone() + " - " + reading.getTemperatureCelsius());

        // 5. Usamos zip para combinar temperaturas de la zona Norte y Sur
        Observable<String> combinedZoneTemperatures = Observable.zip(
                highTemperatureObservable.filter(reading -> "North".equals(reading.getZone())),
                highTemperatureObservable.filter(reading -> "South".equals(reading.getZone())),
                (northReading, southReading) -> "North: " + northReading.getTemperatureCelsius() + "°C / South: " + southReading.getTemperatureCelsius() + "°C"
        );

        // 6. Eliminar temperaturas duplicadas utilizando distinct
        Observable<TemperatureReading> distinctTemperatureObservable = highTemperatureObservable
                .distinct(reading -> reading.getTemperatureCelsius()); // Eliminamos duplicados por temperatura

        // 7. Acumulamos las temperaturas utilizando scan
        Observable<Double> accumulatedTemperatures = highTemperatureObservable
                .scan(0.0, (acc, reading) -> acc + reading.getTemperatureCelsius()); // Acumulación de temperaturas

        // 8. Tomamos solo las primeras 3 emisiones usando take
        Observable<TemperatureReading> limitedTemperatureObservable = highTemperatureObservable
                .take(3); // Limita la emisión a 3 elementos

        // 9. Realizamos un log en cada emisión utilizando doOnNext
        Observable<TemperatureReading> loggedTemperatureObservable = highTemperatureObservable
                .doOnNext(reading -> System.out.println("Processing temperature: " + reading.getTemperatureCelsius() + "°C"));

        // Suscripción e impresión de resultados
        System.out.println("High Temperatures in Fahrenheit:");
        fahrenheitObservable.subscribe(temp -> System.out.println(temp + "°F"));

        System.out.println("\nGrouped by Zones:");
        groupedByZoneObservable.subscribe(zone -> System.out.println(zone));

        System.out.println("\nMerged Zones Temperatures:");
        mergedZonesObservable.subscribe(zoneData -> System.out.println(zoneData));

        System.out.println("\nCombined North and South Temperatures:");
        combinedZoneTemperatures.subscribe(tempData -> System.out.println(tempData));

        System.out.println("\nDistinct High Temperatures:");
        distinctTemperatureObservable.subscribe(distinctReading -> System.out.println(distinctReading.getTemperatureCelsius() + "°C"));

        System.out.println("\nAccumulated Temperatures:");
        accumulatedTemperatures.subscribe(accumulatedTemp -> System.out.println("Accumulated: " + accumulatedTemp + "°C"));

        System.out.println("\nLimited to First 3 Temperatures:");
        limitedTemperatureObservable.subscribe(temp -> System.out.println(temp.getTemperatureCelsius() + "°C"));

        System.out.println("\nLogging Temperature Processing:");
        loggedTemperatureObservable.subscribe(temp -> System.out.println("Processed: " + temp.getTemperatureCelsius() + "°C"));
    }
}