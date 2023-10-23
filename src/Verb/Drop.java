package Verb;

import Noun.NounInventory;
import Noun.Noun;
import ParseGroup.DAO;

public class Drop extends Verb {

    public Drop() {

        super(
            // name
            "drop",

            // synonyms
            new String[]{"drop", "release", "unhand", "leave", "discard", "throw away"}
        );
    }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {
        if (noun == null) {
            System.out.println("You're not holding that.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to drop?\n", noun.getName());
            return;
        }

        noun.drop (prepNoun, DAO.myInventory, roomInventory);
        System.out.printf("The %s falls out of your hand.\n", noun.getDisplayName());
        DAO.myInventory.removeItem(noun);
        roomInventory.addItem(noun);
    }
}
