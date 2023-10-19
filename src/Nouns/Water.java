package Nouns;


public class Water extends Noun {

    public Water() {

        super(
                // attributes
                HIDE | TAKE,
                // name
                "water",
                // synonyms
                new String[]{"water"},
                // modifier
                "",
                // shortDescription
                "Cool, clear water.",
                // longDescription
                "Cool, clear water.  Good for drinking, cleaning and extinguishing trashcan fires."
        );
    }


    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

    public void take(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println("You take a handfull but it runs out between your fingers.  (Maybe if you had something to put it in?)"); }


}
