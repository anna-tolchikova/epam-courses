package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.model.Fridge;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class ConcreteBuilder extends BaseBuilder{

    public void addFlatirons (ArrayList<ElectricalAppliance> flatirons) {
        Iterator<ElectricalAppliance> iter = flatirons.iterator();
        while (iter.hasNext()) {
            ElectricalAppliance flatiron = iter.next();
            flat.addFlatiron(flatiron);
        }
    }

    public void addFridges (ArrayList<ElectricalAppliance> fridges) {
        Iterator<ElectricalAppliance> iter = fridges.iterator();
        while (iter.hasNext()) {
            ElectricalAppliance fridge = iter.next();
            flat.addFridge(fridge);
        }
    }
}
