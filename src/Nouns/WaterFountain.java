package Nouns;


public class WaterFountain extends Noun {

    public WaterFountain() {

        super(
                // attributes
                TAKE,
                // name
                "fountain",
                // synonyms
                new String[]{"fountain", "dispenser"},
                // modifier
                "water",
                // shortDescription
                "Dispenser of cool, clear water.",
                // longDescription
                "Bright shiny water fountain dispensing cool, clear water."
        );
    }


    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

    public void take(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println("You can't pick that up 'Chief'."); }

}
