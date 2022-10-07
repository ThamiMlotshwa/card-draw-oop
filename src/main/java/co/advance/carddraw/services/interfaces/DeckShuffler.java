package co.advance.carddraw.services.interfaces;

import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;

import java.util.Set;

/**
 * A service to initialize a shuffled deck
 * @author Thami Mlotshwa
 */
public interface DeckShuffler
{
    /**
     * A method to shuffle a collection of cards and create a usable deck
     * @param cards A collection of cards to be shuffled and put into a deck
     * @return A deck from which cards will be drawn to create hands
     */
    Deck shuffleCardsAndInitialiseDeck(Set<Card> cards);
}
