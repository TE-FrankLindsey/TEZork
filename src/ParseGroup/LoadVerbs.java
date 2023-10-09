package ParseGroup;

import Verb.Verb;
import Verb.Examine;
import Verb.Open;
import Verb.Take;
import Verb.Eat;
import Verb.Inventory;
import Verb.Drop;
import Verb.Look;
import Verb.Go;

import java.util.ArrayList;
import java.util.List;

public class LoadVerbs {

    public static List<Verb>load () {
        List<Verb> verbList = new ArrayList<>();

        verbList.add (new Examine());
        verbList.add (new Open());
        verbList.add (new Take());
        verbList.add (new Eat());
        verbList.add (new Drop());
        verbList.add (new Inventory());
        verbList.add (new Look());
        verbList.add (new Go());

        return verbList;
    }
}
