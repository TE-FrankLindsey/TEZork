package ParseGroup;


import Nouns.Noun;
import Verb.Verb;

import java.util.List;

public class Parser {
    protected static String textIn;
    protected static int parserPtr;

    protected static String verb = "";
    protected static String noun = "";


//    private VerbParser verbParser = new VerbParser();

    private List<Noun> allNouns;
    private List<Verb> allVerbs;

    public Parser () {
        allNouns = LoadNouns.load();
        int x = allNouns.size();
        allVerbs = LoadVerbs.load();
    }

    public int getParserPtr()                            { return parserPtr; }
    public void setParserPtr(int idx)                    { parserPtr = idx; }

    protected void advanceParserPtr(int length) {
        parserPtr += length;
    }

    protected boolean eatSubString (String text) {
        int len = text.length();
        String subText = textIn.substring(parserPtr, parserPtr +len);
        if (text.equalsIgnoreCase(subText)) {
            advanceParserPtr(len);
            return true;
        }

        return false;
    }

    protected void eatSpaces () {

        for (boolean keepGoing=true; keepGoing; ) {
            if (eatSubString(" ")) {
            } else if (eatSubString(",")) {
            } else if (eatSubString("a")) {
            } else if (eatSubString("an")) {
            } else if (eatSubString("the")) {
            } else {
                keepGoing = false;
            }
        }
    }

    protected void eatBlanks () {
        for (boolean keepGoing=true; keepGoing; ) {
            if (eatSubString(" ")) {
            } else if (eatSubString(",")) {
            } else if (eatSubString("a")) {
            } else if (eatSubString("an")) {
            } else if (eatSubString("the")) {
            } else {
                keepGoing = false;
            }
        }
    }

    public boolean parseText (String textIn) {
        this. textIn = textIn;
        parserPtr = 0;

        verb = "";
        noun = "";

//        if (verbParser.parse(text))
//            System.out.printf("VERB>>%s<<\n", verb);
//        else
//            System.out.println("Verb not found!");


        return true;
    }


}
