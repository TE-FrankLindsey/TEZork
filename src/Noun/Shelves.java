package Noun;


public class Shelves extends Noun {

    public Shelves() {

        super(
                // attributes
                0,
                // name
                "shelves",
                // synonyms
                new String[]{"shelves", "shelf"},
                // modifier
                "",
                // shortDescription
                "Nothing you need here.",
                // longDescription
                "The shelves are filled with all the necessities of life:\n"
                +"\"Dwinkies,\" \"Wallo-Wars,\" \"Loritos,\" various colas, cheap wine and coffee.\n"
                +"You don't see anything you really need in this part of the store."
        );
    }

    public void examine() {
        System.out.println(getDescription());
    }

}
