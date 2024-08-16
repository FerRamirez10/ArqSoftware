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

public class AmasadorPizzaIntegral implements Amasar {

    @Override
    public void amasar() {
        Logger.getLogger(AmasadorPizzaIntegral.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza integral con masa integral.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}