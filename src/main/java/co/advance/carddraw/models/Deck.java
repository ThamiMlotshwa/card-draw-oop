package co.advance.carddraw.models;

import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * A model representation of a deck of cards
 * @author Thami Mlotshwa
 */
public class Deck
{
    /**
     * The size of the deck at its initialisation
     */
    private final int originalSize;

    /**
     * Cards in the deck, represented by a queue to emulate a real deck
     */
    private final Deque<Card> cards;

    public Deck(int initialSize, Deque<Card> cards) {
        this.originalSize = initialSize;
        this.cards = cards;
    }

    /**
     * Get the current size of the deck
     * @return The current size of the deck
     */
    public int getCurrentSize() {
        return cards.size();
    }

    /**
     * Get the initial size of the deck.
     * @return The initial size of the deck
     */
    public int getInitialSize(){ return originalSize; }

    /**
     * Get the next card from the deck
     * @return The next card from the deck
     */
    public Optional<Card> getNextCard()
    {
        try
        {
            return Optional.of(cards.pop());
        }
        catch (NoSuchElementException e)
        {
            return Optional.empty();
        }
    }
}
