package Verb;

import SyntaxElement.SyntaxElement;

public abstract class Verb extends SyntaxElement {

    protected final String name;
    protected String[] synonyms;

    public String getName()
        { return name; }

    public int getSynonymCount () {
        return synonyms.length;
    }

    public String getSynonym (int x) {
        return synonyms[x];
    }

    public Verb(String name, String[] synonyms, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.name = name;
        this.synonyms = synonyms;
    }

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