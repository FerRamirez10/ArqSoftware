/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author Diego
 */
public class PizzaDelgadaFactory implements PizzaFactory {

    @Override
    public Amasar crearAmasador() {
        return new AmasadorPizzaDelgada();
    }

    @Override
    public Moldear crearMoldeador() {
        return new MoldeadorPizzaDelgada();
    }

    @Override
    public Hornear crearHorneador() {
        return new HorneadorPizzaDelgada();
    }
}
