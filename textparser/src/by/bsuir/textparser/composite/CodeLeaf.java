package by.bsuir.textparser.composite;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class CodeLeaf implements Component {

    static Logger log = Logger.getLogger(CodeLeaf.class);

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


    @Override
    public void writeToFile(FileWriter fw) {
        try {
            fw.write(this.toString());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "\n&&&" + this.code + "!&&&";
    }


}
