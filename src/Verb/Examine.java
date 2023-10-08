package Verb;

import Verb.Verb;

public class Examine extends Verb {

    public Examine() {

        super(
                // name
                "examine",

                // synonyms
                new String[]{"examine", "look at", "feel", "poke", "touch"},

                // shortDescription
                "shortDescription: action verb examine",

                // longDescription
                "longDescription: action verb examine");
    }

}
