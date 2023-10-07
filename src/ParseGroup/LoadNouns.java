package ParseGroup;

import Nouns.BluePill;
import Nouns.Noun;
import Nouns.Pill;
import Nouns.RedPill;

import java.util.ArrayList;
import java.util.List;

public class LoadNouns {

    public static List<Noun>load () {
        List<Noun> nounList = new ArrayList<>();

        nounList.add (new Pill());
        nounList.add (new RedPill());
        nounList.add (new BluePill());

        return nounList;
    }
}
