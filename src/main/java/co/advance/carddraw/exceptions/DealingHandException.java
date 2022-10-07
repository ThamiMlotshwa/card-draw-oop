package co.advance.carddraw.exceptions;

/**
 * An exception for reporting issues in the dealing of hands
 * @author Thami Mlotshwa
 */
public class DealingHandException extends RuntimeException {
    public DealingHandException(String reason)
    {
        super(reason);
    }
}
