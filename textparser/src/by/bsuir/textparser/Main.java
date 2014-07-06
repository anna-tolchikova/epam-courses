package by.bsuir.textparser;

import by.bsuir.textparser.logic.TextProcessing;
import by.bsuir.textparser.parser.TextParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.*;

public class Main {

    static Logger log = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("textparser/log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {

        // parse text from file and build it again with rewrite into new file
        TextParser parser = new TextParser();
        log.info("Start parsing");
        parser.parseToFile("textparser" + File.separatorChar + "text.txt", "textparser" + File.separatorChar + "result.txt");
        log.info("Finish parsing");

        // cut the max substring
        TextProcessing textProcessor = new TextProcessing();
        log.info("Count of cutted sententence parts: " + textProcessor.cutMaxSubstring(parser.getCompositeText(), "CL", "CL"));

    }


}
