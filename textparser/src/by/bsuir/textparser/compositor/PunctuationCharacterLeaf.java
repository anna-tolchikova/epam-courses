package by.bsuir.textparser.compositor;

import org.apache.log4j.Logger;

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

    public void print() {
        log.info(this);
    }

}
