package Verb;

import Nouns.Noun;
import Nouns.NounInventory;

public class Scan extends Verb {

    public Scan() {

        super(
            // name
            "scan",

            // synonyms
            new String[]{"scan"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.MY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {

        if (noun == null)
            System.out.println("What do you want me to scan?");
        else if (noun.isAmbiguous())
            System.out.printf("Which %s did you want to scan?\n", noun.getName());
        else if (! noun.canScan()) {
            System.out.printf("You cannot scan the %s!", noun.getDisplayName());
        }
        else {
//            System.out.printf("You opened the %s.\n", noun.getDisplayName());
            noun.open (prepNoun, myInventory);
//            myInventory.addItem(noun);
//            roomInventory.removeItem(noun);
        }
    }

}
