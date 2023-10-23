package Verb;

import Noun.Noun;
import Noun.NounInventory;
import ParseGroup.DAO;

public class Drink extends Verb {

    public Drink() {

        super(
                // name
                "drink",

                // synonyms
                new String[]{"drink"}
        );
    }


    public inventorySpec whichInventory()
        { return inventorySpec.ANY; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {
        if (noun == null) {
            System.out.println("I don't see that nearby.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to drink?\n", noun.getName());
            return;
        } else if (! noun.canDrink()) {
            System.out.println("I don't think you can drink that.");
            return;
        }

        if (! noun.drink()) {
            System.out.printf("Drinking %s was ... interesting.\n", noun.getDisplayName());
            DAO.myInventory.removeItem(noun);
        }
    }

}
