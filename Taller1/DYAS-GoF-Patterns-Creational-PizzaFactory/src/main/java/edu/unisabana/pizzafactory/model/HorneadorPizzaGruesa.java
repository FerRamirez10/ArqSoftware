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

public class HorneadorPizzaGruesa implements Hornear {

    @Override
    public void hornear() {
        Logger.getLogger(HorneadorPizzaGruesa.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza gruesa con masa gruesa.");
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}
