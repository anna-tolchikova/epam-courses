package by.bsuir.electricalappliances.builder;

import by.bsuir.electricalappliances.model.Flat;
import by.bsuir.electricalappliances.model.Flatiron;
import by.bsuir.electricalappliances.modelAbstractions.ElectricalAppliance;
import java.util.ArrayList;

public abstract class BaseBuilder {
    protected Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void createNewFlat() {
        this.flat = new Flat();
    }

    public abstract void addElectricalAppliances(ArrayList<ElectricalAppliance> flatirons);


}
