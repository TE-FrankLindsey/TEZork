package Nouns;

import java.util.ArrayList;
import java.util.List;

public class NounInventory {

    public List<Noun> inventory = new ArrayList<>();

    public int getSize()
        { return inventory.size(); }

    public Noun getItem (int idx)
        { return (idx>=inventory.size()) ? null : inventory.get(idx); }

    public void clear ()
        { inventory.clear(); }

    public void removeItem (Noun noun)
        { inventory.remove(noun); }

    public void addItem (Noun noun)
        { inventory.add(noun); }

    public void loadNouns () {
        inventory.clear();

        inventory.add (new Pill());
        inventory.add (new RedPill());
        inventory.add (new BluePill());
        inventory.add (new RedApple());
        inventory.add (new BlueApple());
        inventory.add (new Rubble());
inventory.add (new IDCard());
        inventory.add (new WaterFountain());
        inventory.add (new Condom());
        inventory.add (new AllyDoor());
        inventory.add (new Clerk());
//        inventory.add (new OrnateEgg());
    }


    public String getList () {

        // make list of all items which do not have the HIDE attribute
        List<Noun> tmpInventory = new ArrayList<>();
        for (Noun someNoun : inventory)
            if (! someNoun.canHide())
                tmpInventory.add(someNoun);


        String list = "";
        if (tmpInventory==null || tmpInventory.size()==0)
            list = "nothing";
        else {


            // make list of all items without the HIDE attribute
            list = tmpInventory.get(0).getDisplayName();
            for (int i = 1; i != tmpInventory.size(); i++) {
                list += (i==tmpInventory.size()-1) ? " and " : ", ";
                list += tmpInventory.get(i).getDisplayName();
            }
        }

        return list;
    }

    public boolean contains (String modifier, String name) {
        for (Noun someNoun : inventory)
            if (someNoun.nameEquals(modifier, name))
                return true;

        return false;
    }

    public boolean markNounAmbiguous (Noun noun) {

        int nounCount = 0;
        for (Noun someNoun : inventory)
            if (someNoun.nameEquals(noun)) {
                if (++nounCount > 1) {
                    noun.setAmbiguous(true);
                    return true;
                }
            }

        noun.setAmbiguous(false);
        return false;
    }
}
