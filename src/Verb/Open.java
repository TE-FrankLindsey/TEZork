package Verb;

import Nouns.NounInventory;
import Nouns.Noun;

public class Open extends Verb {

    public Open() {

        super(
            // name
            "open",

            // synonyms
            new String[]{"open", "unlock", "pry open", "force open"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ANY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {

        if (noun == null)
            System.out.println("I don't see that here.");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to open?\n", noun.getName());
        else if (! noun.canOpen())
            System.out.printf("Hard as you try you cannot open the %s!", noun.getDisplayName());
        else {
//            System.out.printf("You opened the %s.\n", noun.getDisplayName());
            noun.open (prepNoun, myInventory);
//            myInventory.addItem(noun);
//            roomInventory.removeItem(noun);
        }
    }

}
