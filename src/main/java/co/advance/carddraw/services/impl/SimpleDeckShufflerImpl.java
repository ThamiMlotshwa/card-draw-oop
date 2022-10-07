package co.advance.carddraw.services.impl;

import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;
import co.advance.carddraw.services.interfaces.DeckShuffler;

import java.util.*;

/**
 * A simple implementation of a service to initialize a shuffled deck
 * @author Thami Mlotshwa
 */
public class SimpleDeckShufflerImpl implements DeckShuffler
{
    @Override
    public Deck shuffleCardsAndInitialiseDeck(Set<Card> cards)
    {
        List<Card> cardsToShuffle = new ArrayList<>(cards);
        Collections.shuffle(cardsToShuffle);
        Deque<Card> cardQueue = new ArrayDeque<>(cardsToShuffle);
        return new Deck(cards.size(), cardQueue);
    }
}
