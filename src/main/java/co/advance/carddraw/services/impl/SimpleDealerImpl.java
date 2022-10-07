package co.advance.carddraw.services.impl;

import co.advance.carddraw.exceptions.DealingHandException;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;
import co.advance.carddraw.models.Hand;
import co.advance.carddraw.services.interfaces.Dealer;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple implementation of the service to get a hand of cards from a deck
 * @author Thami Mlotshwa
 */
public class SimpleDealerImpl implements Dealer
{
    private final int handSize;

    public SimpleDealerImpl(int handSize)
    {
        this.handSize = handSize;
    }

    @Override
    public Hand dealHand(Deck deck) {
        if (handSize == 0)
        {
            throw new DealingHandException("A hand must contain at least one card.");
        }

        if (handSize > deck.getCurrentSize())
        {
            throw new DealingHandException("You cannot draw more cards than are present in the deck.");
        }

        Set<Card> handOfCards = new HashSet<>();

        for (int i = 0; i < handSize; i++)
        {
            handOfCards.add(deck.getNextCard().orElseThrow(
                    () -> new DealingHandException("The deck ran out of cards unexpectedly.")));
        }

        return new Hand(handOfCards.size(), handOfCards);
    }
}
