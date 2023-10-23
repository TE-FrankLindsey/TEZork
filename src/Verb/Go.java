package Verb;

import Noun.NounInventory;
import Noun.Noun;
import ParseGroup.DAO;

public class Go extends Verb {

    public Go() {

        super(
                // name
                "go",

                // synonyms
                new String[]{"go", "travel", "move", "walk", "run"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.DIRECTION; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

        if (noun == null)
            System.out.println("I don't see that here.");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to take?\n", noun.getName());
        else if (noun.canTake()) {
            System.out.printf("?? You now have the %s.\n", noun.getDisplayName());
            DAO.myInventory.addItem(noun);
            roomInventory.removeItem(noun);
        } else
            System.out.println("I'm not picking that up!");
    }

}
