package Nouns;


public class SmallSign extends Noun {

    public SmallSign() {

        super(
                // attributes
                0,
                // name
                "sign",
                // modifier
                "small",
                // shortDescription
                "shortDescription: It's an ID card",
                // longDescription
                "A small, discretely hand-lettered sign says:\n"
                +"\"Prophylactics For Sale Ask Clerk\""
        );
    }

    public void examine() {
        System.out.println(getDescription());
    }

}
