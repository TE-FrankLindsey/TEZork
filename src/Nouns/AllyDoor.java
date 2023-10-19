package Nouns;


public class AllyDoor extends Noun {

    private boolean locked = true;

    public AllyDoor() {

        super(
                // attributes
                TOUCH | OPEN,
                // name
                "door",
                // modifier
                "locked",
                // shortDescription
                "Looks locked, card scanner to the side.  Open with ID card?",
                // longDescription
                "Looks like a securely locked door.  There is a Card Scanner beside the door.  Maybe door can be unlocked with an ID card."
        );
    }


    public boolean open (String prepNoun, NounInventory myInventory) {
        if (! locked)
            System.out.println("Door is already unlocked.");
        else if (prepNoun.equals("id card") || prepNoun.equals("card")) {

            if (! myInventory.contains("id", "card")) {
                System.out.println("You are not holding the ID Card.");
                return false;
            }
            else {
                System.out.println("ID card unlocks the door.");
                modifier = "unlocked";
                shortDescription = "Unlocked door";
                longDescription = "Previously locked door but now unlocked";
                locked = false;
                return true;
            }
        }

        System.out.println("You cannot open this door. (Maybe if you opened it using an ID card?)");
        return false;
    }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

}
