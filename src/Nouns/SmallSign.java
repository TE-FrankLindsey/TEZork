package Nouns;


public class SmallSign extends Noun {

    public SmallSign() {

        super(
                // attributes
                0,
                // name
                "sign",
                // synonyms
                new String[]{"sign"},
                // modifier
                "small",
                // shortDescription
                "\"Prophylactics For Sale Ask Clerk\"",
                // longDescription
                "A small, discretely hand-lettered sign says:\n"
                +"\"Prophylactics For Sale Ask Clerk\"\n\n"
                +"Hmmm ... a condom could hold water."
        );
    }

    public void examine() {
        System.out.println(getDescription());
    }

}
