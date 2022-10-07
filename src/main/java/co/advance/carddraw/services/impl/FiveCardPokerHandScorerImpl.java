package co.advance.carddraw.services.impl;

import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.enums.CardFace;
import co.advance.carddraw.enums.ScoreName;
import co.advance.carddraw.exceptions.ScoringException;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Hand;
import co.advance.carddraw.models.HandScore;
import co.advance.carddraw.services.interfaces.HandScorer;

import java.util.Arrays;

/**
 * An implementation of the service to score a hand of cards, according to the standard five card poker rules
 * @author Rosetta Code Contributors (https://rosettacode.org/w/index.php?title=Poker_hand_analyser&oldid=328144)
 */
public class FiveCardPokerHandScorerImpl implements HandScorer
{
    @Override
    public HandScore getScoreForHand(Hand hand)
    {
        String faces = Arrays.stream(CardFace.values())
                .map(CardFace::getSymbol)
                .reduce("", String::concat);

        String suits = Arrays.stream(CardSuit.values())
                .map(CardSuit::getLetter)
                .reduce("", String::concat);

        int[] faceCount = new int[faces.length()];
        long straight = 0, flush = 0;

        if (hand.cards().size() != 5)
        {
            throw new ScoringException("There need to be five cards for this scoring implementation");

        }
        for (Card card : hand.cards())
        {

            int face = faces.indexOf(card.face().getSymbol());
            if (face == -1)
                throw new ScoringException("Invalid hand: Non-existing symbol/face.");
            straight |= (1 << face);

            faceCount[face]++;

            if (suits.indexOf(card.suit().getLetter()) == -1)
                throw new ScoringException("Invalid hand: Non-existing suit.");

            flush |= (1 << card.suit().getLetter().charAt(0));
        }

        // shift the bit pattern to the right as far as possible
        while (straight % 2 == 0)
            straight >>= 1;

        // straight is 00011111; A-2-3-4-5 is 1111000000001
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;

        // unsets right-most 1-bit, which may be the only one set
        boolean hasFlush = (flush & (flush - 1)) == 0;

        if (hasStraight && hasFlush)
            return new HandScore(ScoreName.STRAIGHT_FLUSH, 9);

        int total = 0;
        for (int count : faceCount) {
            if (count == 4)
                return new HandScore(ScoreName.FOUR_OF_A_KIND, 8);
            if (count == 3)
                total += 3;
            else if (count == 2)
                total += 2;
        }

        if (total == 5)
            return new HandScore(ScoreName.FULL_HOUSE, 7);

        if (hasFlush)
            return new HandScore(ScoreName.FLUSH, 6);

        if (hasStraight)
            return new HandScore(ScoreName.STRAIGHT, 5);

        if (total == 3)
            return new HandScore(ScoreName.THREE_OF_A_KIND, 4);

        if (total == 4)
            return new HandScore(ScoreName.TWO_PAIR, 3);

        if (total == 2)
            return new HandScore(ScoreName.ONE_PAIR, 2);

        return new HandScore(ScoreName.HIGH_CARD, 1);
    }
}
