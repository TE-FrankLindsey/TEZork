package ParseGroup;

import java.util.List;
import java.util.ArrayList;

public class TakeVerb extends Parser {

    private List<String> takeSynonyms = new ArrayList<String>();

    public TakeVerb () {
        takeSynonyms.add("take");
        takeSynonyms.add("get");
        takeSynonyms.add("grab");
    }

    public boolean parse () {
//        for (String someVerb : takeSynonyms)
//            if (eatSubString(someVerb))
//        return takeSynonyms.contains();
return false;
    }

}
