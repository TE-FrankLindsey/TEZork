package Verb;

import Nouns.NounInventory;
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

    public void runCommand(Noun noun, String prepNoun, NounInventory myInventory, NounInventory roomInventory) {
        System.out.println("You see around you: " + roomInventory.getList());
    }

}
