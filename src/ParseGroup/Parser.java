package ParseGroup;


import Nouns.Noun;
import Verb.Verb;

import java.util.List;

public class Parser {
    protected static String textIn;
    protected static int parserPtr;

    protected static Verb currVerb = null;
    protected static Noun currNoun = null;
    protected enum NounStatus {SUCCESS, FAILURE, DUPLICATE}

//    private VerbParser verbParser = new VerbParser();

    private List<Noun> allNouns;
    private List<Verb> allVerbs;

    public Parser () {
        allNouns = LoadNouns.load();
        int x = allNouns.size();
        allVerbs = LoadVerbs.load();
    }

    public int getParserPtr()                            { return parserPtr; }
    public void setParserPtr(int idx)                    {

        System.out.printf("setParserPtr %d\n", idx);

        parserPtr = idx; }

    protected void advanceParserPtr(int length)
    {

        parserPtr += length;
        System.out.printf("advanceParserPtr %d, %d\n", length, parserPtr);

    }

    private String remainingText()
    { return textIn.substring(parserPtr); }

    protected boolean eatSubString (String text) {
        if (text == null)
            return false;

        // eat blanks and connectors between words
//        eatBlanks ();

        int len = text.length();
        if (len > textIn.length()- parserPtr)
            return false;

        String subText = textIn.substring(parserPtr, parserPtr +len);
        if (text.equalsIgnoreCase(subText)) {
            advanceParserPtr(len);
            return true;
        }

        return false;
    }

    protected boolean matchSubString (String text) {
        int len = text.length();
        String subText = textIn.substring(parserPtr, parserPtr +len);
        if (text.equalsIgnoreCase(subText)) {
//            advanceParserPtr(len);
            return true;
        }

        return false;
    }

    protected void eatSpaces () {

        for (boolean keepGoing=true; keepGoing; ) {
            if (eatSubString(" ")) {
            } else if (eatSubString(", ")) {
            } else if (eatSubString("a ")) {
            } else if (eatSubString("an ")) {
            } else if (eatSubString("the ")) {
            } else {
                keepGoing = false;
            }
        }
    }

    protected void eatBlanks () {
        for (boolean keepGoing=true; keepGoing; ) {
            if (eatSubString(" ")) {
            } else if (eatSubString(", ")) {
            } else if (eatSubString("a ")) {
            } else if (eatSubString("an ")) {
            } else if (eatSubString("the ")) {
            } else {
                keepGoing = false;
            }
        }    }

    public boolean parseText (String textIn) {
        this. textIn = textIn;
        parserPtr = 0;


        // parse out the verb noun pair, clear verb and noun first
        currVerb = null;
        currNoun = null;
        parseVerbNounPair ();

//        boolean hasVerb = false;
//        String subTextIn = textIn.substring(parserPtr);
//        for (Verb someVerb : allVerbs)
//            if (someVerb.parse(subTextIn)) {
//                currVerb = someVerb.getName();
//                hasVerb = true;
//                break;
//            }

//        if (verbParser.parse(text))
//            System.out.printf("VERB>>%s<<\n", verb);
//        else
//            System.out.println("Verb not found!");


        return true;
    }

    private boolean parseVerbNounPair () {

        // parse verb
        for (Verb someVerb : allVerbs)
            if (parseVerb(someVerb))
                break;

        eatBlanks();

        NounStatus rtnStatus = NounStatus.FAILURE;
        for (Noun someNoun : allNouns)
            if ((rtnStatus = parseNoun(someNoun)) != NounStatus.FAILURE)
                break;

//        if (currNoun!=null && currNoun.getModifier()==null && !isNounUnique(currNoun))
        if (rtnStatus == NounStatus.DUPLICATE)
            System.out.printf("Which %s did you want to %s??\n", currNoun.getName(), currVerb.getName());

        // parse noun
        System.out.printf("parsed-- %s, %s\n",
                (currVerb==null) ? "null" : currVerb.getName(),
                (currNoun==null) ? "null" : currNoun.getDisplayName());

//        if (currVerb != null) {
//            System.out.printf("parsed-- %s, %s\n", currVerb.getName(), remainingText());
//        }
//        else
//            System.out.println("I do not understand");

        return true;
    }

    private boolean parseVerb (Verb someVerb) {

        // search each synonym in verb for match to text
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

        // save the parser pointer in order to restore following failure
        int tmpParserPtr = parserPtr;

        // if modifier and name match then return true
        if (eatSubString(someNoun.getModifier())) {
            if (eatSubString(someNoun.getName())) {
                currNoun = someNoun;
                return NounStatus.SUCCESS;
            }
        }

        // if modifier failed to match then test for unmodified verb
        else if (eatSubString(someNoun.getName())) {

            currNoun = someNoun;

            // test for uniqueness
            if (! isNounUnique(currNoun))
                return NounStatus.DUPLICATE;
            
            return NounStatus.SUCCESS;
        }

        // on failure restore the parser pointer and return false
        parserPtr = tmpParserPtr;
        return NounStatus.FAILURE;
    }

    private boolean isNounUnique (Noun noun) {

        int nounCount = 0;
        for (Noun someNoun : allNouns)
            if (someNoun.getName().equals(noun.getName())) {
                if (++nounCount > 1)
                    return false;
            }

        return false;
    }

}
