package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Drop extends Verb {

    public Drop() {

        super(
            // name
            "drop",

            // synonyms
            new String[]{"drop", "release", "unhand", "leave", "discard", "throw away"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {
        if (noun == null) {
            System.out.println("You're not holding that.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to drop?\n", noun.getName());
            return;
        }

        System.out.printf("The %s falls out of your hand.\n", noun.getDisplayName());
        myInventory.removeItem(noun);
        roomInventory.addItem(noun);
    }
}
