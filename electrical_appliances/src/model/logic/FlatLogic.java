/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import java.util.Collections;
import java.util.Iterator;
import model.Abstractions.ElectricalAppliance;
import model.Flat;

/**
 *
 * @author Ann
 */
public class FlatLogic {

    private Flat flat;

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public int getTotalPower() {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        int total = 0;
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            total += item.getCurrentPowerConsumption();
        }
        return total;
    }

    public boolean switchOnElectricalAppliance() {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        boolean isSwitchedOn = false;
        while (iter.hasNext() && !isSwitchedOn) {
            ElectricalAppliance item = iter.next();
            if (!item.isSwitchedOn()) {
                item.setSwitchedOn(true);
                isSwitchedOn = true;
            }
        }
        return isSwitchedOn;
    }

    public void show() {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        int total = 0;
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            System.out.println("power = " + item.getMaximumPowerConsumption());
        }

    }
    public void sortByPowerASC() {
        Collections.sort(flat.getElectricalAppliances());
    }
    
}


