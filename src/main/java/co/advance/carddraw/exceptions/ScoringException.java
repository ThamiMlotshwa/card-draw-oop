package co.advance.carddraw.exceptions;

/**
 * An exception for reporting issues in the scoring of hands
 * @author Thami Mlotshwa
 */
public class ScoringException extends RuntimeException {
    public ScoringException(String reason)
    {
        super(reason);
    }
}
