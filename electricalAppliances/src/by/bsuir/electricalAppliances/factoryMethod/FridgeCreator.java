package by.bsuir.electricalAppliances.factoryMethod;

import by.bsuir.electricalAppliances.model.Fridge;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;

public class FridgeCreator extends Creator {

    @Override
    public ElectricalAppliance factoryMethod() {
        return new Fridge();
    }
}
