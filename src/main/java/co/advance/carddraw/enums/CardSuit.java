package co.advance.carddraw.enums;

/**
 * An enum for card suits
 * @author Thami Mlotshwa
 */
public enum CardSuit
{
    HEARTS("♥", "H"),
    DIAMONDS("♦", "D"),
    SPADES("♠", "S"),
    CLUBS("♣", "C");

    private final String suitSymbol;
    private final String suitLetter;
    CardSuit(String symbol, String letter)
    {
        this.suitSymbol = symbol;
        this.suitLetter = letter;
    }

    @Override
    public String toString()
    {
        return suitSymbol;
    }

    /**
     * Get the symbol associated with the card suit. This is necessary for logic
     * @return The card suit symbol
     */
    public String getLetter() { return suitLetter; }
}
