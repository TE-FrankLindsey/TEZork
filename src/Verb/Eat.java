package Verb;

import Noun.NounInventory;
import Noun.Noun;
import ParseGroup.DAO;

public class Eat extends Verb {

    public Eat() {

        super(
                // name
                "eat",

                // synonyms
                new String[]{"eat", "bite", "consume", "ingest", "swallow"}
        );
    }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {
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

        if (! noun.eat()) {
            System.out.printf("Yum!  My favorite, a big %s.\n", noun.getDisplayName());
            DAO.myInventory.removeItem(noun);
        }
    }

}
