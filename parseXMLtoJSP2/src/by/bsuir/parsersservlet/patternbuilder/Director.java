package by.bsuir.parsersservlet.patternbuilder;


import by.bsuir.parsersservlet.model.Flat;

import java.io.FileInputStream;


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
