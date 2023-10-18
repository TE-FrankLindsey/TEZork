package Nouns;


import java.util.Scanner;

public class Clerk extends Noun {

    public Clerk() {

        super(
                // attributes
                TALK,
                // name
                "clerk",
                // modifier
                "friendly",
                // shortDescription
                "Tired looking clerk behind counter",
                // longDescription
                "Quiki Mart clerk behind counter, looks tired and over worked.  Probably wants to go home."
        );
    }

    public String examineMsg(String defaultMsg)
        { return getDescription(); }

    public String talkMsg(String defaultMsg)
        { return getDescription(); }

    public boolean talk(String prepNoun, NounInventory inventory) {
        if (prepNoun.equals("condom")) {
            System.out.println("Clerk: \"Yes we sell those:\"");
            purchaseCondom (inventory);

            return true;
        }

        return false;
    }

    private void purchaseCondom (NounInventory inventory) {
        Scanner userInput = new Scanner (System.in);

        String spec1 = "";
        while (!spec1.equals("smooth") && !spec1.equals("ribbed")) {
            System.out.print("Clerk: \"Smooth or ribbed?\"\n>>");
            spec1 = userInput.nextLine();
        }

        String spec2 = "";
        while (!spec2.equals("colored") && !spec2.equals("plain")) {
            System.out.print("Clerk: \"Colored or plain?\"\n>>");
            spec2 = userInput.nextLine();
        }

        String spec3 = "";
        while (!spec3.equals("lubricated") && !spec3.equals("rough-cut")) {
            System.out.print("Clerk: \"Lubricated or rough-cut?\"\n>>");
            spec3 = userInput.nextLine();
        }

        String spec4 = "";
        while (!spec4.equals("striped") && !spec4.equals("plaid")) {
            System.out.print("Clerk: \"Striped or plaid?\"\n>>");
            spec4 = userInput.nextLine();
        }

        String spec5 = "";
        while (!spec5.equals("peppermint") && !spec5.equals("spearmint")) {
            System.out.print("Clerk: \"Peppermint or spearmint?\"\n>>");
            spec5 = userInput.nextLine();
        }

        String modifier = String.format("%s-%s-%s-%s-%s", spec1, spec2, spec3, spec4, spec5);

        String msg = "\nClerk: \"Hey, everybody! This customer just bought a \n" +
                modifier + " rubber!!!\"\nEveryone in store looks at you...\n\"What a PERVERT!!!\"";
        System.out.println(msg);

        inventory.addItem(new Condom(modifier));

    }

}
