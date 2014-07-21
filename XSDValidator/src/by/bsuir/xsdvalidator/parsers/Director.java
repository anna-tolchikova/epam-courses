package by.bsuir.xsdvalidator.parsers;

import by.bsuir.xsdvalidator.parsers.BaseParser;
import by.bsuir.xsdvalidator.model.Flat;


public class Director {
    private BaseParser flatParser;

    public Director(BaseParser flatParser) {
        this.flatParser = flatParser;
    }

    public Flat getFlat() {
         return flatParser.getFlat();
    }

    public void constructFlat(String filename) {
        flatParser.createNewFlat();
        flatParser.parseFlatirons(filename);
        flatParser.parseFridges(filename);
    }

}
