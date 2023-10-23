package ParseGroup;

import Noun.*;

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
//        nounList.add (new Water());
        nounList.add (new Condom());

        return nounList;
    }



}
