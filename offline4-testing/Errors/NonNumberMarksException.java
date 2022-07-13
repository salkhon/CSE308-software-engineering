package Errors;

public class NonNumberMarksException extends RuntimeException {
    public NonNumberMarksException() {
        super("Provided marks is not a number");
    }
}