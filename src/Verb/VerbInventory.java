package Verb;

import Nouns.Noun;
import Nouns.NounInventory;

public class VerbInventory extends Verb {

    public VerbInventory() {

        super(
                // name
                "inventory",

                // synonyms
                new String[]{"inventory", "list"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, NounInventory myInventory, NounInventory roomInventory) {

        System.out.println("You are carrying: " + myInventory.getList() + ".");
    }
}