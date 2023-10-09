package Verb;

public class Inventory extends Verb {

    public Inventory() {

        super(
            // name
            "inventory",

            // synonyms
            new String[]{"inventory", "list"}
        );
    }

    public String getCannotMessage ()
        { return "I'm not holding anything!"; }

}
