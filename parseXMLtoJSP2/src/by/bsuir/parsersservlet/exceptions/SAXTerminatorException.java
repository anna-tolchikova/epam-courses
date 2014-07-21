package by.bsuir.parsersservlet.exceptions;


import org.xml.sax.SAXException;

public class SAXTerminatorException extends SAXException {

    public SAXTerminatorException() {
    }

    public SAXTerminatorException(String s) {
        super(s);
    }

    public SAXTerminatorException(Exception e) {
        super(e);
    }
}
