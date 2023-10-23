package Rooms;

import Noun.Noun;
import Noun.NounInventory;
import SyntaxElement.SyntaxElement;

import java.util.HashMap;
import java.util.Map;

public class Room extends SyntaxElement{

    protected boolean locked = false;

    public boolean isLocked()
        { return locked; }

    public void setLocked(boolean locked)
        { this.locked = locked; }

    protected Map<String, String> directions = new HashMap<>();

    public Map<String, String> getDirections()
        { return directions; }

    protected void addExit(String direction, String roomName)
        { directions.put(direction, roomName); }
    public String getExit(String direction) {
        try {
            return directions.get(direction);
        }
        catch (Exception e) {
        }
        return "";
    }

    protected NounInventory inventory = new NounInventory();

    public NounInventory getInventory() {
        return inventory;
    }

    public void addItem (Noun someThing) {
        inventory.addItem(someThing);
    }

    protected Room (String name, String shortDesc, String longDesc) {
        super(name, shortDesc, longDesc);
        this.locked = false;
    }

    public String goDirection(String direction) {
        if (direction.isBlank())
            return null;

        String gotoRoom = directions.get(direction);
        return gotoRoom;
    }


}
