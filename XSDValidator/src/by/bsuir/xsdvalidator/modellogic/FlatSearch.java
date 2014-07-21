package by.bsuir.xsdvalidator.modellogic;

import by.bsuir.xsdvalidator.exceptions.TechnicalException;
import by.bsuir.xsdvalidator.model.Flat;
import by.bsuir.xsdvalidator.modelabstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class FlatSearch {

    public Flat findAppliancesBySwitchingOn(Flat flat, boolean isSwitchedOn) {
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        Flat result = new Flat();
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            if (item.isSwitchedOn() == isSwitchedOn) {
                result.addElectricalAppliance(item);
            }
        }
        return result;
    }

    public Flat findAppliancesByProducer(Flat flat, String producer) {
        Flat result = new Flat();
        if ( producer == null) {
            return result;
        }
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();        
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            if (item.getProducer().equals(producer)) {
                result.addElectricalAppliance(item);
            }
        }
        return result;
    }

    public Flat findAppliancesByMaxPowerConsumpiton(Flat flat, int maxPowerConsumpiton) throws TechnicalException {
        if (maxPowerConsumpiton < 0) {
            throw new TechnicalException(" incorrect parameter \'maxPowerConsumpiton\' ");
        }
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        Flat result = new Flat();
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            if (item.getMaxPowerConsumption() == maxPowerConsumpiton) {
                result.addElectricalAppliance(item);
            }
        }
        return result;
    }

    public Flat findAppliancesByMaxPowerConsumpitonRange(Flat flat, int from, int to) throws TechnicalException {

        Flat result = new Flat();
        if (from < 0 || to < 0 || to < from) {
            throw new TechnicalException(" incorrect parameters from\\to ");
        }
        Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
        while (iter.hasNext()) {
            ElectricalAppliance item = iter.next();
            int maxPowerConsumpiton = item.getMaxPowerConsumption();
            if (maxPowerConsumpiton >= from && maxPowerConsumpiton <= to) {
                result.addElectricalAppliance(item);
            }
        }
        return result;
    }

    public Flat findAppliancesByCurrentPowerConsumpitonRange(Flat flat, int from, int to) throws TechnicalException {

        Flat result = new Flat();
            if (from < 0 || to < 0 || to < from) {
                throw new TechnicalException(" incorrect parameters from\\to ");
            }
            Iterator<ElectricalAppliance> iter = flat.getElectricalAppliances().iterator();
            while (iter.hasNext()) {
                ElectricalAppliance item = iter.next();
                int curPowerConsumpiton = item.getCurrentPowerConsumption();
                if (curPowerConsumpiton >= from && curPowerConsumpiton <= to) {
                    result.addElectricalAppliance(item);
                }
            }
        return result;
    }
}
