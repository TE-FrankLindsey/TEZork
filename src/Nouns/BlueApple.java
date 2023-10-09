package Nouns;


public class BlueApple extends Noun {

    public BlueApple() {

        super(
                // name
                "apple",
                // modifier
                "blue",
                // shortDescription
                "shortDescription: It's blue",
                // longDescription
                "longDescription It's blue");
    }

    public boolean canEat ()   { return true; }

}
