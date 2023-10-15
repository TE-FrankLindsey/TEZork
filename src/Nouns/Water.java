package Nouns;


public class Water extends Noun {

    public Water() {

        super(
                // attributes
                0,
                // name
                "water",
                // modifier
                "",
                // shortDescription
                "shortDescription: It's water",
                // longDescription
                "longDescription It's water"
        );
    }

        public void examine() {
            System.out.println("Cool, clear water.");
        }



}
