package ParseGroup;

import Nouns.*;

import java.util.ArrayList;
import java.util.List;

public class LoadNouns {

    public static List<Noun>load () {
        List<Noun> nounList = new ArrayList<>();

        nounList.add (new Pill());
        nounList.add (new RedPill());
        nounList.add (new BluePill());
        nounList.add (new RedApple());
        nounList.add (new BlueApple());
        nounList.add (new Rubble());

        return nounList;
    }
}
