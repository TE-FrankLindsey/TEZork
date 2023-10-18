package ParseGroup;

import Verb.Verb;
import Verb.VerbInventory;
import Verb.Examine;
import Verb.Open;
import Verb.Take;
import Verb.Eat;
import Verb.Drop;
import Verb.Look;
import Verb.Go;
import Verb.Touch;
import Verb.Talk;
import Verb.Fill;

import java.util.ArrayList;
import java.util.List;

public class LoadVerbs {

    public static List<Verb>load () {
        List<Verb> verbList = new ArrayList<>();

        verbList.add (new VerbInventory());
        verbList.add (new Examine());
        verbList.add (new Open());
        verbList.add (new Take());
        verbList.add (new Eat());
        verbList.add (new Drop());
        verbList.add (new Look());
        verbList.add (new Go());
        verbList.add (new Touch());
        verbList.add (new Talk());
        verbList.add (new Fill());

        return verbList;
    }
}
