package ParseGroup;

import Noun.Noun;
import Noun.NounInventory;
import Rooms.Room;

import java.util.Map;

public class DAO {


    public static int giveADamns = 100;

    private static Room currRoom = null;

    public static NounInventory myInventory = null;
    public enum CondomStatus {NONE, HELD, GONE};
    public static CondomStatus condomStatus = CondomStatus.NONE;

    public static int drinkCount = 0;



    static {
        giveADamns = 100;
        currRoom = null;
        myInventory = new NounInventory();
        condomStatus = CondomStatus.NONE;
        drinkCount = 0;
    }

    //
    // Give A Damns support
    //

    public static void addGiveADamns (int increase, String message) {
        giveADamns += increase;
        if (increase > 0) {
            System.out.printf("  >> %s: Gain %d Give A Damns! :%d <<\n", message, increase, giveADamns);
        } else if (increase < 0) {
            System.out.printf("  >> %s: Lost %d Give A Damns! :%d <<\n", message, -increase, giveADamns);
        }
    }

    public static void showGiveADamns () {
        System.out.printf(">> Give A Damns: %s <<\n", giveADamns);
    }

//
// room global support
//

    public static void setCurrRoom(Room newCurrRoom)
        { currRoom = newCurrRoom; }

    public static Room getCurrRoom()
    { return currRoom; }

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


//
// myInventory global support
//

    public static void myInventoryAdd(Noun item)
        { myInventory.addItem(item); }

    public static NounInventory getMyInventory()
        { return myInventory; }

//
// Locked room support
//

//    public static Room scannerRoom = null;
//    public static Room lockedRoom = null;
//    public static Noun lockedDoor = null;


}
