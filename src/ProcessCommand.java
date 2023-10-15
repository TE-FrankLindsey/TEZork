import Nouns.Inventory;
import Nouns.Noun;
import Verb.Verb;
import ParseGroup.Parser;

public class ProcessCommand {

//    public List<Noun> allInventory;
//    public List<Noun> myInventory = new ArrayList<>();
    public Inventory myInventory = new Inventory();
    public Inventory roomInventory = new Inventory();
    public Inventory directionInventory = new Inventory();

//    public List<Noun> roomInventory = new ArrayList<>();
//    public List<Noun> directionInventory = new ArrayList<>();
    private Parser parser;

//    private Inventory xInventory = new Inventory();

    public ProcessCommand () {

        roomInventory.loadNouns();
        directionInventory.loadDirections();
        parser = new Parser ();

        String xx = roomInventory.getList();
        String xxx = roomInventory.getList();
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
            currVerb.runCommand(null, "", myInventory, roomInventory);
            return;
        }

        // Look
        else if (currVerb.getName().equals("look")) {
            currVerb.runCommand(null, "", myInventory, roomInventory);
            return;
        }

    //
    // process verb / noun commands
    //

        if (currVerb.whichInventory() == Verb.inventorySpec.MY)
            parser.parseCommandNoun(myInventory);
        else if (currVerb.whichInventory() == Verb.inventorySpec.ROOM)
            parser.parseCommandNoun(roomInventory);
        else if (! parser.parseCommandNoun(myInventory))
            parser.parseCommandNoun(roomInventory);

        Noun currNoun = parser.getNoun();

        String prepNoun = "";
        if (parser.parsePrepPhrase (myInventory)) {
            prepNoun = parser.getPrepNoun();
        }

        currVerb.runCommand(currNoun, prepNoun, myInventory, roomInventory);


/*
        if (! parser.parseCommandNoun(directionInventory)) {
            System.out.println("go direction...");
        }
        else
            System.out.printf("go direction %s\n", parser.getNoun().getName());
*/
    }

}
