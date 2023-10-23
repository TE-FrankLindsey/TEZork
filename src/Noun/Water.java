package Noun;


import ParseGroup.DAO;

public class Water extends Noun {

    public Water() {

        super(
                // attributes
                DRINK | HIDE | TAKE,
                // name
                "water",
                // synonyms
                new String[]{"water"},
                // modifier
                "",
                // shortDescription
                "Cool, clear water.",
                // longDescription
                "Cool, clear water.  Good for drinking, cleaning and extinguishing trashcan fires."
        );
    }


    public void examine(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println(getDescription()); }

    public void take(NounInventory myInventory, NounInventory roomInventory)
        { System.out.println("You take a handfull but it runs out between your fingers.  (Maybe if you had something to put it in?)"); }

    public boolean drink() {
        if (DAO.drinkCount == 0) {
            System.out.printf("Glug! Glug! ...the pause that refreshes!\n");
            DAO.addGiveADamns(10, "Quenched your thirst!");
            DAO.drinkCount++;
        } else if (DAO.drinkCount == 1) {
            System.out.printf("Glug! Glug! ...that was a little too much, staring to feel uncomfortable!\n");
            DAO.addGiveADamns(1, "Quenched your thirst ... sorta.");
            DAO.drinkCount++;
        } else if (DAO.drinkCount == 2) {
            System.out.printf("Glug! Glug! ...too much! TOO MUCH!\n");
            DAO.addGiveADamns(-20, "Now you're in pain ... where's the restroom?");
            DAO.drinkCount++;
        } else if (DAO.drinkCount == 3) {
            System.out.printf("NO!! Don't make me turn this console adventure game around!\n");
        }

        return true;
    };

}
