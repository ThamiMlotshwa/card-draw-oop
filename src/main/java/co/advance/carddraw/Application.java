package co.advance.carddraw;

import co.advance.carddraw.runners.ConsoleRunner;

/**
 * The access point for the card draw application
 * @author Thami Mlotshwa
 */
public class Application
{
    public static void main(String... args)
    {
        new ConsoleRunner().run(); // Introduce a separate runner in the case or a web application (omitted)
    }
}
