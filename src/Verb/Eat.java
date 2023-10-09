package Verb;

import Verb.Verb;

public class Eat extends Verb {

    public Eat() {

        super(
                // name
                "eat",

                // synonyms
                new String[]{"eat", "bite", "consume", "ingest", "swallow"}
        );
    }

    public String getCannotMessage ()
        { return "I cannot eat that!"; }

}
