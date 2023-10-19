package Rooms;


public class AtQuikiMart extends Room {

    public AtQuikiMart() {

        super(
            // name
            "AtQuikiMart",
            // shortDescription
            "To the east is a local QuikiMart",
            // longDescription
            "\n\nEast of you is one of countless QuikiMarts in this city.\n" +
            "Open 24 hours a day, 7 days a week to meet your purchasing needs."
        );

        addExit ("east", "QuikiMart");
        addExit ("south", "AtBar");
    }

}
