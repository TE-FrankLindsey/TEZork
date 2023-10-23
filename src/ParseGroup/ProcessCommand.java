package ParseGroup;

import Noun.*;
import Rooms.RoomMap;
import Verb.Verb;



public class ProcessCommand {

//    public NounInventory myInventory = new NounInventory();
    private Parser parser;

    RoomMap roomMap = new RoomMap();


    public ProcessCommand () {
        parser = new Parser ();

        System.out.println("\n\n");
        DAO.setCurrRoom(roomMap.getRoom("AtAlly"));
        System.out.println(DAO.getRoomDescription());
        System.out.println("You see around you: " + DAO.getRoomInventory().getList());

// !!! FIXME - remove
DAO.myInventoryAdd(new Condom());
DAO.myInventoryAdd(new IDCard());
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
String someString = parser.remainingText();

        if (!parser.parseCommandVerb() || parser.getVerb()==null) {
            System.out.printf("I have no idea what you are asking of me.\n");
            return;
        }
        Verb currVerb = parser.getVerb();

    //
    // process all 'verb only' commands
    //

someString = parser.remainingText();
        // Inventory
        if (currVerb.isClass("Verb.VerbInventory")) {
            currVerb.runCommand(null, null, DAO.getRoomInventory());
            return;
        }

        // Look
someString = parser.remainingText();
        if (currVerb.isClass("Verb.Look")) {
            System.out.println(DAO.getRoomDescription());
            currVerb.runCommand(null, null, DAO.getRoomInventory());
            DAO.showGiveADamns();
            return;
        }

    //
    // process verb / noun commands
    //
//
//        if (currVerb.whichInventory() == Verb.inventorySpec.MY)
//            parser.parseCommandNoun(DAO.getMyInventory());
//        else if (currVerb.whichInventory() == Verb.inventorySpec.ROOM)
//            parser.parseCommandNoun(DAO.getRoomInventory());

    //
    // handle movement north, south, west, east
    //
someString = parser.remainingText();
        if (currVerb.whichInventory() == Verb.inventorySpec.DIRECTION) {
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

someString = parser.remainingText();
        if (currVerb.whichInventory() == Verb.inventorySpec.MY)
            parser.parseCommandNoun(DAO.getMyInventory());
        else if (currVerb.whichInventory() == Verb.inventorySpec.ROOM)
            parser.parseCommandNoun(DAO.getRoomInventory());

        // for inventory of ANY specified, try applying verb to MyInventory then RoomInventory

        else  if (!parser.parseCommandNoun(DAO.getMyInventory()))
                parser.parseCommandNoun(DAO.getRoomInventory());

        Noun currNoun = parser.getNoun();

        //
        // parse for the prepositional phrase
        //
        Noun prepNoun = parser.parsePrepPhrase (DAO.getMyInventory());
        if (prepNoun==null || prepNoun.isUnknown()) {
            prepNoun = parser.parsePrepPhrase (DAO.getRoomInventory());
        }

        // run command with the noun and prepositional noun
        currVerb.runCommand(currNoun, prepNoun, DAO.getRoomInventory());
    }

}
