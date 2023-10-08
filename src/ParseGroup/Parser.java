package ParseGroup;


import Nouns.Noun;
import Verb.Verb;

import java.util.List;

public class Parser {
    protected static String textIn;
    protected static int XparserPtr;

    protected static Verb currVerb = null;
    protected static String currNoun = "";


//    private VerbParser verbParser = new VerbParser();

    private List<Noun> allNouns;
    private List<Verb> allVerbs;

    public Parser () {
        allNouns = LoadNouns.load();
        int x = allNouns.size();
        allVerbs = LoadVerbs.load();
    }

    public int getParserPtr()                            { return XparserPtr; }
    public void setParserPtr(int idx)                    {

System.out.printf("setParserPtr %d\n", idx);

        XparserPtr = idx; }

    protected void advanceParserPtr(int length)
        {

            XparserPtr += length;
System.out.printf("advanceParserPtr %d, %d\n", length, XparserPtr);

        }

    private String remainingText()
        { return textIn.substring(XparserPtr); }

    protected boolean eatSubString (String text) {
        int len = text.length();
        if (len > textIn.length()-XparserPtr)
            return false;

        String subText = textIn.substring(XparserPtr, XparserPtr +len);
        if (text.equalsIgnoreCase(subText)) {
            advanceParserPtr(len);
            return true;
        }

        return false;
    }

    protected boolean matchSubString (String text) {
        int len = text.length();
        String subText = textIn.substring(XparserPtr, XparserPtr +len);
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
        }
    }

    public boolean parseText (String textIn) {
        this. textIn = textIn;
        XparserPtr = 0;


        // parse out the verb noun pair, clear verb and noun first
        currVerb = null;
        currNoun = "";
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
//        boolean hasVerb = false;
        for (Verb someVerb : allVerbs)

            for (int i=0; i!=someVerb.getSynonymCount(); i++) {
                if (eatSubString(someVerb.getSynonym(i))) {
                    currVerb = someVerb;
                    break;
                }
            }

            /*
            if (someVerb.parse(remainingText())) {
                currVerb = someVerb.getName();
                hasVerb = true;
System.out.println("parseVerbNounPair");
System.out.printf("parserPtr: %d, %d\n", XparserPtr, currVerb.length());
                XparserPtr += currVerb.length();
                break;
            }
*/

        eatBlanks();

        if (currVerb != null) {
            System.out.printf("parsed-- %s, %s\n", currVerb.getName(), remainingText());
        }
        else
           System.out.println("I do not understand");

        return true;
    }

}
