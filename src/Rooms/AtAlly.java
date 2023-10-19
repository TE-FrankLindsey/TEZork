package Rooms;


import Nouns.*;

public class AtAlly extends Room {

    public AtAlly() {

        super(
                // name
                "AtAlly",
                // shortDescription
                "You're standing in front of the Ally building.  Buildings are to the North and a door is to the west.",
                // longDescription
                "\n\nYou're standing in front of a building at the end of a street.  " +
                "On the building is a sign which reads:\n" +
                "   \"Grow Here.\"\n" +
                "   \"Thrive Here.\"\n" +
                "   \"Connect Here.\"\n" +
                "      \"Ally\"\n\n" + "To the north you see some small buildings along the street.\n" +
                "Immediately west is a door.  Beside the door is a card scanner."
        );

        addExit ("west", "AllyLobby");
        addExit ("north", "AtBar");

        addItem (new AllyDoor());
        addItem (new CardScanner());
    }

}
