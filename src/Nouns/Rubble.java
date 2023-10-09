package Nouns;


import Nouns.Noun;

public class Rubble extends Noun {

    public Rubble() {

        super(
                // name
                "rubble",
                // modifier
                "pile",
                // shortDescription
                "shortDescription: It's a nasty pile of rubble",
                // longDescription
                "longDescription It's a nasty pile of rubble");
    }

    public boolean canExamine ()   { return true; }

}
