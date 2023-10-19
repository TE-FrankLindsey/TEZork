package Nouns;


import Nouns.Noun;

public class RedApple extends Noun {

    public RedApple() {

        super(
                // attributes
                EAT | TAKE,
                // name
                "apple",
                // synonyms
                new String[]{"apple"},
                // modifier
                "red",
                // shortDescription
                "shortDescription: It's red",
                // longDescription
                "longDescription: It's red"
        );
    }

}
