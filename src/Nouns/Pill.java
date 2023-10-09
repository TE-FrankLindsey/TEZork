package Nouns;


public class Pill extends Noun {

    public Pill () {

        super(
                // name
                "pill",
                // modifier
                "",
                // shortDescription
                "shortDescription: It's a pill",
                // longDescription
                "longDescription: It's a pill");
    }

    public boolean canEat ()   { return true; }

}
