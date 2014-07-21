package by.bsuir.parsersservlet.patterncommand.enums;

import by.bsuir.parsersservlet.patternbuilder.DOMParser;
import by.bsuir.parsersservlet.patternbuilder.Director;
import by.bsuir.parsersservlet.patternbuilder.SAXParser;
import by.bsuir.parsersservlet.patternbuilder.STAXParser;

public enum ParseCommandEnum {
    PARSEDOM {
        {
            this.director = new Director(new DOMParser());
        }
    },
    PARSESTAX {
        {
            this.director = new Director(new STAXParser());
        }
    },
    PARSESAX {
        {
            this.director = new Director(new SAXParser());
        }
    };
    Director director;
    public Director getDirector() {
        return director;
    }
}
