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
                "looks like an ornate egg! Gold plated and jewel encrusted!",
                // longDescription
                "There is a glint of something in the rubble, looks like an ornate egg!\n"
                + "...gold plated and jewel encrusted!"
        );
    }


    public void take(NounInventory myInventory, NounInventory roomInventory) {
        System.out.println("You pick up the gold plated, jewel encrusted, ornate egg ...\n" +
                "...my bad, it was just a bottle cap.\n" +
                "The alley fumes must be affecting my eyes.\n\n" +
                "Underneath the egg is revealed an ID Card.");

        myInventory.addItem(new BottleCap());
        roomInventory.removeItem(this);
        roomInventory.addItem(new IDCard());
    }

    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

}
