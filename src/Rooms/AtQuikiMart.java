package Rooms;


public class AtQuikiMart extends Room {

    public AtQuikiMart() {

        super(
            // name
            "AtQuikiMart",
            // shortDescription
            "You're standing in front of the local QuikiMart",
            // longDescription
            "\n\nIn front of you is one of countless QuikiMarts in this city.\n" +
            "Open 24 hours a day, 7 days a week to meet your purchasing needs."
        );

        addExit ("east", "QuikiMart");
        addExit ("south", "AtBar");
    }

}
