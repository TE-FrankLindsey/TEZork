package SyntaxElement;

public abstract class SyntaxElement {

    protected String shortDescription;
    protected String longDescription;

    protected final String name;
    protected final String[] synonyms;

    private boolean visited = false;


    protected  SyntaxElement (String name, String[] synonyms, String shortDescription, String longDescription) {
        this.name = name;
        this.synonyms = synonyms;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    protected  SyntaxElement (String name, String shortDescription, String longDescription) {
        this.name = name;
        this.synonyms = null;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    protected  SyntaxElement (String name, String[] synonyms) {
        this.name = name;
        this.synonyms = synonyms;
        this.shortDescription = null;
        this.longDescription = null;
    }

    protected  SyntaxElement () {
        this.name = null;
        this.synonyms = null;
        this.shortDescription = null;
        this.longDescription = null;
    }


    public boolean isClass(String className)
        { return getClass().getName().equals(className); }

    public boolean nameEquals(String name)
        { return name.equalsIgnoreCase(name); }

    public String getLongDescription () {
        visited = true;
        return longDescription;
    }

    public String getDescription () {
        if (visited)
            return shortDescription;

        return getLongDescription();
    }

    public String getName()
        { return name; }

    public int getSynonymCount ()
        { return (synonyms==null) ? 0 : synonyms.length; }

    public String getSynonym (int x)
        { return synonyms[x]; }


}
