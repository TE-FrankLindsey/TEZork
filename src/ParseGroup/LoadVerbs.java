package ParseGroup;

import Verb.Verb;

import java.util.ArrayList;
import java.util.List;

public class LoadVerbs {

    public static List<Verb>load () {
        List<Verb> verbList = new ArrayList<>();

        verbList.add (new Examine());
        verbList.add (new Open());
        verbList.add (new Take());

        return verbList;
    }
}
