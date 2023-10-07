package Nouns;

import SyntaxElement.SyntaxElement;

public abstract class Noun extends SyntaxElement {

    protected final String modifier;
    protected final String name;

    public String getModifier()
        { return modifier; }

    public String getName()
        { return name; }

    public Noun () {
        super("", "");
        this.name = "";
        this.modifier = "";
    }

    public Noun (String name, String modifier, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.name = name;
        this.modifier = modifier;
    }

    public Noun (String name, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.name = name;
        this.modifier = "";
    }

}