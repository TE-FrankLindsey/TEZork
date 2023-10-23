package Verb;

import Noun.NounInventory;
import Noun.Noun;

public class Look extends Verb {

    public Look() {

        super(
            // name
            "look",

            // synonyms
            new String[]{"look", "look around"}
        );
    }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {
        System.out.println("You see around you: " + roomInventory.getList());
    }

}
