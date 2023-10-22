package Nouns;

import SyntaxElement.SyntaxElement;

public abstract class Noun extends SyntaxElement {

    protected String modifier;

    protected boolean ambiguous;

    protected final static int EAT = 1;
    protected final static int TAKE = 2;
    protected final static int TALK = 4;
    protected final static int OPEN = 8;
    protected final static int TOUCH = 16;
    protected final static int FILL = 32;
    protected final static int POUR = 64;
    protected final static int SCAN = 128;
    protected final static int HIDE = 256;

    protected int attributes;

    public String getModifier()
        { return modifier; }

    public boolean isUnknown()
        { return getClass().getName().equals("Nouns.UnknownNoun"); }

    public boolean isClass(String className)
    { return getClass().getName().equals(className); }

    public boolean isAmbiguous()
        { return ambiguous; }

    public void setAmbiguous(boolean ambiguous)
        { this.ambiguous = ambiguous; }

    public String getDisplayName()
        { return (modifier.isBlank()) ? name : String.format("%s %s", modifier, name); }

    public String getStateName()
        { return getDisplayName(); }

    public Noun () {
        super(null, null,null,null);
        attributes = 0;
        this.modifier = null;
    }

    public Noun (int attributes, String name, String[] synonyms, String modifier, String shortDesc, String longDesc) {
        super(name, synonyms, shortDesc, longDesc);
        this.attributes = attributes;
        this.modifier = modifier;
    }

    public Noun (int attributes, String name, String[] synonyms, String shortDesc, String longDesc) {
        super(name, synonyms, shortDesc, longDesc);
        this.attributes = attributes;
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
        for (String someName : synonyms)
            if (someName.equals(name)) {
                if (modifier.isBlank() || this.modifier.equalsIgnoreCase(modifier))
                    return true;
            }



//        if (modifier.isBlank() && this.name.equalsIgnoreCase(name))
//            return true;
//
//        if (this.modifier.equals(modifier) && this.name.equalsIgnoreCase(name))
//            return true;

        return false;
    }

    // attributes to determine if action verb can be applied
    //   by default all attributes are false unless overridden by derived noun
    public boolean canEat ()
        { return (attributes&EAT) == EAT; }
    public boolean canTake ()
        {
            return (attributes&TAKE) == TAKE; }
    public boolean canTalk ()
        { return (attributes&TALK) == TALK; }
    public boolean canOpen ()
        { return (attributes&OPEN) == OPEN; }
    public boolean canScan ()
        { return (attributes&SCAN) == SCAN; }
    public boolean canHide ()
        { return (attributes&HIDE) == HIDE; }


//
// override actions best handled by the nouns involved instead of the verbs

    public void take(NounInventory myInventory, NounInventory roomInventory) {
        System.out.printf("You now have the %s.\n", getDisplayName());

        myInventory.addItem(this);
        roomInventory.removeItem(this);
    };

    public void drop(Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {
//        Clerk.cStat = Clerk.ConduomStatus.GONE;
    };

    public void put(Noun prepNoun, NounInventory myInventory, NounInventory roomInventory) {
        int x = 0;
//        Clerk.cStat = Clerk.ConduomStatus.GONE;
    };
    public void touch()
        { System.out.printf("You touched the %s.  Did that give you a thrill?", getDisplayName()); }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        {
            System.out.println(getDescription()); }

    public void talk(Noun prepNoun, NounInventory inventory)
        { System.out.printf("\"Will the Bengals make the playoffs?\""); }

    public boolean open(Noun prepNoun, NounInventory myInventory)
        { return false; }

    public boolean fill(Noun prepNoun, NounInventory myInventory)
        { return false; }

}