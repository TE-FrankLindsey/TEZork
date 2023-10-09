package Nouns;


public class BlueApple extends Noun {

    public BlueApple() {

        super(
                // attributes
                EAT | TAKE | EXAMINE,
                // name
                "apple",
                // modifier
                "blue",
                // shortDescription
                "shortDescription: It's blue",
                // longDescription
                "longDescription It's blue"
        );
    }

}
