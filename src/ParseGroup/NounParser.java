package ParseGroup;

public class NounParser extends Parser {

    String[] nounAry = {
            "cup", "pill", "card", "knife", "chair"
    };

    public NounParser () {

    }

    public boolean parse (String text) {

        int prevTextPtr = getParserPtr();
        eatBlanks ();

        for (int i=0; i!=nounAry.length; i++) {
            if (eatSubString(nounAry[i])) {
                currNoun = nounAry[i];
                return true;
            }
        }

        setParserPtr(prevTextPtr);
        return false;
    }


}
