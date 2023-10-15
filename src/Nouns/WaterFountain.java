package Nouns;


public class WaterFountain extends Noun {

    public WaterFountain() {

        super(
                // attributes
                0,
                // name
                "fountain",
                // modifier
                "water",
                // shortDescription
                "shortDescription: it squirts water",
                // longDescription
                "longDescription it squirts water"
        );
    }


    public void examine() {
        System.out.println("I squirts cool, clear water.");
    }


}
