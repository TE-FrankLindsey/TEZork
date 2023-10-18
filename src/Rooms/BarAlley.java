package Rooms;


import Nouns.Noun;
import Nouns.Rubble;

public class BarAlley extends Room {

    public BarAlley() {

        super(
            // name
            "BarAlley",
            // shortDescription
            "Alley behind the bar.  You don't want to stay here long",
            // longDescription
            "\n\nYou're in the alley behind the run down bar.  Seems to be the ideal spot for bar patrons to find relief.\n" +
            "The occasional rat scurrying around convinces you that this is not a place to stay long.\n\n" +
            "On the ground is a dirty pile of rubble, something in the rubble glints in the sunlight."
        );

        addExit ("west", "AtBar");
        addItem (new Rubble());
    }

}
