package by.bsuir.electricalappliances.modelLogic;

import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import java.util.Collections;
import java.util.Comparator;

public class FlatSorting {

    public void sortAppliancesByMaxPower(Flat flat) {
        Collections.sort(flat.getElectricalAppliances(), new SortedByPower());
    }

    public void sortAppliancesByMaxPowerDESC(Flat flat) {
        Collections.sort(flat.getElectricalAppliances(), new SortedByPowerDESC());
    }

    public void sortAppliancesByCurrentPower(Flat flat) {
        Collections.sort(flat.getElectricalAppliances(), new SortedByCurrentPower());
    }

    public void sortAppliancesByCurrentPowerDESC(Flat flat) {
        Collections.sort(flat.getElectricalAppliances(), new SortedByCurrentPowerDESC());
    }

}

class SortedByPower implements Comparator<ElectricalAppliance> {

    public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
        int result =  o1.getMaxPowerConsumption() - o2.getMaxPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}

class SortedByPowerDESC implements Comparator<ElectricalAppliance> {

    public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
        int result =  o2.getMaxPowerConsumption() - o1.getMaxPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}

class SortedByCurrentPower implements Comparator<ElectricalAppliance> {

    public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
        int result =  o1.getCurrentPowerConsumption() - o2.getCurrentPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}

class SortedByCurrentPowerDESC implements Comparator<ElectricalAppliance> {
    public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
        int result =  o2.getCurrentPowerConsumption() - o1.getCurrentPowerConsumption();
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

}
