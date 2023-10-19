package Rooms;


import Nouns.Clerk;
import Nouns.Shelves;
import Nouns.SmallSign;
import Rooms.Room;

public class QuikiMart extends Room {

    public QuikiMart() {

        super(
            // name
            "QuikiMart",
            // shortDescription
            "Inside the Quiki (sticky) Mart.  Exit to the west",
            // longDescription
            "\n\nNow inside the QuikiMart you see store shelves, several foggy eyed customers and the clerk standing behind the counter.\n"
                + "There is an exit to the west.  A small sign graces the counter.\n"
        );

        addExit ("west", "AtQuikiMart");
        addItem(new Clerk());
        addItem(new Shelves());
        addItem(new SmallSign());
    }

}
