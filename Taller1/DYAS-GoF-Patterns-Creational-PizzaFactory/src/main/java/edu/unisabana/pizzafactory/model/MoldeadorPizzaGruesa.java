/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author Diego
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoldeadorPizzaGruesa implements Moldear {

    @Override
    public void moldearPizzaPequena() {
        Logger.getLogger(MoldeadorPizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa gruesa.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    @Override
    public void moldearPizzaMediana() {
        Logger.getLogger(MoldeadorPizzaGruesa.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa gruesa.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}