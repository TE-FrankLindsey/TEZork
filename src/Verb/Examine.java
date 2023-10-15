package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Examine extends Verb {

    public Examine() {

        super(
            // name
            "examine",

            // synonyms
            new String[]{"examine", "look at"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ANY; }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {
        if (noun == null) {
            System.out.println("you're not holding that.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to examine?\n", noun.getName());
            return;
//        } else if (! noun.canExamine()) {
//            System.out.println("...not ...going ...to ...try ...that");
//            return;
        }

        // individualize result for each noun
        String defaultMsg = String.format("I see nothing unusual about this %s.", noun.getDisplayName());
        System.out.println(noun.examineMsg(defaultMsg));
        noun.examine(myInventory, roomInventory);

    }

}
