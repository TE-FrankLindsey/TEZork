package Rooms;


import Noun.Rubble;

public class BarAlley extends Room {

    public BarAlley() {

        super(
            // name
            "BarAlley",
            // shortDescription
            "Alley behind the bar.  You don't want to stay here long. Alley exits to the west.",
            // longDescription
            "You're in the alley behind the run down bar.  Seems to be the ideal spot for bar patrons to find relief.\n" +
            "The occasional rat scurrying around convinces you that this is not a place to stay long.  An exit is to the east.\n\n" +
            "On the ground is a dirty pile of rubble, something in the rubble glints in the sunlight."
        );

        addExit ("west", "AtBar");
        addItem (new Rubble());
    }

}
