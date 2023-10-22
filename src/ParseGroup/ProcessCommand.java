package ParseGroup;

import Nouns.*;
import Rooms.Room;
import Rooms.RoomMap;
import Verb.Verb;



public class ProcessCommand {

    public NounInventory myInventory = new NounInventory();
    private Parser parser;

    RoomMap roomMap = new RoomMap();


    public ProcessCommand () {
        parser = new Parser ();

        System.out.println("\n\n");
        DAO.setCurrRoom(roomMap.getRoom("AtAlly"));
        System.out.println(DAO.getRoomDescription());
        System.out.println("You see around you: " + DAO.getRoomInventory().getList());

// !!! FIXME - remove
myInventory.addItem(new Condom());
myInventory.addItem(new IDCard());
    }

    //
    // Parse out the VERB and NOUN from the command and act on those
    //
    public void runCommand (String Command) {
        // clean up the input some
        parser.preParseText(Command);

    //
    // try to find verb in user submitted command
    //
        if (!parser.parseCommandVerb() || parser.getVerb()==null) {
            System.out.println("I have no idea what you are asking of me.\n");
            return;
        }
        Verb currVerb = parser.getVerb();

    //
    // process all 'verb only' commands
    //

        // Inventory
        if (currVerb.getName().equals("inventory")) {
            currVerb.runCommand(null, null, myInventory, DAO.getRoomInventory());
            return;
        }

        // Look
        else if (currVerb.getName().equals("look")) {
            System.out.println(DAO.getRoomDescription());
            currVerb.runCommand(null, null, myInventory, DAO.getRoomInventory());
            return;
        }

    //
    // process verb / noun commands
    //

        if (currVerb.whichInventory() == Verb.inventorySpec.MY)
            parser.parseCommandNoun(myInventory);
        else if (currVerb.whichInventory() == Verb.inventorySpec.ROOM)
            parser.parseCommandNoun(DAO.getRoomInventory());

    //
    // handle movement north, south, west, east
    //
        else if (currVerb.whichInventory() == Verb.inventorySpec.DIRECTION) {
            // resolve direction to room title
            String requestedDirection = parser.parseDirection(DAO.getRoomDirections());
            String movementDirection = DAO.goRoomDirection(requestedDirection);

            if (movementDirection == null) {
                System.out.println("You cannot go that direction.");
                return;
            }

            if (roomMap.getRoom(movementDirection).isLocked()) {
                System.out.println("You can't go that way.  The door is locked.");
                return;
            }

            // resolve room title to room, make current room and display room information
            DAO.setCurrRoom(roomMap.getRoom(movementDirection));
            System.out.println(DAO.getRoomDescription());
            System.out.println("You see around you: " + DAO.getRoomInventory().getList());
            return;
        }

        // for inventory of ANY specified, try applying verb to MyInventory then RoomInventory
        else if (! parser.parseCommandNoun(myInventory))
            parser.parseCommandNoun(DAO.getRoomInventory());
        Noun currNoun = parser.getNoun();

    //
    // parse for the prepositional phrase
    //
//        String prepNoun = "";
//        if (parser.parsePrepPhrase (myInventory))
//            prepNoun = parser.getPrepNoun();

        Noun prepNoun = parser.parsePrepPhrase (myInventory);
        if (prepNoun==null || prepNoun.isUnknown())
            prepNoun = parser.parsePrepPhrase (DAO.getRoomInventory());
        if (prepNoun==null || prepNoun.isUnknown())
            prepNoun = parser.parsePrepPhrase (DAO.getRoomOtherInventory());

        // run command with the noun and prepositional noun
        currVerb.runCommand(currNoun, prepNoun, myInventory, DAO.getRoomInventory());
    }

}
