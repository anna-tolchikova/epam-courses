package by.bsuir.textparser.composite;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class PunctuationCharacterLeaf  implements Component {

    static Logger log = Logger.getLogger(CodeLeaf.class.getName());

    private Character character;

    public PunctuationCharacterLeaf (Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public void writeToFile(FileWriter fw) {
        try {
            fw.write(this.character);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String toString () {
        return  String.valueOf(character);
    }

}
