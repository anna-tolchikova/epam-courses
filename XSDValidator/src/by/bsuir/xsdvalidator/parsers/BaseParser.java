package by.bsuir.xsdvalidator.parsers;

import by.bsuir.xsdvalidator.model.Flat;
import by.bsuir.xsdvalidator.modelabstractions.ElectricalAppliance;

import java.util.ArrayList;

public abstract class BaseParser {
    protected Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void createNewFlat() {
        this.flat = new Flat();
    }

    public abstract void parseFlatirons(String filename);
    public abstract void parseFridges(String filename);
}
