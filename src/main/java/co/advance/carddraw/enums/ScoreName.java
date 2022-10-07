package co.advance.carddraw.enums;

/**
 * An enum for the types of ranking scores
 * @author Thami Mlotshwa
 */
public enum ScoreName
{
    STRAIGHT_FLUSH("Straight flush"),
    FOUR_OF_A_KIND("Four of a kind"),
    FULL_HOUSE("Full house"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a kind"),
    TWO_PAIR("Two pair"),
    ONE_PAIR("One pair"),
    HIGH_CARD("High card");

    private final String name;
    private ScoreName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
