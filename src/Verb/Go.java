package Verb;

public class Go extends Verb {

    public Go() {

        super(
                // name
                "go",

                // synonyms
                new String[]{"go", "travel", "move", "walk", "run"}
        );
    }

    public String getCannotMessage ()
        { return "You cannot go that way!"; }

}
