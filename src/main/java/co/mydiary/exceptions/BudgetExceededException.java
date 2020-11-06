package co.mydiary.exceptions;

public class BudgetExceededException extends RuntimeException {

    public BudgetExceededException() {
        super("Amount exceeded Max set budget ");
    }
}
