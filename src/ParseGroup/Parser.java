package ParseGroup;


import Nouns.Noun;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    protected static String verb = "";
    protected static String noun = "";

    protected static String textIn;
    protected static int parserPtr;

//    private VerbParser verbParser = new VerbParser();

    private List<Noun> allNouns = new ArrayList<Noun>();

    public Parser () {
        LoadNouns.load(allNouns);
        int x = allNouns.size();
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

    public boolean parseText (String text) {
        verb = "";
        noun = "";
        parserPtr = 0;

//        if (verbParser.parse(text))
//            System.out.printf("VERB>>%s<<\n", verb);
//        else
//            System.out.println("Verb not found!");


        return true;
    }


}
