package Verb;

import Noun.Noun;
import Noun.NounInventory;
import ParseGroup.DAO;
import Rooms.Room;

public class Scan extends Verb {

    public Scan() {

        super(
            // name
            "scan",

            // synonyms
            new String[]{"scan"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.MY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

            if (noun == null)
                System.out.println("What do you want me to scan?");
            else if (! noun.canScan())
                System.out.printf("You cannot scan the %s!", noun.getDisplayName());
            else
                noun.scan();


        /*
        Room roomWithLockedDoor = DAO.containingRoom;
String xxxxx = roomWithLockedDoor.getClass().getName();
        if (roomWithLockedDoor==null || !roomWithLockedDoor.isClass("Rooms.AtAlly")) {
            System.out.println("No scannner here.");
        }

        else if (noun == null)
            System.out.println("What do you want me to scan?");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to scan?\n", noun.getName());
        else if (! noun.canScan()) {
            System.out.printf("You cannot scan the %s!", noun.getDisplayName());
        }
        else {
//            System.out.printf("You opened the %s.\n", noun.getDisplayName());
            noun.open (prepNoun, DAO.myInventory);
//            myInventory.addItem(noun);
//            roomInventory.removeItem(noun);
        }

         */
    }

}
