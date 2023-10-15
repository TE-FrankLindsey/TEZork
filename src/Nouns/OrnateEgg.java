package Nouns;


public class OrnateEgg extends Noun {

    public OrnateEgg() {

        super(
                // attributes
                TAKE,
                // name
                "egg",
                // modifier
                "ornate",
                // shortDescription
                "ornate egg",
                // longDescription
                "Glinting, gold plated, jewel encrusted, ornate egg!"
        );
    }


    public boolean take(Inventory myInventory, Inventory roomInventory) {
        myInventory.addItem(new BottleCap());
        roomInventory.removeItem(this);
        roomInventory.addItem(new IDCard());
        return true;
    }

    public String takeMsg(String defaultMsg) {
        return "You pick up the gold plated, jewel encrusted, ornate egg ...\n" +
                "...my bad, it was just a bottle cap.\n" +
                "The alley fumes must be affecting your eyes.\n\n" +
                "Underneath the egg is revealed an ID Card!";
    }

    public String examineMsg(String defaultMsg) {
        return "There is a glint of something in the rubble, looks like an ornate egg!\n" +
                "...gold plated and jewel encrusted!";
    }

}
