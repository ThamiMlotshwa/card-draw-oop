package co.advance.carddraw.models;

import co.advance.carddraw.enums.CardSuit;
import co.advance.carddraw.enums.CardFace;

/**
 * A model representation of a card
 * @param face The face symbol belonging to this card
 * @param suit THe suit of this card
 * @author Thami Mlotshwa
 */
public record Card(CardFace face, CardSuit suit)
{
    @Override
    public String toString() {
        return face.toString() + suit.toString();
    }
}
