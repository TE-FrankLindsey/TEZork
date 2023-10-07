package Verb;

import SyntaxElement.SyntaxElement;

public abstract class Verb extends SyntaxElement {

    protected final String name;
    protected String[] synonyms;

    public String getName()
        { return name; }


    public Verb(String name, String[] synonyms, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.name = name;
        this.synonyms = synonyms;
    }


}