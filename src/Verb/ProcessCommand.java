package Verb;

import Nouns.NounInventory;
import Nouns.Noun;
import Rooms.Room;
import Rooms.RoomMap;
import Verb.Verb;
import ParseGroup.Parser;

public class ProcessCommand {

    public NounInventory myInventory = new NounInventory();
//    public NounInventory roomInventory = new NounInventory();
    public NounInventory directionInventory = new NounInventory();
    private Parser parser;

    RoomMap roomMap = new RoomMap();

    private Room currRoom = null;

    public ProcessCommand () {

        parser = new Parser ();

        currRoom = roomMap.getRoom("AtAlly");
        System.out.println(currRoom.getDescription());
        System.out.println("You see around you: " + currRoom.getInventory().getList());
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
            currVerb.runCommand(null, "", myInventory, currRoom.getInventory());
            return;
        }

        // Look
        else if (currVerb.getName().equals("look")) {
            System.out.println(currRoom.getDescription());
            currVerb.runCommand(null, "", myInventory, currRoom.getInventory());
            return;
        }

    //
    // process verb / noun commands
    //

        if (currVerb.whichInventory() == Verb.inventorySpec.MY)
            parser.parseCommandNoun(myInventory);
        else if (currVerb.whichInventory() == Verb.inventorySpec.ROOM)
            parser.parseCommandNoun(currRoom.getInventory());

    //
    // handle movement north, south, west, east
    //
        else if (currVerb.whichInventory() == Verb.inventorySpec.DIRECTION) {
            // resolve direction to room title
            String requestedDirection = parser.parseDirection(currRoom.getDirections());
            String movementDirection = currRoom.goDirection(requestedDirection);

            if (movementDirection == null) {
                System.out.println("You cannot go that direction.");
                return;
            }
            else {
                // resolve room title to room, make current room and display room information
                currRoom = roomMap.getRoom(movementDirection);
                System.out.println(currRoom.getDescription());
                System.out.println("You see around you: " + currRoom.getInventory().getList());
                return;
            }
        }

        // for inventory of ANY specified, try applying verb to MyInventory then RoomInventory
        else if (! parser.parseCommandNoun(myInventory))
            parser.parseCommandNoun(currRoom.getInventory());
        Noun currNoun = parser.getNoun();

    //
    // parse for the prepositional phrase
    //
        String prepNoun = "";
        if (parser.parsePrepPhrase (myInventory))
            prepNoun = parser.getPrepNoun();

        // run command with the noun and prepositional noun
        currVerb.runCommand(currNoun, prepNoun, myInventory, currRoom.getInventory());


/*
        if (! parser.parseCommandNoun(directionInventory)) {
            System.out.println("go direction...");
        }
        else
            System.out.printf("go direction %s\n", parser.getNoun().getName());
*/
    }

}
