package by.bsuir.textparser;

import by.bsuir.textparser.parser.TextParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
       TextParser parser = new TextParser();
    }

}
