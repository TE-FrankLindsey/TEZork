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

        if (noun == null)
            System.out.println("I don't see that here.");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to take?\n", noun.getName());
        else if (! noun.canTake()) {
            if (noun.getName().equals("water"))
                System.out.println("You take a hand full but it runs out between your fingers.  (Maybe if you had something to put it in?)");
            else
                System.out.println("I'm not picking that up!");
        }
        else {
            String msg = String.format("You now have the %s.\n", noun.getDisplayName());
            System.out.printf(noun.takeMsg(msg));
            if (! noun.take(myInventory, roomInventory)) {
                myInventory.addItem(noun);
                roomInventory.removeItem(noun);
            }
        }
    }

}
