package Rooms;


import Nouns.Clerk;
import Rooms.Room;

public class QuikiMart extends Room {

    public QuikiMart() {

        super(
            // name
            "QuikiMart",
            // shortDescription
            "Inside the Quiki (sticky) Mart",
            // longDescription
            "\n\nNow inside the QuikiMart you see several foggy eyed customers,\na counter, a clerk and a sign on the counter.\n"
        );

        addExit ("west", "AtQuikiMart");
        addItem(new Clerk());
    }

}
