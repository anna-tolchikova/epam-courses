/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.model.Flat;
import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.model.Fridge;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;

/**
 *
 * @author Ann
 */
public abstract class BaseBuilder {
    protected Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void createNewFlat() {
        this.flat = new Flat();
    }

    public abstract void addFlatirons(ArrayList<ElectricalAppliance> flatirons);
    public abstract void addFridges(ArrayList<ElectricalAppliance> fridges);
}
