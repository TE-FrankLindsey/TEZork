package ParseGroup;


import Nouns.NounInventory;
import Nouns.Noun;
import Verb.Verb;

import java.util.List;
import java.util.Map;

public class Parser {
    protected String command;
    protected int parserPtr;

    protected Verb currVerb = null;

    protected Noun currNoun = null;
    protected String prepNoun = "";

    protected enum NounStatus {SUCCESS, FAILURE;}
    NounStatus rtnStatus = NounStatus.FAILURE;

    public Verb getVerb()
        { return currVerb; }

    public Noun getNoun()
        { return currNoun; }

    public String getPrepNoun()
        { return prepNoun; }

    public boolean isNounUnique()
        { return rtnStatus==NounStatus.SUCCESS; }

    private NounInventory inventory;
//    private List<Noun> allNouns;
    private List<Verb> allVerbs;

    public Parser () {
        allVerbs = LoadVerbs.load();
    }

    public int getParserPtr()
        { return parserPtr; }
    public void setParserPtr(int idx)
        { parserPtr = idx; }

    // move parser pointer by indicated length
    protected void advanceParserPtr(int length)
        { parserPtr += length; }

    public String remainingText()
        { return command.substring(parserPtr); }

    // compare word of text against user entered text,
    //   compares user textIn from offset of parserPtr by length of word
    //   on match advance parser pointer by length of word
    //   return true if match was made
    protected boolean eatSubString (String word) {
        if (word == null)
            return false;

        // eat blanks and connectors between words
//        eatBlanks ();

        int len = word.length();
        if (len > command.length()- parserPtr)
            return false;

        String subText = command.substring(parserPtr, parserPtr +len);
        if (word.equalsIgnoreCase(subText)) {
            advanceParserPtr(len);
            return true;
        }

        return false;
    }

    // eat extraneous chars between words by advancing parser pointer past them
    protected void eatBlanks () {
        for (boolean keepGoing=true; keepGoing; ) {
            if (eatSubString(" ")) {
            } else if (eatSubString(", ")) {
            } else if (eatSubString("a ")) {
            } else if (eatSubString("an ")) {
            } else if (eatSubString("to ")) {
            } else if (eatSubString("of ")) {
            } else if (eatSubString("the ")) {
            } else {
                keepGoing = false;
            }
        }
    }

    public void preParseText (String command) {
        this.command = command;

        // prep the command by reducing multiple blanks to single blank and make command lower case
        while (this.command.contains("  "))
            this.command = this.command.replace("  ", " ");
        this.command = this.command.toLowerCase();

        parserPtr = 0;

        currVerb = null;
        currNoun = null;
    }

    public boolean parseCommandVerb () {

        eatBlanks();

        // look for verb in list of all verbs
        for (Verb someVerb : allVerbs)
            if (parseVerb(someVerb))
                break;

        return currVerb!=null;
    }

    public boolean parseCommandNoun (NounInventory myInventory) {

        inventory = myInventory;
        eatBlanks();
        rtnStatus = NounStatus.FAILURE;

        for (int i=0; i!=myInventory.getSize(); i++)
            if ((rtnStatus = parseNoun(myInventory.getItem(i))) == NounStatus.SUCCESS)
                return true;

        return false;
    }

    private boolean parseVerb (Verb someVerb) {

        // search each synonym in verb for match of text
        //  if found the parser pointer will advance length of synonym
        for (int i=0; i!=someVerb.getSynonymCount(); i++) {
            if (eatSubString(someVerb.getSynonym(i))) {
                currVerb = someVerb;
                return true;
            }
        }

        return false;
    }

    private NounStatus parseNoun (Noun someNoun) {
        someNoun.setAmbiguous(false);

        // save the parser pointer, on parse failure set parse pointer back to previous position
        int tmpParserPtr = parserPtr;

        // if modifier and name match then return true
        if (eatSubString(someNoun.getModifier())) {
            eatBlanks();
            if (eatSubString(someNoun.getName())) {
                currNoun = someNoun;
                return NounStatus.SUCCESS;
            }
        }

        // if modifier failed to match then test for unmodified noun
        else if (eatSubString(someNoun.getName())) {

            currNoun = someNoun;

            // flag noun uniqueness
            inventory.markNounAmbiguous(currNoun);

            return NounStatus.SUCCESS;
        }

        // on failure restore the parser pointer and return false
        parserPtr = tmpParserPtr;
        return NounStatus.FAILURE;
    }

    public boolean parsePrepPhrase (NounInventory inventory) {

        prepNoun = null;

        eatBlanks();

        if (eatSubString("with ")) {
        } else if (eatSubString("using ")) {
        } else if (eatSubString("into ")) {
        } else if (eatSubString("from ")) {
        } else if (eatSubString("about ")) {
        }
        else
            return false;

        eatBlanks();

        prepNoun = "";
        String[] prepNouns = {"condom", "id card", "card", "water"};
        for (String someNoun : prepNouns)
            if (eatSubString(someNoun)) {
                prepNoun = someNoun;
                return true;
            }

        return false;
    }


    public String parseDirection(Map<String, String> directions) {
        eatBlanks();

String x = remainingText();

        String direction = "";
        if (eatSubString("west")) {
            direction = "west";
        } else if (eatSubString("east")) {
            direction = "east";
        } else if (eatSubString("north")) {
            direction = "north";
        } else if (eatSubString("south")) {
            direction = "south";
        }


        return direction;


    }
}
