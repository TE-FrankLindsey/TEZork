package Noun;


public class BlueApple extends Noun {

    public BlueApple() {

        super(
                // attributes
                EAT | TAKE,
                // name
                "apple",
                // synonyms
                new String[]{"apple"},
                // modifier
                "blue",
                // shortDescription
                "shortDescription: It's blue",
                // longDescription
                "longDescription It's blue"
        );
    }

}
