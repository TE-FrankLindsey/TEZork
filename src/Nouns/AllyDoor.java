package Nouns;


import Rooms.Room;

public class AllyDoor extends Noun {

    private boolean locked = true;

    public Room aRoom = null;

    public AllyDoor() {

        super(
            // attributes
            TOUCH | OPEN,
            // name
            "door",
            // synonyms
            new String[]{"door", "entrance"},
            // modifier
            "locked",
            // shortDescription
            "Looks locked, card scanner to the side.  Open with ID card?",
            // longDescription
            "Looks like a securely locked door.  There is a Card Scanner beside the door.\nMaybe door can be unlocked with an ID card."
        );
    }


    public boolean open (Noun prepNoun, NounInventory myInventory) {
        if (!locked)
            System.out.println("Door is already unlocked.");
        else if (prepNoun == null)
            System.out.println("You cannot open this door. (Maybe if you opened it using an ID card?)");
        else if (!myInventory.contains(prepNoun))
            System.out.println("You are not holding the ID Card.");
        else {
            System.out.println("ID card unlocks the door.");
            modifier = "unlocked";
            shortDescription = "Unlocked door";
            longDescription = "Previously locked door but now unlocked";
            locked = false;
            return true;
        }

        return false;
    }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

}
