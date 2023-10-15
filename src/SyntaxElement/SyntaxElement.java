package SyntaxElement;

public abstract class SyntaxElement {

    protected String shortDescription;
    protected String longDescription;
    private boolean visited = false;

    public String getLongDescription () {
        visited = true;
        return longDescription;
    }

    public String getDescription () {
        if (visited)
            return shortDescription;

        return getLongDescription();
    }


    protected  SyntaxElement (String shortDescription, String longDescription) {
       this.shortDescription = shortDescription;
       this.longDescription = longDescription;
    }
    protected  SyntaxElement () {
       this.shortDescription = null;
       this.longDescription = null;
    }

}
