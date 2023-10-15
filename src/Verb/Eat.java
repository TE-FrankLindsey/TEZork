package Verb;

import Nouns.Inventory;
import Nouns.Noun;

public class Eat extends Verb {

    public Eat() {

        super(
                // name
                "eat",

                // synonyms
                new String[]{"eat", "bite", "consume", "ingest", "swallow"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory) {
        if (noun == null) {
            System.out.println("I don't have one of those.");
            return;
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to eat?\n", noun.getName());
            return;
        } else if (! noun.canEat()) {
            System.out.println("I don't think you can eat that.");
            return;
        }

        System.out.printf("Yum!  My favorite, a big %s.\n", noun.getDisplayName());
        myInventory.removeItem(noun);
    }

}
