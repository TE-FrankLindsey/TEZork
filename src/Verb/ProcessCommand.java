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

        directionInventory.loadDirections();
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
            System.out.println("I don't understand that command.\n");
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

else if (currVerb.whichInventory() == Verb.inventorySpec.DIRECTION) {
            String direction = parser.parseDirection(currRoom.getDirections());

String xx = currRoom.goDirection(direction);
if (xx == null) {
    System.out.println("You cannot go that direction.");
    return;
}

else {
Room tmpRoom = roomMap.getRoom(xx);
currRoom = tmpRoom;
System.out.printf(">>>>%s  --  %s\n", direction, xx);
boolean stop = true;

System.out.println(currRoom.getDescription());
System.out.println("You see around you: " + currRoom.getInventory().getList());

            return;
        }
        }

        else if (! parser.parseCommandNoun(myInventory))
            parser.parseCommandNoun(currRoom.getInventory());

        Noun currNoun = parser.getNoun();

        String prepNoun = "";
        if (parser.parsePrepPhrase (myInventory)) {
            prepNoun = parser.getPrepNoun();
        }

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
