package Rooms;

import java.util.HashMap;
import java.util.Map;

public class RoomMap {

    private Map<String, Room> allRooms = new HashMap<>();

    public RoomMap() {
        allRooms.put("AtAlly", new AtAlly());
        allRooms.put("AllyLobby", new AllyLobby());
        allRooms.put("AtBar", new AtBar());
        allRooms.put("AtQuikiMart", new AtQuikiMart());
        allRooms.put("BarAlley", new BarAlley());
        allRooms.put("QuikiMart", new QuikiMart());
    }

    public Room getRoom(String roomKey) {
        if (roomKey != null) {
            if (!roomKey.isBlank()) {
                try {
                    return allRooms.get(roomKey);
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    /*
    private List<Room> inventory = new ArrayList<>();

    public RoomMap() {
        inventory.add(new AtAlly());
    }
    public void clear() {
        inventory.clear();
    }
    public int getSize()
        { return inventory.size(); }

    public Room getRoom (String Name) {
        for (Room someRoom : inventory)
            if (someRoom.name == Name)
                return someRoom;

        return null;
    }
*/

}
