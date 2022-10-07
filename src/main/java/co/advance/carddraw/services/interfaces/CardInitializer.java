package co.advance.carddraw.services.interfaces;

import co.advance.carddraw.models.Card;

import java.util.Set;

/**
 * A service to initialise a collection of cards
 * @author Thami Mlotshwa
 */
public interface CardInitializer
{
    /**
     * A method to initialise a collection of cards
     * @return A set of cards to be shuffled and allocated to a deck
     */
    Set<Card> initialiseCards();
}
