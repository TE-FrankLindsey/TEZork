package Nouns;


public class WaterFountain extends Noun {

    public WaterFountain() {

        super(
                // attributes
                TAKE,
                // name
                "fountain",
                // modifier
                "water",
                // shortDescription
                "It squirts cool, clear water.",
                // longDescription
                "Bright shiny water dispensing cool, clear water."
        );
    }


    public void examine() {
        System.out.println("It squirts cool, clear water.");
    }

    public boolean take(NounInventory myInventory, NounInventory roomInventory) {
        System.out.println("You can't pick that up 'Chief'.");
        return true;
    }

    public String examineMsg(String defaultMsg)
        { return "It squirts cool, clear water."; }


}
