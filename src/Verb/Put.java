package Verb;

import Nouns.Noun;
import Nouns.NounInventory;
import Verb.Verb;

public class Put extends Verb {

    public Put() {

        super(
            // name
            "put",

            // synonyms
            new String[]{"put", "place", "throw", "pour", "squirt"}
        );
    }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {
        if (noun == null) {
            System.out.println("You're not holding that.");

        } else if (noun.isUnknown()) {
            System.out.printf("You don't have %s here.\n", noun.getName());


        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you mean?\n", noun.getName());
        } else {
            noun.put(prepNoun, myInventory, roomInventory);
//            System.out.printf("The %s falls out of your hand.\n", noun.getDisplayName());
//            myInventory.removeItem(noun);
//            roomInventory.addItem(noun);
        }
    }
}
