package by.bsuir.electricalAppliances.factoryMethod;

import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class FlatironCreator extends Creator {

    @Override
    public ElectricalAppliance factoryMethod() {
        return new Flatiron();
    }
}
