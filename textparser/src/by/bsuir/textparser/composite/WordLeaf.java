package by.bsuir.textparser.composite;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class WordLeaf  implements Component {

    static Logger log = Logger.getLogger(WordLeaf.class);

    private String word;

    public WordLeaf(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public void writeToFile(FileWriter fw) {
        try {
            fw.write(this.toString());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String toString () {
        return  " " + this.word;
    }

}
