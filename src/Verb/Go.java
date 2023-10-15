package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Go extends Verb {

    public Go() {

        super(
                // name
                "go",

                // synonyms
                new String[]{"go", "travel", "move", "walk", "run"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {

        if (noun == null)
            System.out.println("I don't see that here.");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to take?\n", noun.getName());
        else if (noun.canTake()) {
            System.out.printf("You now have the %s.\n", noun.getDisplayName());
            myInventory.addItem(noun);
            roomInventory.removeItem(noun);
        } else
            System.out.println("I'm not picking that up!");
    }

}
