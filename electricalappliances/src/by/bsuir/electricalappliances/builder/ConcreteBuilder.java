package by.bsuir.electricalappliances.builder;

import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Iterator;

public class ConcreteBuilder extends BaseBuilder{

    public void addElectricalAppliances (ArrayList<ElectricalAppliance> electricalAppliances) {
        Iterator<ElectricalAppliance> iter = electricalAppliances.iterator();
        while (iter.hasNext()) {
            ElectricalAppliance electricalAppliance = iter.next();
            flat.addElectricalAppliance(electricalAppliance);
        }
    }

}
