package Verb;

import Noun.NounInventory;
import Noun.Noun;
import ParseGroup.DAO;

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

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

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

        noun.take(DAO.myInventory, roomInventory);
    }

}
