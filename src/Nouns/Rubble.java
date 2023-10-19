package Nouns;


public class Rubble extends Noun {

    public Rubble() {

        super(
            // attributes
            0,
            // name
            "rubble",
            // synonyms
            new String[]{"rubble", "trash", "pile", "debris"},
            // modifier
            "dirty",
            // shortDescription
            "shortDescription: It's a nasty pile of rubble",
            // longDescription
            "longDescription It's a nasty pile of rubble"
        );
    }

    private OrnateEgg ornateEgg = null;

    public void touch()
        { System.out.println("Nope, not touching that.  Too nasty!"); }

    public void examine (NounInventory myInventory, NounInventory roomInventory) {
        String msg = "Looks like a dirty collection of scraps and debris.\n";
        if (ornateEgg == null) {
            msg += "There is a glint of something in the rubble, looks like an ornate egg! " +
                    "...gold plated and jewel encrusted!\nThe egg dislodges from the rubble.";

            ornateEgg = new OrnateEgg();
            roomInventory.addItem(ornateEgg);
        }
        else
            msg += "Which once held an ornate egg.";

        System.out.println(msg);
    }

}
