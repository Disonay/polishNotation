package utils.exceptions;

public class WrongPolishNotation extends Exception {
    public WrongPolishNotation(String message) {
        super(message);
    }

    public WrongPolishNotation(String message, Exception cause) {
        super(message, cause);
    }
}
