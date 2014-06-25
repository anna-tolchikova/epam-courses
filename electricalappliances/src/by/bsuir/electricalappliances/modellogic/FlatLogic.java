/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.electricalappliances.modelLogic;

import java.util.Iterator;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.model.Flatiron;
import by.bsuir.electricalappliances.model.Fridge;

/**
 *
 * @author Ann
 */
public class FlatLogic {

    public int calculateTotalPower(Flat flat) {
        Iterator<ElectricalAppliance> iterFl = flat.getElectricalAppliances().iterator();
        int total = 0;
        while (iterFl.hasNext()) {
            ElectricalAppliance item = iterFl.next();
            total += item.getCurrentPowerConsumption();
        }
        return total;
    }

    public boolean switchOnFlatiron(Flat flat) {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        boolean isSwitchedOn = false;
        while (iter.hasNext() && !isSwitchedOn) {
            ElectricalAppliance item = iter.next();
            if (!item.isSwitchedOn() && item instanceof Flatiron ) {
                item.setSwitchedOn(true);
                isSwitchedOn = true;
            }
        }
        return isSwitchedOn;
    }

    public boolean switchOnFridge(Flat flat) {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        boolean isSwitchedOn = false;
        while (iter.hasNext() && !isSwitchedOn) {
            ElectricalAppliance item = iter.next();
            if (!item.isSwitchedOn() && item instanceof Fridge) {
                item.setSwitchedOn(true);
                isSwitchedOn = true;
            }
        }
        return isSwitchedOn;
    }
    
}


