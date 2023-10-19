package Nouns;


public class Pill extends Noun {

    public Pill () {

        super(
                // attributes
                EAT | TAKE,
                // name
                "pill",
                // synonyms
                new String[]{"pill"},
                // modifier
                "",
                // shortDescription
                "shortDescription: It's a pill",
                // longDescription
                "longDescription: It's a pill"
        );
    }

}
