import Nouns.Noun;
import Verb.Verb;
import ParseGroup.LoadNouns;
import ParseGroup.Parser;

import java.util.ArrayList;
import java.util.List;

public class ProcessCommand {

    public List<Noun> allInventory;
    public List<Noun> myInventory = new ArrayList<>();
    public List<Noun> roomInventory = new ArrayList<>();
    private Parser parser;

    public ProcessCommand () {

        allInventory = LoadNouns.load();
        roomInventory.addAll(allInventory);
        parser = new Parser ();
    }

    public void runCommand (String Command) {

        parser.preParseText(Command);

        // try to find verb in user submitted command
        if (! parser.parseCommandVerb ()) {
            System.out.println("I don't understand what you mean.");
            return;
        }
        Verb currVerb = parser.getVerb();

        // process single verb commands
        if (currVerb == null) {
            System.out.println("I did not understand that command.");
            return;
        }

        // Inventory
        else if (currVerb.getName().equals("inventory")) {

            String stuff = "You are carrying: ";
            if (myInventory==null || myInventory.size()==0)
                stuff += "nothing";
            else
                for (int i = 0; i != myInventory.size(); i++) {
                    if (i > 0)
                        stuff += ", ";
                    stuff += myInventory.get(i).getDisplayName();
                }
            System.out.println(stuff);
            return;
        }

        // Look
        else if (currVerb.getName().equals("look")) {

            String stuff = "The room contains: ";
            if (roomInventory == null || roomInventory.size() == 0)
                stuff += "nothing";
            else
                for (int i = 0; i != roomInventory.size(); i++) {
                    if (i > 0)
                        stuff += ", ";
                    stuff += roomInventory.get(i).getDisplayName();
                }
            System.out.println(stuff);
            return;
        }

        // process verb / noun commands
        
        String Action = currVerb.getName();

        if (Action.equals("eat")) {

            if (! parser.parseCommandNoun (myInventory))
                System.out.printf("What did you want me to %s?\n", currVerb.getName());
            else {
                Noun currNoun = parser.getNoun();
                if (currNoun.canEat()) {
                    System.out.printf("Yum!  My favorite, a big %s.\n", currNoun.getDisplayName());
                    myInventory.remove(currNoun);
                }
                else
                    System.out.println("I don't think you can eat that.");
            }
        }
        else if (Action.equals("take")) {
            if (! parser.parseCommandNoun (roomInventory)) {
                if (parser.getNoun()!=null && !parser.isNounUnique())
                    System.out.printf("Which %s did you want to take?\n", parser.getNoun().getName());
                else
                    System.out.println("I don't see that in here.");
            }
            else {
                Noun currNoun = parser.getNoun();
                if (currNoun.canTake()) {
                    System.out.printf("You now have the %s.\n", currNoun.getDisplayName());
                    myInventory.add(currNoun);
                    roomInventory.remove(currNoun);
                } else
                    System.out.println("I'm not picking that up!");
            }
        }
        else if (Action.equals("drop")) {

            if (! parser.parseCommandNoun (myInventory))
                System.out.println("you're not holding that.");
            else {
                Noun currNoun = parser.getNoun();
                System.out.printf("you drop the %s.\n", currNoun.getDisplayName());
                myInventory.remove(currNoun);
                roomInventory.add(currNoun);
            }
        }
        else if (Action.equals("examine")) {

            if (! parser.parseCommandNoun (myInventory))
                System.out.println("you're not holding that.");
            else {
                Noun currNoun = parser.getNoun();
                if (currNoun.canExamine())
                    System.out.println(currNoun.getDescription());
            }
        }
        else if (Action.equals("open")) {

            if (!parser.parseCommandNoun(myInventory))
                System.out.println("you're not holding that.");
            else {
                Noun currNoun = parser.getNoun();
                if (currNoun.canOpen()) {
                    System.out.println(currNoun.getDescription());
                } else
                    System.out.printf("Hard as you try you cannot open the %s\n", currNoun.getDisplayName());
            }
        }
    }


}
