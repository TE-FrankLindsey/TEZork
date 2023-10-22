package ParseGroup;

import Nouns.NounInventory;
import Rooms.Room;

import java.util.Map;

public class DAO {


    public enum ConduomStatus {NONE, HELD, GONE};
    public static ConduomStatus conduomStatus = ConduomStatus.NONE;

    private static Room currRoom = null;

    public static void setCurrRoom(Room newCurrRoom)
        { currRoom = newCurrRoom; }

    public static String getRoomDescription()
        { return currRoom.getDescription(); }

    public static NounInventory getRoomInventory ()
        { return currRoom.getInventory(); }

    public static NounInventory getRoomOtherInventory ()
        { return currRoom.getOtherInventory(); }

    public static Map<String, String> getRoomDirections()
        { return currRoom.getDirections(); }

    public static String goRoomDirection(String direction)
        { return currRoom.goDirection(direction); }


    static {
        conduomStatus = ConduomStatus.NONE;
    }

}
