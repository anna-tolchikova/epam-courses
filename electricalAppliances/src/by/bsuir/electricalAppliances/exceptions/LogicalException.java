package by.bsuir.electricalappliances.exceptions;

public class LogicalException extends Exception{

    public LogicalException() {
        super();
    }
    public LogicalException(String message) {
        super(message);
    }

    public LogicalException(String message, Throwable cause) {
        super(message, cause);
    }

}
