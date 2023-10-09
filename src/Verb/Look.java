package Verb;

public class Look extends Verb {

    public Look() {

        super(
            // name
            "look",

            // synonyms
            new String[]{"look", "look around"}
        );
    }

    public String getCannotMessage ()
        { return "I cannot drop that!"; }
}
