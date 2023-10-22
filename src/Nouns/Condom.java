package Nouns;


public class Condom extends Noun {

    private boolean filled = false;

    public Condom() {

        super(
                // attributes
                POUR | FILL | TAKE,
                // name
                "condom",
                // synonyms
                new String[]{"condom", "rubber", "prophylactic"},
                // modifier
                "",
                // shortDescription
                "Can hold some water.",
                // longDescription
                "Looks like it can hold some water."
        );

    }

    public Condom(String modifier) {

        super(
                // attributes
                POUR | FILL | TAKE,
                // name
                "condom",
                // synonyms
                new String[]{"condom", "rubber", "prophylactic"},
                // modifier
                modifier,
                // shortDescription
                "Can hold some water.",
                // longDescription
                "Looks like it can hold some water."
        );
    }


    public String getStateName() {
        return String.format("%s %s(%s)", modifier, name, (filled) ? "filled with water" : "empty");
    }

    public void examine() {
        System.out.println(getDescription());
    }

    public boolean fill(Noun prepNoun, NounInventory roomInventory) {
        if (filled) {
            System.out.println("The condom is already full.");
        } else if (prepNoun == null) {
            System.out.println("Fill the condom with what?");
        } else  if (!prepNoun.isClass("Nouns.Water") && !prepNoun.isClass("Nouns.WaterFountain")) {
            System.out.printf("I don't see any %s to fill the condom.\n", prepNoun.getName());
        } else {

            shortDescription = "Water filled condom.";
            longDescription = "Water filled condom.";
            filled = true;
            System.out.println("Wow!  Who knew a condom could hold so much water?");
            return true;
        }

        return false;
    }

    public void drop(Noun prepNoun, NounInventory myInventory, NounInventory roomInventory)
        { System.out.println("Put the condom on th efire"); }


    public void put(Noun prepNoun, NounInventory myInventory, NounInventory roomInventory)
    { System.out.println("Put the condom on th efire"); }

}
