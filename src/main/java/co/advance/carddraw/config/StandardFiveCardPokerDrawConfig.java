package co.advance.carddraw.config;

import co.advance.carddraw.services.impl.FiveCardPokerHandScorerImpl;
import co.advance.carddraw.services.impl.FullDeckNoWildcardCardInitializerImpl;
import co.advance.carddraw.services.impl.SimpleDealerImpl;
import co.advance.carddraw.services.impl.SimpleDeckShufflerImpl;
import co.advance.carddraw.services.interfaces.CardInitializer;
import co.advance.carddraw.services.interfaces.Dealer;
import co.advance.carddraw.services.interfaces.DeckShuffler;
import co.advance.carddraw.services.interfaces.HandScorer;

/**
 * Configuration for standard five card poker draw and scoring
 * @author Thami Mlotshwa
 */
public class StandardFiveCardPokerDrawConfig
{
    /**
     * Get the card initializer logic for a standard five card poker draw
     * @return A card initializer service instance
     */
    public static CardInitializer cardInitialiser()
    {
        return new FullDeckNoWildcardCardInitializerImpl();
    }

    /**
     * Get the deck shuffler logic for a standard five card poker draw
     * @return A simple deck shuffler service instance
     */
    public static DeckShuffler deckShuffler()
    {
        return new SimpleDeckShufflerImpl();
    }

    /**
     * Get the dealer logic for a standard five card poker draw
     * @return A simple card dealer service instance
     */
    public static Dealer dealer()
    {
        return new SimpleDealerImpl(5);

    }

    /**
     * Get the draw scorer  logic for a standard five card poker scoring
     * @return A simple card dealer service instance
     */
    public static HandScorer drawScorer()
    {
        return new FiveCardPokerHandScorerImpl();
    }
}
