package Errors;

public class InvalidCreditsException extends RuntimeException {
    public InvalidCreditsException() {
        super("Provided course credit is not valid");
    }
}