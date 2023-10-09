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
        nounList.add (new IDCard());

        return nounList;
    }

    public static List<Noun>loadDirections () {
        List<Noun> DirectionList = new ArrayList<>();

        DirectionList.add (new West());
        DirectionList.add (new East());
        DirectionList.add (new North());
        DirectionList.add (new South());

        return DirectionList;
    }

}
