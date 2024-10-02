package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateValidVoter() {
        Person person = new Person("John Doe", 123456789, 25, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateUnderageVoter() {
        Person person = new Person("Jane Doe", 987654321, 16, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateDeadVoter() {
        Person person = new Person("Dead Person", 111222333, 45, Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateDuplicatedVoter() {
        // Simulamos que ya existe un votante registrado con este ID
        Person existingVoter = new Person("Existing Voter", 444555666, 30, Gender.MALE, true);
        registry.registerVoter(existingVoter); // Registro inicial

        // Intento de registrar al mismo votante
        Person duplicateVoter = new Person("Duplicate Voter", 444555666, 28, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(duplicateVoter);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateInvalidAge() {
        Person person = new Person("Invalid Age", 222333444, -5, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    // TODO Complete with more test cases if needed
}
