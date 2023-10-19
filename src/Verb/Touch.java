package Verb;

import Nouns.NounInventory;
import Nouns.Noun;

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

    public void runCommand(Noun noun, String prepNoun, NounInventory myInventory, NounInventory roomInventory) {

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
