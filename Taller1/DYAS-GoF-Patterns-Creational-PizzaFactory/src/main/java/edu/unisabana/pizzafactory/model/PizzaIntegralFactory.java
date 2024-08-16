/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author Diego
 */

public class PizzaIntegralFactory implements PizzaFactory {

    @Override
    public Amasar crearAmasador() {
        return new AmasadorPizzaIntegral();
    }

    @Override
    public Moldear crearMoldeador() {
        return new MoldeadorPizzaIntegral();
    }

    @Override
    public Hornear crearHorneador() {
        return new HorneadorPizzaIntegral();
    }
}