package by.bsuir.textparser.logic;

import by.bsuir.textparser.composite.Component;
import by.bsuir.textparser.composite.CompositeTextPart;

import by.bsuir.textparser.exceptions.TechnicalException;
import by.bsuir.textparser.parser.TextParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Collections;
import java.util.regex.Pattern;


public class TextProcessing {

    static Logger log = Logger.getLogger(TextProcessing.class);

    private String maxSubstringRegex;

    public TextProcessing() {
        this.maxSubstringRegex = ".*";
    }

    public int cutMaxSubstring (CompositeTextPart compositeText, String start, String end) {
        log.info("cutMaxSubstring:");
        int countOfCut = 0;
        String sentence;
        String oldSentence;
        for (Component compositeParagraph : compositeText.getChildParts()) {
            //work with paragraph
            if (compositeParagraph instanceof CompositeTextPart)
                for (Component compositeSentence : ((CompositeTextPart) compositeParagraph).getChildParts()) {    //getting sentences from paragraph
                    oldSentence = compositeSentence.toString();
                    if (oldSentence.matches(".*" + start + ".*" + end + ".*")) {

                            log.info("before *** " + oldSentence);
                            String newSentence = oldSentence.replaceAll(start + maxSubstringRegex + end, "");

                            TextParser textParser = new TextParser();
                            try {
                                compositeSentence = textParser.parseSentence(newSentence);
                            } catch (TechnicalException e) {
                                log.error(e.getMessage());
                            }
                            countOfCut++;

                            log.info("after *** " + compositeSentence.toString());

                    }
                }
        }
        return countOfCut;
    }

    public void replaceFirstLastWordInSentence (CompositeTextPart compositeText) {
        log.info("replaceFirstLastWordInSentence:");
    }
}
