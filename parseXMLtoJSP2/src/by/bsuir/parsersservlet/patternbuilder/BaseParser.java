package by.bsuir.parsersservlet.patternbuilder;

import by.bsuir.parsersservlet.model.Flat;
import by.bsuir.parsersservlet.modelabstractions.ElectricalAppliance;

import java.io.FileInputStream;
import java.util.ArrayList;

public abstract class BaseParser {
    protected Flat flat;

    enum FlatironEnum {

        ELECTRICALAPPLIANCES("electricalappliances"),
        FLATIRONS("flatirons"),
        FLATIRON("flatiron"),
        ID("id"),
        PRODUCER("producer"),
        MODEL("model"),
        SOLEPLATE("soleplate"),
        FLATIRON_POWER("flatiron_power"),
        WATER_VOLUME("water_volume");

        String xmlInfo;

        FlatironEnum(String xmlInfo) {
            this.xmlInfo = xmlInfo;
        }

        public String getXmlInfo() {
            return xmlInfo;
        }
    }

    enum FridgeEnum {

        ELECTRICALAPPLIANCES("electricalappliances"),
        FRIDGES("fridges"),
        FRIDGE("fridge"),
        ID("id"),
        PRODUCER("producer"),
        MODEL("model"),
        POWER("power"),
        POWER_CONSUMPTION_CLASS("power_consumption_class"),
        VOLUME("volume");

        String xmlInfo;

        FridgeEnum(String xmlInfo) {
            this.xmlInfo = xmlInfo;
        }

        public String getXmlInfo() {
            return xmlInfo;
        }
    }

    public Flat getFlat() {
        return flat;
    }

    public void createNewFlat() {
        this.flat = new Flat();
    }

    public abstract void parseFlatirons(String filename);
    public abstract void parseFridges(String filename);
}
