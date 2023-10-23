package Noun;


public class BluePill extends Noun {

    public BluePill() {

        super(
                // attributes
                EAT | TAKE,
                // name
                "pill",
                // synonyms
                new String[]{"pill"},
                // modifier
                "blue",
                // shortDescription
                "shortDescription: It's blue",
                // longDescription
                "longDescription It's blue"
        );
    }

}
