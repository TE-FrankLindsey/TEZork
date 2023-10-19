package Rooms;


import Nouns.Noun;

public class AtBar extends Room {

    public AtBar() {

        super(
            // name
            "AtBar",
            // shortDescription
            "You're standing in front of a rather seedy bar.  Buildings north and south, alley to the east.",
            // longDescription
            "You approach a run down bar, load noises are coming from inside.\n" +
            "A customer stumbles out the door, staggers a few feet then drops face first onto the sidewalk.\n\n" +
            "Hmmm ... must be Autumn, the buckeyes are starting to fall.\n\n" +
            "There is a store to the north, a building to the south and an alley that runs behind the bar to the east."
        );

        addExit ("south", "AtAlly");
        addExit ("north", "AtQuikiMart");
        addExit ("east", "BarAlley");
    }

}
