package Verb;

import Nouns.NounInventory;
import Nouns.Noun;

public class Examine extends Verb {

    public Examine() {

        super(
            // name
            "examine",

            // synonyms
            new String[]{"examine", "read", "look at"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ANY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {
        if (noun == null) {
            System.out.println("you're not holding that.");
        } else if (noun.isUnknown()) {
            System.out.printf("There is no %s around here.\n", noun.getName());
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to examine?\n", noun.getName());
        } else {
            // individualize result for each noun
            noun.examine(myInventory, roomInventory);
        }
    }

}
