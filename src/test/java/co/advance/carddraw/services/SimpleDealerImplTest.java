package co.advance.carddraw.services;

import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.exceptions.DealingHandException;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;
import co.advance.carddraw.models.Hand;
import co.advance.carddraw.services.impl.SimpleDealerImpl;
import co.advance.carddraw.services.interfaces.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the simple dealer implementation
 * @author Thami Mlotshwa
 */
class SimpleDealerImplTest {

    Card CARD_ONE;
    Card CARD_TWO;
    Card CARD_THREE;
    Card CARD_FOUR;
    Card CARD_FIVE;
    Card CARD_SIX;
    Dealer dealer;

    @BeforeEach
    void init()
    {
        CARD_ONE = new Card(CardFace.ACE, CardSuit.SPADES);
        CARD_TWO = new Card(CardFace.FOUR, CardSuit.HEARTS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.NINE, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.JACK, CardSuit.DIAMONDS);
        CARD_SIX = new Card(CardFace.QUEEN, CardSuit.SPADES);

    }

    @Test
    void dealHand()
    {
        this.dealer = new SimpleDealerImpl(7);
        Set<Card> testCards = Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE, CARD_SIX);
        Deck testDeck1 = new Deck(6, new ArrayDeque<>(testCards));
        assertThrows(DealingHandException.class, () -> dealer.dealHand(testDeck1));

        this.dealer = new SimpleDealerImpl(3);
        Hand hand1 = dealer.dealHand(testDeck1);
        assertEquals(hand1.cards().size(), 3);
        assertEquals(hand1.size(), 3);
        assertEquals(testDeck1.getCurrentSize(), 3);
        Set<Card> cardsInDeck = new HashSet<>();
        for (int i = 0; i < 3; i++);
        cardsInDeck.add(testDeck1.getNextCard().get());
        assertNotEquals(hand1.cards(), cardsInDeck);

        this.dealer = new SimpleDealerImpl(6);
        Deck testDeck2 = new Deck(6, new ArrayDeque<>(testCards));
        Hand hand2 = dealer.dealHand(testDeck2);
        assertEquals(hand2.cards().size(), 6);
        assertEquals(hand2.size(), 6);
        assertEquals(testDeck2.getCurrentSize(), 0);
        assertEquals(hand2.cards(), testCards);
    }
}