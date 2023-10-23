package Noun;


import ParseGroup.DAO;
import Rooms.Room;

public class IDCard extends Noun {

    public IDCard() {

        super(
            // attributes
            TAKE | SCAN,
            // name
            "Card",
            // synonyms
            new String[]{"card", "key"},
            // modifier
            "ID",
            // shortDescription
            "shortDescription: It's an ID card",
            // longDescription
            "longDescription It's an ID card"
        );
    }

    public void examine() {
        System.out.println("Looks like this could be used to open a door!");
    }

    public boolean scan() {

//        Room currRoom = DAO.getCurrRoom();
//        Room scannerRoom = DAO.scannerRoom;
        String xxxxx = DAO.getCurrRoom().getClass().getName();
        if (! DAO.getCurrRoom().isClass("Rooms.AtAlly")) {
            System.out.println("No scannner here.");
        }
        else {
            DAO.getCurrRoom().setLocked(false);
            System.out.println("Door is unlocked!");
            DAO.addGiveADamns(10, "Unlocked door");


        }


//        Room atLockedDoor = DAO.scannerRoom;
//        if (roomWithLockedDoor == null || !roomWithLockedDoor.isClass("Rooms.AtAlly")) {
//            System.out.println("No scannner here.");
//        }
//
//
//String xxxxx = roomWithLockedDoor.getClass().getName();

        return true;
    }


}
