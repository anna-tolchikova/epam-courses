package by.bsuir.textparser.compositor;

import org.apache.log4j.Logger;

public class CodeLeaf implements Component {

    static Logger log = Logger.getLogger(CodeLeaf.class.getName());

    private String code;

    public CodeLeaf(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void print() {
        log.info(this);
    }

    @Override
    public String toString() {
        return "###\n\n" + this.code + "\n\n###";
    }


}
