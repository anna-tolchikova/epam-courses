/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.electricalAppliances.modelLogic;

import java.util.Iterator;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import by.bsuir.electricalAppliances.model.Flat;

/**
 *
 * @author Ann
 */
public class FlatLogic {

    public int calculateTotalPower(Flat flat) {
        Iterator<ElectricalAppliance> iterFl = flat.getFlatirons().iterator();
        int total = 0;
        while (iterFl.hasNext()) {
            ElectricalAppliance item = iterFl.next();
            total += item.getCurrentPowerConsumption();
        }

        Iterator<ElectricalAppliance> iterFr = flat.getFridges().iterator();
        while (iterFr.hasNext()) {
            ElectricalAppliance item = iterFr.next();
            total += item.getCurrentPowerConsumption();
        }
        return total;
    }

    public boolean switchOnFlatiron(Flat flat) {
        Iterator<ElectricalAppliance> iterFl = flat.getFlatirons().iterator();
        boolean isSwitchedOn = false;
        while (iterFl.hasNext() && !isSwitchedOn) {
            ElectricalAppliance item = iterFl.next();
            if (!item.isSwitchedOn()) {
                item.setSwitchedOn(true);
                isSwitchedOn = true;
            }
        }
        return isSwitchedOn;
    }

    public boolean switchOnFridge(Flat flat) {
        Iterator<ElectricalAppliance> iterFr = flat.getFridges().iterator();
        boolean isSwitchedOn = false;
        while (iterFr.hasNext() && !isSwitchedOn) {
            ElectricalAppliance item = iterFr.next();
            if (!item.isSwitchedOn()) {
                item.setSwitchedOn(true);
                isSwitchedOn = true;
            }
        }
        return isSwitchedOn;
    }
    
}


