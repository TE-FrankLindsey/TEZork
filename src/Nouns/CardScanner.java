package Nouns;


public class CardScanner extends Noun {

    public CardScanner() {

        super(
                // attributes
                TAKE,
                // name
                "scanner",
                // modifier
                "card",
                // shortDescription
                "Standard card scanner. I think you could open the door if you had an ID Card.",
                // longDescription
                "Standard card scanner. I think you could open the door if you had an ID Card."
        );
    }

//        public void examine() {
//            System.out.println("Looks like this could be used to open a door!");
//        }

    public String examineMsg(String defaultMsg)
        { return getDescription(); }


}
