package Verb;

import Noun.NounInventory;
import Noun.Noun;
import ParseGroup.DAO;

public class Talk extends Verb {

    public Talk() {

        super(
            // name
            "talk",

            // synonyms
            new String[]{"talk", "ask", "chat", "discuss", "question"}
        );
    }

    public inventorySpec whichInventory()
        { return inventorySpec.ROOM; }

    public void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory) {

        if (noun == null) {
            System.out.println("I don't see any such person here.");
        } else if (noun.getClass().getName() == "Nouns.UnknownNoun") {
            System.out.printf("There is no %s around here.\n", noun.getName());
        } else if (noun.isAmbiguous()) {
            System.out.printf("Which %s did you want to talk to?\n", noun.getName());
        } else if (!noun.canTalk()) {
            System.out.printf("You find talking with %s very hard to do.", noun.getDisplayName());
        } else {

            noun.talk(prepNoun, DAO.myInventory);

//            if (! noun.talk(prepNoun, myInventory))
//                System.out.printf("\"Will the Bengals make the playoffs?\"\nClerk: \"* meh *\"\n");
//
        }
    }
}
