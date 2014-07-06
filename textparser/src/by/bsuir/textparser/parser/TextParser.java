package by.bsuir.textparser.parser;

import by.bsuir.textparser.composite.*;
import by.bsuir.textparser.exceptions.LogicalException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser {
    static Logger log = Logger.getLogger(TextParser.class);
    static Properties prop = new Properties();

    static {
        new DOMConfigurator().doConfigure("textparser/log4j.xml", LogManager.getLoggerRepository());
        try {
            prop.load(new InputStreamReader(new FileInputStream("textparser" + File.separatorChar + "src" + File.separatorChar + "patterns.properties"),"UTF-8"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private String textRegex;
    private String paragraphRegex;
    private String sentenceRegex;

    private Pattern textPattern;
    private Pattern paragraphPattern;
    private Pattern sentencePattern;

    private CompositeTextPart compositeText; // paragraphs(Composite) + code(Leaf)


    public TextParser() {

        textRegex = prop.getProperty("textRegex");
        paragraphRegex =prop.getProperty("paragraphRegex");
        sentenceRegex = prop.getProperty("sentenceRegex");

        textPattern = Pattern.compile(textRegex, Pattern.DOTALL | Pattern.COMMENTS);
        paragraphPattern = Pattern.compile(paragraphRegex, Pattern.DOTALL  | Pattern.COMMENTS);
        sentencePattern = Pattern.compile(sentenceRegex, Pattern.DOTALL | Pattern.COMMENTS);

        this.compositeText = new CompositeTextPart();
    }

    public CompositeTextPart getCompositeText() {
        return compositeText;
    }

    public void parse (String text) throws LogicalException {
        Matcher matcher = textPattern.matcher(text);
        while(matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null){
                 throw new LogicalException("Invalid block: "+matcher.group());
            }
            else if (matcher.group(1) != null) {
                  compositeText.add(parseParagraph(matcher.group(1)));
            }
            else if (matcher.group(2) != null) {
                CodeLeaf codePart = new CodeLeaf(matcher.group(2));
                compositeText.add(codePart);
            }
            else{
                throw new LogicalException("Invalid block: "+matcher.group());
            }
        }
    }


    public CompositeTextPart parseParagraph(String paragraph) throws LogicalException { // parse paragraph into sentences
        CompositeTextPart compositeParagraph = new CompositeTextPart();
        Matcher matcher = paragraphPattern.matcher(paragraph);
        while (matcher.find()) {
            if (matcher.group() != null) {
                compositeParagraph.add(this.parseSentence(matcher.group()));
            }
            else throw new LogicalException("Invalid block: "+matcher.group());
         }
        return compositeParagraph;
    }

    public CompositeTextPart parseSentence(String sentence) throws LogicalException { // parse sentences into words and punctuation
        CompositeTextPart compositeSentence = new CompositeTextPart();
        Matcher matcher = sentencePattern.matcher(sentence);
        while (matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null){
                throw new LogicalException("Invalid block: "+matcher.group());
            }
            else if (matcher.group(1) != null) {
                WordLeaf word =  new WordLeaf(matcher.group(1));
                compositeSentence.add(word);
            }

            else if (matcher.group(2) != null) {
                PunctuationCharacterLeaf character;
                character = new PunctuationCharacterLeaf(matcher.group(2).charAt(0));
                compositeSentence.add(character);
            }
            else{
                throw new LogicalException("Invalid block: "+matcher.group());
            }
        }
        return compositeSentence;
    }

    public void parseToFile(String fileSource, String fileTarget) {
        File file = new File(fileTarget);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            this.parse(readFile(fileSource, StandardCharsets.UTF_8));
            for (Component textPart: compositeText.getChildParts()) {
                fw.write("\t");
                textPart.writeToFile(fw);
                fw.write("\n");
            }
        } catch (LogicalException | IOException e) {
            log.error(e.getMessage());

        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

    }

    private static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
