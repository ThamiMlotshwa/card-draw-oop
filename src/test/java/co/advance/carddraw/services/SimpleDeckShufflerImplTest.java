package co.advance.carddraw.services;

import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;
import co.advance.carddraw.services.impl.SimpleDeckShufflerImpl;
import co.advance.carddraw.services.interfaces.DeckShuffler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the simple shuffler implementation
 * @author Thami Mlotshwa
 */
class SimpleDeckShufflerImplTest
{
    Card CARD_ONE;
    Card CARD_TWO;
    Card CARD_THREE;
    Card CARD_FOUR;
    Card CARD_FIVE;
    Card CARD_SIX;
    DeckShuffler deckShuffler;

    @BeforeEach
    void init()
    {
        this.deckShuffler = new SimpleDeckShufflerImpl();
        CARD_ONE = new Card(CardFace.ACE, CardSuit.SPADES);
        CARD_TWO = new Card(CardFace.FOUR, CardSuit.HEARTS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.NINE, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.JACK, CardSuit.DIAMONDS);
        CARD_SIX = new Card(CardFace.QUEEN, CardSuit.SPADES);

    }

    @Test
    void shuffleCardsAndInitialiseDeck()
    {
        Set<Card> testCards = Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE, CARD_SIX); // unordered
        Deck deck = deckShuffler.shuffleCardsAndInitialiseDeck(testCards);
        assertNotNull(deck);
        assertEquals(6, deck.getInitialSize());
        assertEquals(6, deck.getCurrentSize());

        Set<Card> poppedCards = new HashSet<>();
        for (int i = 0; i < deck.getInitialSize(); i++)
            poppedCards.add(deck.getNextCard().orElseThrow());

        assertEquals(6, poppedCards.size());
        assertEquals(0, deck.getCurrentSize());
    }
}