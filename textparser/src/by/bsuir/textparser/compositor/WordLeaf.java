package by.bsuir.textparser.compositor;

import org.apache.log4j.Logger;

public class WordLeaf  implements Component {

    static Logger log = Logger.getLogger(CodeLeaf.class.getName());

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



    public void print() {
        log.info(this);
    }

}
