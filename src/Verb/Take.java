package Verb;

import Nouns.NounInventory;
import Nouns.Noun;

public class Take extends Verb {

    public Take () {

        super(
            // name
            "take",

            // synonyms
            new String[]{"take", "grab", "get", "hold", "pickup", "pick up", "purchase"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ROOM; }

    public void runCommand(Noun noun, String prepNoun, NounInventory myInventory, NounInventory roomInventory) {

        if (noun == null) {
            System.out.println("I don't see that here.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to take?\n", noun.getName());
            return;
        } else if (! noun.canTake()) {
            System.out.println("I'm not picking that up!");
            return;
        }

        noun.take(myInventory, roomInventory);
    }

}
