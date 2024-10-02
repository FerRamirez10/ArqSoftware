package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    private Set<Integer> registeredIds = new HashSet<>(); // Para almacenar IDs de votantes registrados

    public RegisterResult registerVoter(Person p) {
        // Verificar si la persona está viva
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        // Verificar la edad inválida primero
        if (p.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        }

        // Verificar si la persona es menor de edad
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si el ID ya está registrado
        if (registeredIds.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        // Registrar el votante
        registeredIds.add(p.getId());
        return RegisterResult.VALID;
    }
}