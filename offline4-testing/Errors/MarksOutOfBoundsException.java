package Errors;

public class MarksOutOfBoundsException extends RuntimeException {
    public MarksOutOfBoundsException() {
        super("Provided marks is less than 0, or higher than 400");
    }
}