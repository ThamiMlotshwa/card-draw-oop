package co.advance.carddraw.services.impl;

import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.services.interfaces.CardInitializer;

import java.util.HashSet;
import java.util.Set;

/**
 * An implementation of the service to initialise a collection of cards, specifically for a 52-pack of
 * cards without wildcards (jokers)
 * @author Thami Mlotshwa
 */
public class FullDeckNoWildcardCardInitializerImpl implements CardInitializer
{
    @Override
    public Set<Card> initialiseCards()
    {
        Set<Card> cards = new HashSet<>();
        for (CardSuit suit : CardSuit.values())
            for (CardFace symbol : CardFace.values())
                cards.add(new Card(symbol, suit));
        return cards;
    }
}
