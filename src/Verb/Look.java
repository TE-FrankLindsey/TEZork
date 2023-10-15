package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Look extends Verb {

    public Look() {

        super(
            // name
            "look",

            // synonyms
            new String[]{"look", "look around"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {
        System.out.println("You see around you: " + roomInventory.getList());
    }
}
