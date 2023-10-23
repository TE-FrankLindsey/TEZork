package Verb;

import Noun.NounInventory;
import Noun.Noun;
import SyntaxElement.SyntaxElement;

public abstract class Verb extends SyntaxElement {

    public enum inventorySpec {MY, ROOM, ANY, DIRECTION};

    public inventorySpec whichInventory()
        { return inventorySpec.MY; }

    public String getName()
        { return name; }

    public Verb(String name, String[] synonyms) {
        super (name, synonyms);
    }

    public abstract void runCommand(Noun noun, Noun prepNoun, NounInventory roomInventory);


    // textIn passed in is substring from user command, starting at current parse ptr to EOL
    //  substring as much textIn as needed to compare to synonym string
    public boolean parse (String textIn) {

        int textInLen = textIn.length();

        for (String someVerb : synonyms) {

            // if length of synonym exceeds textIn length then cannot compare
            int strLen = someVerb.length();
            if (strLen > textInLen)
                continue;

            String parseTgt = textIn.substring(0, strLen);
            if (someVerb.equals(parseTgt))
                return true;
        }

        return false;
    }

}