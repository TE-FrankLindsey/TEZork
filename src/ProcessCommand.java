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

        parser.parseText(Command, allInventory);
        Noun currNoun = parser.getNoun();
        Verb currVerb = parser.getVerb();

        // display messages for failed parse operation
        if (currNoun!=null && currVerb==null) {
            System.out.printf("What should I do with the %s?\n", currNoun.getDisplayName());
            return;
        }

        else if (currVerb!=null && currNoun==null) {

            if (currVerb.getName().equals("inventory")) {

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
            }

            else if (currVerb.getName().equals("look")) {

                String stuff = "The room contains: ";
                if (roomInventory==null || roomInventory.size()==0)
                    stuff += "nothing";
                else
                    for (int i=0; i!=roomInventory.size(); i++) {
                        if (i>0)
                            stuff += ", ";
                        stuff += roomInventory.get(i).getDisplayName();
                }
                System.out.println(stuff);

                stuff = "The allInventory contains: ";
                if (allInventory==null || allInventory.size()==0)
                    stuff += "nothing";
                else
                    for (int i=0; i!=allInventory.size(); i++) {
                        if (i>0)
                            stuff += ", ";
                        stuff += allInventory.get(i).getDisplayName();
                    }
                System.out.println(stuff);
            }
            else {
                System.out.printf("What did you want me to %s?\n", currVerb.getName());
                return;
            }
        }

        else if (currVerb==null && currNoun==null) {
            System.out.println("I did not understand that command.");
            return;
        }

        String Action = currVerb.getName();

        if (! parser.isNounUnique()) {
            System.out.printf("Which %s do you want to %s?", currNoun.getDisplayName(), currVerb.getDescription());
            return;
        }

        if (Action.equals("eat")) {
            if (currNoun.canEat()) {
                System.out.printf("Yum!  My favorite, a big %s.\n", currNoun.getDisplayName());
            }
            else
                System.out.println("I don't think I'll eat that");
        }
        else if (Action.equals("take")) {
            if (currNoun.canTake()) {
                System.out.printf("You now have the %s.\n", currNoun.getDisplayName());
                myInventory.add(currNoun);
                roomInventory.remove(currNoun);
            }
            else
                System.out.println("I'm not picking that up!");
        }
        else if (Action.equals("drop")) {
//            if (currNoun.canDrop()) {
                System.out.printf("you drop the %s.\n", currNoun.getDisplayName());
                myInventory.remove(currNoun);
                roomInventory.add(currNoun);
//            }
//            else
//                System.out.println("I'm not picking that up!");
        }
        else if (Action.equals("examine")) {
            if (currNoun.canExamine()) {
                System.out.println(currNoun.getDescription());
            }
        }
        else if (Action.equals("open")) {
            if (currNoun.canExamine()) {
                System.out.println(currNoun.getDescription());
            }
            else
                System.out.printf("Hard as you try you cannot open the %s\n", currNoun.getDisplayName());
        }

    }


}
