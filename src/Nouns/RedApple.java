package Nouns;


import Nouns.Noun;

public class RedApple extends Noun {

    public RedApple() {

        super(
                // name
                "apple",
                // modifier
                "red",
                // shortDescription
                "shortDescription: It's red",
                // longDescription
                "longDescription: It's red");
    }

    public boolean canEat ()   { return true; }
}
