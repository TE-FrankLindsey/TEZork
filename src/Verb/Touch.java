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

        String msg = "I'm ...not ...touching ...that!";
        if (noun == null)
            msg = "I don't see that here.";
        else if (noun.isAmbiguous())
            msg = String.format("Which %s did you want to touch?", noun.getName());
        else {
            msg = String.format("You touched the %s.  Did that give you a thrill?", noun.getDisplayName());
            // give the noun a chance to override the message
            msg = noun.touchMsg(msg);
        }

        System.out.println(msg);
    }

}
