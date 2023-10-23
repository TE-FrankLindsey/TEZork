package Verb;

import Noun.Noun;
import Noun.NounInventory;
import ParseGroup.DAO;

public class VerbInventory extends Verb {

    public VerbInventory() {

        super(
                // name
                "inventory",

                // synonyms
                new String[]{"inventory", "list"}
        );
    }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

        System.out.println("You are carrying: " + DAO.myInventory.getList() + ".");
    }
}