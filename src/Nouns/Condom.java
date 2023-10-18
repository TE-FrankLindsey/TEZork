package Nouns;


public class Condom extends Noun {

    private boolean filled = false;

    public Condom() {

        super(
                // attributes
                POUR | FILL | TAKE,
                // name
                "condom",
                // modifier
                "",
                // shortDescription
                "shortDescription: It's a condom",
                // longDescription
                "longDescription It's a condom"
        );
    }

    public Condom(String modifier) {

        super(
                // attributes
                POUR | FILL | TAKE,
                // name
                "condom",
                // modifier
                modifier,
                // shortDescription
                "Can hold some water.",
                // longDescription
                "Looks like it can hold some water."
        );
    }

    public void examine() {
        System.out.println(getDescription());
    }

    public boolean fill(String prepNoun, NounInventory roomInventory) {
        if (prepNoun.equals("water") && roomInventory.contains("water", "fountain")) {
            shortDescription = "Water filled condom.";
            longDescription = "Water filled condom.";
            filled = true;
            System.out.println("Wow, who knew a condom could hold so much water?");
            return true;
        }

        return false;
    }


}
