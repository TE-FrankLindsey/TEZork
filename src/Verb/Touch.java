package Verb;

import Noun.NounInventory;
import Noun.Noun;

public class Touch extends Verb {

    public Touch() {

        super(
                // name
                "touch",

                // synonyms
                new String[]{"touch", "feel", "poke"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ANY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

        if (noun == null) {
            System.out.println("I don't see that here.");
            return;
        }
        else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to touch?", noun.getName());
            return;
        }

        noun.touch();
    }

}
