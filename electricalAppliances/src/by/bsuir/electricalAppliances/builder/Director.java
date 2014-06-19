package by.bsuir.electricalAppliances.builder;

import by.bsuir.electricalAppliances.model.Flat;
import by.bsuir.electricalAppliances.model.Flatiron;
import by.bsuir.electricalAppliances.model.Fridge;
import by.bsuir.electricalAppliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;

public class Director {
    private BaseBuilder flatBuilder;

    public Director(BaseBuilder flatBuilder) {
        this.flatBuilder = flatBuilder;
    }

    public Flat getFlat() {
         return flatBuilder.getFlat();
    }

    public void constructFlat(ArrayList<ElectricalAppliance> flatirons, ArrayList<ElectricalAppliance> fridges) {
        flatBuilder.createNewFlat();
        flatBuilder.addFlatirons(flatirons);
        flatBuilder.addFridges(fridges);
    }

}
