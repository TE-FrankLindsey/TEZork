package Nouns;


public class AlloyDoor extends Noun {

    private boolean locked = true;

    public AlloyDoor() {

        super(
                // attributes
                TOUCH | OPEN,
                // name
                "door",
                // modifier
                "locked",
                // shortDescription
                "Looks locked, card scanner to the side.",
                // longDescription
                "Looks like a secure locked door.  There is a Card Scanner beside the door."
        );
    }


    public boolean open (String prepNoun, Inventory myInventory) {
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


}
