package Nouns;

import SyntaxElement.SyntaxElement;

public abstract class Noun extends SyntaxElement {

    protected final String modifier;
    protected final String name;

    protected final static int EAT = 1;
    protected final static int TAKE = 2;
    protected final static int EXAMINE = 4;
    protected final static int OPEN = 8;

    protected int attributes;

    public String getModifier()
        { return modifier; }

    public String getName()
        { return name; }

    public String getDisplayName()
        { return (modifier!=null) ? String.format("%s %s", modifier, name) : name; }

    public Noun () {
        super("", "");
        attributes = 0;
        this.name = "";
        this.modifier = null;
    }

    public Noun (int attributes, String name, String modifier, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.attributes = attributes;
        this.name = name;
        this.modifier = modifier;
    }

    public Noun (int attributes, String name, String shortDesc, String longDesc) {
        super(shortDesc, longDesc);
        this.attributes = attributes;
        this.name = name;
        this.modifier = null;
    }


    // attributes to determine if action verb can be applied
    //   by default all attributes are false unless overridden by derived noun
    public boolean canEat ()
        { return (attributes&EAT) == EAT; }
    public boolean canTake ()
        { return (attributes&TAKE) == TAKE; }
    public boolean canExamine ()
        { return (attributes&EXAMINE) == EXAMINE; }
    public boolean canOpen ()
        { return (attributes&OPEN) == OPEN; }


    // room support - move out to "Room" class soon as possible

    protected final static int ENTER = 16;
    protected final static int GO = 32;

    public boolean canGo ()
        { return (attributes&GO) == GO; }

    

}