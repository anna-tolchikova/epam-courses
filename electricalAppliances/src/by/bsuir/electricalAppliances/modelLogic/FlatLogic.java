/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.electricalAppliances.modelLogic;

import java.util.Collections;
import java.util.Iterator;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import by.bsuir.electricalAppliances.model.Flat;
import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.model.Fridge;

/**
 *
 * @author Ann
 */
public class FlatLogic {

    private Flat flat;

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public int calculateTotalPower() {
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

    public boolean switchOnFlatiron() {
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

    public boolean switchOnFridge() {
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

    public void sortEachCategoryByPowerASC() {
        sortFlatironsByPowerASC();
        sortFridgesByPowerASC();
    }

    public void sortFlatironsByPowerASC() {
        Collections.sort(flat.getFlatirons());
    }

    public void sortFridgesByPowerASC() {
        Collections.sort(flat.getFridges());
    }
    
}


