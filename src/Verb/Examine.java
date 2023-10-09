package Verb;

import Verb.Verb;

public class Examine extends Verb {

    public Examine() {

        super(
            // name
            "examine",

            // synonyms
            new String[]{"examine", "look at", "feel", "poke", "touch"}
        );
    }

    public String getCannotMessage ()
        { return "I'm not holding that!"; }

}
