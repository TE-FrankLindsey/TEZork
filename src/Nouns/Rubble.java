package Nouns;


import Nouns.Noun;

public class Rubble extends Noun {

    public Rubble() {

        super(
                // attributes
                0,
                // name
                "rubble",
                // modifier
                "dirty",
                // shortDescription
                "shortDescription: It's a nasty pile of rubble",
                // longDescription
                "longDescription It's a nasty pile of rubble"
        );
    }

    private OrnateEgg ornateEgg = null;

    public String examineMsg(String defaultMsg) {
        String msg = "Looks like a dirty collection of scraps and debris.\n";
        if (ornateEgg == null)
            msg += "There is a glint of something in the rubble, looks like an ornate egg!\n" +
                "...gold plated and jewel encrusted!\nThe egg dislodged from the rubble.";
        else
            msg += "Which once held an ornate egg.";

        return msg;
    }

    public String touchMsg(String defaultMsg)
        { return "Nope, not touching that.  Too nasty!"; }

    public void examine (Inventory myInventory, Inventory roomInventory) {
        if (ornateEgg == null) {
            ornateEgg = new OrnateEgg();
            roomInventory.addItem(ornateEgg);
        }
    }

}
