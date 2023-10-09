package Nouns;


import Nouns.Noun;

public class IDCard extends Noun {

    public IDCard() {

        super(
                // attributes
                TAKE | EXAMINE,
                // name
                "card",
                // modifier
                "id",
                // shortDescription
                "shortDescription: It's an ID card",
                // longDescription
                "longDescription It's an ID card"
        );
    }

}
