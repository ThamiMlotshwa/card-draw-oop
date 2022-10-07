package co.advance.carddraw.services.interfaces;

import co.advance.carddraw.models.Deck;
import co.advance.carddraw.models.Hand;

/**
 * A service to get a hand of cards from a deck
 * @author Thami Mlotshwa
 */
public interface Dealer
{
    /**
     * Get a hand of cards from a deck
     * @param deck An initialized and shuffled deck
     * @return A hand of cards of the given size. The deck is also reduced in size
     */
    Hand dealHand(Deck deck);
}
