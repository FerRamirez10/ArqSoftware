package edu.unisabana.pizzafactory.consoleview;

/**
 *
 * @author cesarvefe
 */

import edu.unisabana.pizzafactory.model.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreparadorPizza {

    public static void main(String args[]){
        try {
            Ingrediente[] ingredientes = new Ingrediente[]{new Ingrediente("queso", 1), new Ingrediente("jamon", 2)};            
            PreparadorPizza pp = new PreparadorPizza();            
            pp.prepararPizza(ingredientes, Tamano.MEDIANO, "gruesa"); // Añade un parámetro para seleccionar el tipo de pizza
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
    }

    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam, String tipoPizza)
            throws ExcepcionParametrosInvalidos {

        PizzaFactory factory;
        switch (tipoPizza) {
            case "delgada":
                factory = new PizzaDelgadaFactory();
                break;
            case "gruesa":
                factory = new PizzaGruesaFactory();
                break;
            case "integral":
                factory = new PizzaIntegralFactory();
                break;
            default:
                throw new ExcepcionParametrosInvalidos("Tipo de pizza invalido:" + tipoPizza);
        }

        Amasar am = factory.crearAmasador();
        Moldear mp = factory.crearMoldeador();
        Hornear hpd = factory.crearHorneador();

        am.amasar();
        if (null == tam) {
            throw new ExcepcionParametrosInvalidos("Tamano de pizza invalido:" + tam);
        } else switch (tam) {
            case PEQUENO:
                mp.moldearPizzaPequena();
                break;
            case MEDIANO:
                mp.moldearPizzaMediana();
                break;
            default:
                throw new ExcepcionParametrosInvalidos("Tamano de pizza invalido:" + tam);
        }

        aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}