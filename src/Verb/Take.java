package Verb;

import Verb.Verb;

public class Take extends Verb {

    public Take () {

        super(
            // name
            "take",

            // synonyms
            new String[]{"take", "grab", "get", "hold", "pickup", "pick up", "purchase"}
        );
    }

    public String getCannotMessage ()
        { return "I cannot take that!"; }
}
