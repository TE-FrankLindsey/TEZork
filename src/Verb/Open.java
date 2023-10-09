package Verb;

import Verb.Verb;

public class Open extends Verb {

    public Open() {

        super(
            // name
            "open",

            // synonyms
            new String[]{"open", "pry open", "force open"}
        );
    }

    public String getCannotMessage ()
        { return "I cannot open that!"; }

}
