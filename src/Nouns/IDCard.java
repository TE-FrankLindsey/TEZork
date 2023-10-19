package Nouns;


import Nouns.Noun;

public class IDCard extends Noun {

    public IDCard() {

        super(
                // attributes
                TAKE | SCAN,
                // name
                "card",
                // synonyms
                new String[]{"card", "key"},
                // modifier
                "id",
                // shortDescription
                "shortDescription: It's an ID card",
                // longDescription
                "longDescription It's an ID card"
        );
    }

    public void examine() {
        System.out.println("Looks like this could be used to open a door!");
    }

}
