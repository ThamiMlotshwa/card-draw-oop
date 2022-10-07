package co.advance.carddraw.services;

import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.services.impl.FullDeckNoWildcardCardInitializerImpl;
import co.advance.carddraw.services.interfaces.CardInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the card initializer implementation, for a 52-card deck with no wildcards
 * @author Thami Mlotshwa
 */
class FullDeckNoWildcardCardInitializerImplTest {

    CardInitializer cardInitializer;

    @BeforeEach
    void init()
    {
        this.cardInitializer = new FullDeckNoWildcardCardInitializerImpl();
    }

    @Test
    void initialiseCards()
    {
        Set<Card> cards = cardInitializer.initialiseCards(); // Set so no duplicates
        assertEquals(52, cards.size());
        assertEquals(13, cards.stream().filter(card -> card.suit() == CardSuit.CLUBS).count());
        assertEquals(13, cards.stream().filter(card -> card.suit() == CardSuit.SPADES).count());
        assertEquals(13, cards.stream().filter(card -> card.suit() == CardSuit.HEARTS).count());
        assertEquals(13, cards.stream().filter(card -> card.suit() == CardSuit.DIAMONDS).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.ACE).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.THREE).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.FIVE).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.SEVEN).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.NINE).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.JACK).count());
        assertEquals(4, cards.stream().filter(card -> card.face() == CardFace.KING).count());
    }
}