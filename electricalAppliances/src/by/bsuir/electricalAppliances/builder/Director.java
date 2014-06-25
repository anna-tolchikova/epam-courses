package by.bsuir.electricalappliances.builder;

import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
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
        flatBuilder.addElectricalAppliances(flatirons);
        flatBuilder.addElectricalAppliances(fridges);
    }

}
