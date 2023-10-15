package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Fill extends Verb {

    public Fill() {

        super(
            // name
            "fill",

            // synonyms
            new String[]{"fill", "fill up", "load", "inflate"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {
        if (noun == null) {
            System.out.println("You're not holding that.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to fill?\n", noun.getName());
            return;
        }

        if (! noun.fill(prepNoun, roomInventory))
            System.out.printf("What do you want to fill %s with?\n", noun.getDisplayName());
//        myInventory.removeItem(noun);
//        roomInventory.addItem(noun);
    }
}
