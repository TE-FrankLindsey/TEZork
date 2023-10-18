package Nouns;

import SyntaxElement.SyntaxElement;

public abstract class Noun extends SyntaxElement {

    protected String modifier;
    protected final String name;
    protected boolean ambiguous;

    protected final static int EAT = 1;
    protected final static int TAKE = 2;
    protected final static int TALK = 4;
    protected final static int OPEN = 8;
    protected final static int TOUCH = 16;
    protected final static int FILL = 32;
    protected final static int POUR = 64;
    protected int attributes;

    public String getModifier()
        { return modifier; }

    public String getName()
        { return name; }

    public boolean isAmbiguous() {
        return ambiguous;
    }

    public void setAmbiguous(boolean ambiguous) {
        this.ambiguous = ambiguous;
    }

    public String getDisplayName()
        { return (modifier!=null && !modifier.equals("")) ? String.format("%s %s", modifier, name) : name; }

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

    public boolean equals (Noun noun) {
        if (! this.modifier.equals (noun.modifier))
            return false;

        if (! this.name.equals (noun.name))
            return false;

        return true;
    }

    public boolean nameEquals (Noun noun) {
        if (! this.name.equals (noun.name))
            return false;

        return true;
    }

    public boolean nameEquals (String modifier, String name) {
        if (modifier.isBlank() && this.name.equals(name))
            return true;

        if (this.modifier.equals(modifier) && this.name.equals(name))
            return true;

        return false;
    }

    // attributes to determine if action verb can be applied
    //   by default all attributes are false unless overridden by derived noun
    public boolean canEat ()
        { return (attributes&EAT) == EAT; }
    public boolean canTake ()
        { return (attributes&TAKE) == TAKE; }
    public boolean canTalk ()
        { return (attributes&TALK) == TALK; }
    public boolean canOpen ()
        { return (attributes&OPEN) == OPEN; }


    //
    // override messages best handled by the nouns involved instead of the verbs

    public String examineMsg(String defaultMsg)
        { return defaultMsg; }

    public String takeMsg(String defaultMsg)
        { return defaultMsg; }

    public String touchMsg(String defaultMsg)
        { return defaultMsg; }

    //
    // override actions best handled by the nouns involved instead of the verbs

    public boolean take(NounInventory myInventory, NounInventory roomInventory)
        { return false; }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { }

    public boolean talk(String prepNoun, NounInventory inventory)
        { return false; }

    public boolean open(String prepNoun, NounInventory myInventory)
        { return false; }

    public boolean fill(String prepNoun, NounInventory myInventory)
        { return false; }

    // room support - move out to "Room" class soon as possible

    protected final static int ENTER = 16;
    protected final static int GO = 32;

    public boolean canGo ()
        { return (attributes&GO) == GO; }

    

}