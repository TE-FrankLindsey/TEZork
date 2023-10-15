import Nouns.Noun;
import Verb.Verb;

public class Message {

    public static String getMessage (Verb verb, Noun noun) {

        if (verb==null)
            return "I have no idea what you are asking of me.";

        if (noun==null)
            return String.format("What do you want me to %s?", verb.getName());

        if (noun.isAmbiguous())
            return String.format("Which %s did you want me to %s?", noun.getName(), verb.getName());


        if (verb.getName()=="eat") {
            if (noun.canTake())
                return String.format("You eat the %s. Yum, yum!", noun.getName());
            else
                return String.format("You cannot eat the %s!  I wouldn't advise it anyway.", noun.getName());
        }

        if (verb.getName()=="take") {
            if (noun.canTake())
                return String.format("You now have the %s in your hands.", noun.getName());
            else
                return String.format("You cannot pick the %s up.", noun.getName());
        }

        if (verb.getName()=="examine") {
            if (noun.canTake())
                return String.format("It looks like a normal %s to me.", noun.getName());
            else
                return String.format("You don't want to get that close to the %s.", noun.getName());
        }

        if (verb.getName()=="open") {
            if (noun.canTake())
                return String.format("You manage to open the %s.", noun.getName());
            else
                return String.format("Try as hard as you can, the %s will not open.", noun.getName());
        }

        if (verb.getName()=="touch") {
            if (noun.canTake())
                return String.format("Did touching the %s give you a thrill?", noun.getName());
            else
                return String.format("Nope.  You are not going to touch the %s.", noun.getName());
        }

        return "Ehhh...?";

    }




}
