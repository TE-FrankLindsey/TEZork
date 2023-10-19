package Nouns;


public class CardScanner extends Noun {

    public CardScanner() {

        super(
                // attributes
                TOUCH,
                // name
                "scanner",
                // modifier
                "card",
                // shortDescription
                "Standard card scanner. I think you could open the door if you had an ID Card.",
                // longDescription
                "Card scanner. Could open the door if you had an ID Card?"
        );
    }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

}
