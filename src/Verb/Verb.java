package Verb;

import Nouns.Inventory;
import Nouns.Noun;
import SyntaxElement.SyntaxElement;

public abstract class Verb extends SyntaxElement {

    protected final String name;
    protected String[] synonyms;

    public enum inventorySpec {MY, ROOM, ANY};

    public inventorySpec whichInventory()
        { return inventorySpec.MY; }

    public String getName()
        { return name; }

    public int getSynonymCount () {
        return synonyms.length;
    }

    public String getSynonym (int x) {
        return synonyms[x];
    }

    public Verb(String name, String[] synonyms) {
        this.name = name;
        this.synonyms = synonyms;
    }

//    public abstract String getCannotMessage ();
    public abstract void runCommand(Noun noun, String prepNoun, Inventory myInventory, Inventory roomInventory);


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