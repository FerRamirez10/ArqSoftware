/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author Diego
 */
public interface PizzaFactory {
    Amasar crearAmasador();
    Moldear crearMoldeador();
    Hornear crearHorneador();
}