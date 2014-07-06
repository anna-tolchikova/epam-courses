package by.bsuir.textparser.logic;

import by.bsuir.textparser.composite.Component;
import by.bsuir.textparser.composite.CompositeTextPart;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.regex.Pattern;


public class TextProcessing {

    static Logger log = Logger.getLogger(TextProcessing.class);
    static {
        new DOMConfigurator().doConfigure("textparser/log4j.xml", LogManager.getLoggerRepository());
    }


    private String maxSubstringRegex;
    //private String firstLastWordRegex;
    private Pattern pattern;

    public TextProcessing() {
        this.maxSubstringRegex = ".*";
        //this.firstLastWordRegex = ;
    }

    public int cutMaxSubstring (CompositeTextPart compositeText, String start, String end) {
        log.info("cutMaxSubstring:");
        int countOfCutted = 0;
        String sentence;
        String oldSentence;
        for (Component compositeParagraph : compositeText.getChildParts()) {
            if (compositeParagraph instanceof CompositeTextPart) {
               for (Component compositeSentence : ((CompositeTextPart) compositeParagraph).getChildParts()) {
                   sentence = compositeSentence.toString();
                   oldSentence  = new String(sentence);
                   sentence = sentence.replaceAll(start + maxSubstringRegex + end, "");
                   if (!sentence.equals(oldSentence)) {
                       log.info("before *** " + oldSentence);
                       log.info("after *** " + sentence);
                       countOfCutted++;
                   }
               }
            }
        }
        return countOfCutted;
    }

    public void replaceFirstLastWordInSentence (CompositeTextPart compositeText) {
        log.info("replaceFirstLastWordInSentence:");
    }
}
