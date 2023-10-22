package Rooms;


import Nouns.Water;
import Nouns.WaterFountain;

public class AllyLobby extends Room {

    public AllyLobby() {

        super(
                // name
                "AllyLobby",
                // shortDescription
                "Lobby of the Ally building.  Stairwell is blocked by a burning trashcan.  An exit to the east",
                // longDescription
                "You're standing in the lobby of the Ally building.\n" +
                "There is an exit to the east.  An elevator is here, stuck between floors.\n" +
                "And a stairwell, currently blocked by a trashcan, currently on fire."
        );

//        locked = true;

        addExit ("east", "AtAlly");
        addOtherItem(new Water());
        addItem (new WaterFountain());
        addItem (new Water());
    }

}
