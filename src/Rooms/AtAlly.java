package Rooms;


import Noun.*;
import ParseGroup.DAO;

public class AtAlly extends Room {


    AllyDoor lockedDoor = null;

    public AtAlly() {

        super(
                // name
                "AtAlly",
                // shortDescription
                "You're standing in front of the Ally building.  Buildings are to the North and a door is to the west.",
                // longDescription
                "You're standing in front of a building at the end of a street.  " +
                "On the building is a sign which reads:\n" +
                "   \"Grow Here.\"\n" +
                "   \"Thrive Here.\"\n" +
                "   \"Connect Here.\"\n" +
                "      \"Ally\"\n\n" + "To the north you see some small buildings along the street.\n" +
                "Immediately west is a door.  Beside the door is a card scanner."
        );

        addExit ("west", "AllyLobby");
        addExit ("north", "AtBar");

//        DAO.scannerRoom = this;
//        DAO.lockedDoor = new AllyDoor();
        lockedDoor = new AllyDoor();
        addItem (lockedDoor);
        addItem (new CardScanner());

    }


    public void setLocked(boolean locked)
        {
            lockedDoor.open(); }




    public String goDirection(String direction) {
        if (direction.isBlank())
            return null;

        if (direction.equals("west") && lockedDoor.isLocked()) {
            System.out.println("Door is locked.");
            return null;
        }
        String gotoRoom = directions.get(direction);
        return gotoRoom;
    }



}
