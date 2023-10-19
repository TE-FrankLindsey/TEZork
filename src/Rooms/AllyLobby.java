package Rooms;


import Nouns.Water;
import Nouns.WaterFountain;

public class AllyLobby extends Room {

    public AllyLobby() {

        super(
                // name
                "AllyLobby",
                // shortDescription
                "You're inside the lobby of the Ally building",
                // longDescription
                "You're standing in the lobby of the Ally building.\n" +
                "There are two elevators here, one is stuck between floors," +
                "the other is blocked by a trash can, currently on fire."
        );

        addExit ("east", "AtAlly");

        addItem (new WaterFountain());
        addItem (new Water());
    }

}
