package exceptions;

public class DateNotParsedException extends GladosException {
    /**
     * Constructs DateNotParsedException by calling the parent class.
     */
    public DateNotParsedException() {
        super("Date is incorrectly formatted (should be yyyy-MM-dd)");
    }
}
