package co.advance.carddraw.services;

import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.ScoreName;
import co.advance.carddraw.exceptions.ScoringException;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Hand;
import co.advance.carddraw.models.HandScore;
import co.advance.carddraw.services.impl.FiveCardPokerHandScorerImpl;
import co.advance.carddraw.services.interfaces.HandScorer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the hand scorer implementation, according to the standard five card poker rules
 * @author Thami Mlotshwa
 */
class FiveCardHandScorerImplTest
{

    Card CARD_ONE;
    Card CARD_TWO;
    Card CARD_THREE;
    Card CARD_FOUR;
    Card CARD_FIVE;

    HandScorer scoringService;

    @BeforeEach
    void init()
    {
        this.scoringService = new FiveCardPokerHandScorerImpl();
    }

    @Test
    void getHighestRankForHand_Negative_FourCards()
    {
        CARD_ONE = new Card(CardFace.KING, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);

        Hand hand1 = new Hand(4, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR));
        assertThrows(ScoringException.class, () -> scoringService.getScoreForHand(hand1));
    }

    @Test
    void getHighestRankForHand_HighCard()
    {
        CARD_ONE = new Card(CardFace.KING, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);
        CARD_FIVE = new Card(CardFace.THREE, CardSuit.HEARTS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals( ScoreName.HIGH_CARD, ranking1.name());


        CARD_ONE = new Card(CardFace.TEN, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.EIGHT, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.SIX, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.DIAMONDS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.HIGH_CARD, ranking2.name());
    }

    @Test
    void getHighestRankForHand_OnePair()
    {
        CARD_ONE = new Card(CardFace.FOUR, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);
        CARD_FIVE = new Card(CardFace.THREE, CardSuit.HEARTS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals( ScoreName.ONE_PAIR, ranking1.name());


        CARD_ONE = new Card(CardFace.TEN, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.TEN, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.SIX, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.DIAMONDS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.ONE_PAIR, ranking2.name());
    }

    @Test
    void getHighestRankForHand_TwoPair()
    {
        CARD_ONE = new Card(CardFace.QUEEN, CardSuit.HEARTS);
        CARD_TWO = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);
        CARD_FIVE = new Card(CardFace.SEVEN, CardSuit.HEARTS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals( ScoreName.TWO_PAIR, ranking1.name());


        CARD_ONE = new Card(CardFace.TEN, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.TEN, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.SEVEN, CardSuit.DIAMONDS);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.CLUBS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.TWO_PAIR, ranking2.name());
    }

    @Test
    void getHighestRankForHand_ThreeOfAKind()
    {
        CARD_ONE = new Card(CardFace.KING, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.KING, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.KING, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);
        CARD_FIVE = new Card(CardFace.THREE, CardSuit.HEARTS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.THREE_OF_A_KIND, ranking1.name());


        CARD_ONE = new Card(CardFace.TEN, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.TEN, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.SEVEN, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.TEN, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.DIAMONDS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.THREE_OF_A_KIND, ranking2.name());
    }

    @Test
    void getHighestRankForHand_Straight()
    {
        CARD_ONE = new Card(CardFace.JACK, CardSuit.SPADES);
        CARD_TWO = new Card(CardFace.KING, CardSuit.HEARTS);
        CARD_THREE = new Card(CardFace.NINE, CardSuit.HEARTS);
        CARD_FOUR = new Card(CardFace.QUEEN, CardSuit.CLUBS);
        CARD_FIVE = new Card(CardFace.TEN, CardSuit.DIAMONDS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.STRAIGHT, ranking1.name());


        CARD_ONE = new Card(CardFace.FIVE, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.THREE, CardSuit.CLUBS);
        CARD_THREE = new Card(CardFace.SIX, CardSuit.DIAMONDS);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.DIAMONDS);
        CARD_FIVE = new Card(CardFace.SEVEN, CardSuit.CLUBS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.STRAIGHT, ranking2.name());
    }

    @Test
    void getHighestRankForHand_Flush()
    {
        CARD_ONE = new Card(CardFace.NINE, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.SEVEN, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.FIVE, CardSuit.DIAMONDS);
        CARD_FOUR = new Card(CardFace.ACE, CardSuit.DIAMONDS);
        CARD_FIVE = new Card(CardFace.TWO, CardSuit.DIAMONDS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.FLUSH, ranking1.name());


        CARD_ONE = new Card(CardFace.FIVE, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.KING, CardSuit.CLUBS);
        CARD_THREE = new Card(CardFace.SIX, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.THREE, CardSuit.CLUBS);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.CLUBS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.FLUSH, ranking2.name());
    }

    @Test
    void getHighestRankForHand_FullHouse()
    {
        CARD_ONE = new Card(CardFace.KING, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.KING, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.KING, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.FOUR, CardSuit.SPADES);
        CARD_FIVE = new Card(CardFace.FOUR, CardSuit.HEARTS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.FULL_HOUSE, ranking1.name());


        CARD_ONE = new Card(CardFace.TEN, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.TEN, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.ACE, CardSuit.SPADES);
        CARD_FOUR = new Card(CardFace.TEN, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.ACE, CardSuit.DIAMONDS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.FULL_HOUSE, ranking2.name());
    }

    @Test
    void getHighestRankForHand_FourOfAKind()
    {
        CARD_ONE = new Card(CardFace.ACE, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.ACE, CardSuit.SPADES);
        CARD_THREE = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_FOUR = new Card(CardFace.ACE, CardSuit.HEARTS);
        CARD_FIVE = new Card(CardFace.ACE, CardSuit.CLUBS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.FOUR_OF_A_KIND, ranking1.name());


        CARD_ONE = new Card(CardFace.FIVE, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.TWO, CardSuit.CLUBS);
        CARD_THREE = new Card(CardFace.TWO, CardSuit.HEARTS);
        CARD_FOUR = new Card(CardFace.TWO, CardSuit.DIAMONDS);
        CARD_FIVE = new Card(CardFace.TWO, CardSuit.SPADES);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.FOUR_OF_A_KIND, ranking2.name());
    }

    @Test
    void getHighestRankForHand_StraightFlush()
    {
        CARD_ONE = new Card(CardFace.ACE, CardSuit.DIAMONDS);
        CARD_TWO = new Card(CardFace.KING, CardSuit.DIAMONDS);
        CARD_THREE = new Card(CardFace.QUEEN, CardSuit.DIAMONDS);
        CARD_FOUR = new Card(CardFace.JACK, CardSuit.DIAMONDS);
        CARD_FIVE = new Card(CardFace.TEN, CardSuit.DIAMONDS);

        Hand hand1 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking1 = scoringService.getScoreForHand(hand1);

        assertNotNull(ranking1);
        assertEquals(ScoreName.STRAIGHT_FLUSH, ranking1.name());


        CARD_ONE = new Card(CardFace.FIVE, CardSuit.CLUBS);
        CARD_TWO = new Card(CardFace.THREE, CardSuit.CLUBS);
        CARD_THREE = new Card(CardFace.FOUR, CardSuit.CLUBS);
        CARD_FOUR = new Card(CardFace.TWO, CardSuit.CLUBS);
        CARD_FIVE = new Card(CardFace.SIX, CardSuit.CLUBS);

        Hand hand2 = new Hand(5, Set.of(CARD_ONE, CARD_TWO, CARD_THREE, CARD_FOUR, CARD_FIVE));
        HandScore ranking2 = scoringService.getScoreForHand(hand2);

        assertNotNull(ranking2);
        assertEquals(ScoreName.STRAIGHT_FLUSH, ranking2.name());
    }
}