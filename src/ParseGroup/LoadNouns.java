package ParseGroup;

import Nouns.BluePill;
import Nouns.Noun;
import Nouns.Pill;
import Nouns.RedPill;

import java.util.List;

public class LoadNouns {

    public static void load (List<Noun> nounList) {
        Noun tmpNoun = new Pill();
        nounList.add (tmpNoun);
        tmpNoun = new RedPill();
        nounList.add (tmpNoun);
        tmpNoun = new BluePill();
        nounList.add (tmpNoun);

    }
}
