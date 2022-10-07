package co.advance.carddraw.runners;

import co.advance.carddraw.config.StandardFiveCardPokerDrawConfig;
import co.advance.carddraw.models.Card;
import co.advance.carddraw.models.Deck;
import co.advance.carddraw.models.Hand;
import co.advance.carddraw.models.HandScore;
import co.advance.carddraw.services.interfaces.CardInitializer;
import co.advance.carddraw.services.interfaces.Dealer;
import co.advance.carddraw.services.interfaces.DeckShuffler;
import co.advance.carddraw.services.interfaces.HandScorer;

import java.util.Set;

/**
 * An application runner for use in the console
 * @author Thami Mlotshwa
 */
public class ConsoleRunner implements Runnable
{
    @Override
    public void run() {
        CardInitializer cardInitializer = StandardFiveCardPokerDrawConfig.cardInitialiser();
        DeckShuffler deckShuffler = StandardFiveCardPokerDrawConfig.deckShuffler();
        Dealer dealer = StandardFiveCardPokerDrawConfig.dealer();
        HandScorer handScorer = StandardFiveCardPokerDrawConfig.drawScorer();

        Set<Card> cards = cardInitializer.initialiseCards();
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        Deck deck = deckShuffler.shuffleCardsAndInitialiseDeck(cards);

        Hand hand = dealer.dealHand( deck);
        System.out.println("Your hand:" + hand);

        HandScore highestRank = handScorer.getScoreForHand(hand);
        System.out.println("You have: "+ highestRank);
    }
}
