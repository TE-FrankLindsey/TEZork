package ParseGroup;

import Rooms.Room;

public class DAO {


    public enum ConduomStatus {NONE, HELD, GONE};
    public static ConduomStatus conduomStatus = ConduomStatus.NONE;

    public static Room currRoom = null;


    static {
        conduomStatus = ConduomStatus.NONE;
    }

}
