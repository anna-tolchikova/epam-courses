package by.bsuir.parsersservlet.exceptions;

public class NoSuchApplianceTypeException extends LogicalException {
    public NoSuchApplianceTypeException() {
    }

    public NoSuchApplianceTypeException(String message) {
        super(message);
    }

    public NoSuchApplianceTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
