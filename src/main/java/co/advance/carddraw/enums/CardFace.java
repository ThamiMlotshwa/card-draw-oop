package co.advance.carddraw.enums;

import java.util.Objects;

/**
 * An enum for card face symbols
 * @author Thami Mlotshwa
 */
public enum CardFace
{
    ACE("A"),
    KING("K"),
    QUEEN("Q"),
    JACK("J"),
    TEN("T"),
    NINE("9"),
    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2");

    private final String valueSymbol;

    CardFace(String symbol)
    {
        this.valueSymbol = symbol;

    }

    @Override
    public String toString()
    {
        return !Objects.equals(valueSymbol, "T") ? valueSymbol : "10";
    }

    /**
     * Get the symbol associated with the card face. This is necessary for logic
     * @return The card face symbol
     */
    public String getSymbol()
    {
        return valueSymbol;
    }
}
