package ParseGroup;

import Verb.Verb;

public class Take extends Verb {

    public Take () {

        super(
                // name
                "take",

                // synonyms
                new String[]{"take", "get", "pickup", "Pick up"},

                // shortDescription
                "shortDescription: action verb take",

                // longDescription
                "longDescription: action verb take");
    }

}
