package co.advance.carddraw.models;

import co.advance.carddraw.enums.ScoreName;

/**
 * A model representation of a score, given to a hand
 * @param name The name of the score
 * @param rank The ranking given to the score
 * @author Thami Mlotshwa
 */
public record HandScore(ScoreName name, int rank)
{
    @Override
    public String toString() {
        return name.toString();
    }
}
