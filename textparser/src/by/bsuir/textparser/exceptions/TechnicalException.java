package by.bsuir.textparser.exceptions;


public class TechnicalException extends Exception {

    public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
