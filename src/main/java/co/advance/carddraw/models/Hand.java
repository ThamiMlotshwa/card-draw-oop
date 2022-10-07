package co.advance.carddraw.models;

import java.util.Set;

/**
 * A model representation of a hand of cards, drawn from the deck
 * @param size The number of cars in the hand
 * @param cards Collection of cards in the hand implemented as unordered set, preventing duplicates
 * @author Thami Mlotshwa
 */
public record Hand(int size, Set<Card> cards)
{
    @Override
    public String toString() {
        return cards().stream().map(Card::toString).reduce("", (s1, s2) -> s1 + " " + s2);
    }
}
