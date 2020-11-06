package co.mydiary.exceptions;

public class NoBabyInfoForYearException extends RuntimeException {

    public NoBabyInfoForYearException() {
        super("No information available for this year");
    }
}
