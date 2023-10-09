package Verb;

public class Drop extends Verb {

    public Drop() {

        super(
            // name
            "drop",

            // synonyms
            new String[]{"drop", "release", "unhand", "leave", "discard", "throw away"}
        );
    }

    public String getCannotMessage ()
        { return "I cannot drop that!"; }
}
