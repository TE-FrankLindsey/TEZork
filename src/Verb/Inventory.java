package Verb;

import Nouns.Noun;

public class Inventory extends Verb {

    public Inventory() {

        super(
                // name
                "inventory",

                // synonyms
                new String[]{"inventory", "list"}
        );
    }

    public void runCommand(Noun noun, String prepNoun, Nouns.Inventory myInventory, Nouns.Inventory roomInventory) {

        System.out.println("You are carrying: " + myInventory.getList() + ".");
    }
}