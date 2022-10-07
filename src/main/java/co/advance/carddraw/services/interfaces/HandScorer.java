package co.advance.carddraw.services.interfaces;

import co.advance.carddraw.models.Hand;
import co.advance.carddraw.models.HandScore;

/**
 * A service to score a hand of cards
 * @author Thami Mlotshwa
 */
public interface HandScorer
{
    /**
     * A method to get the score associated with a hand of cards
     * @param hand A hand of cards drawn from a deck
     * @return The score associated with the hand
     */
    HandScore getScoreForHand(Hand hand);
}
