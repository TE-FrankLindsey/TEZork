package Nouns;


public class BluePill extends Noun {

    public BluePill() {

        super(
                // name
                "pill",
                // modifier
                "blue",
                // shortDescription
                "shortDescription: It's blue",
                // longDescription
                "longDescription It's blue");
    }

    public boolean canEat ()   { return true; }

}
