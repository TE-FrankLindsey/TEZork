
import ParseGroup.Parser;

import java.util.Scanner;

public class EventLoop {


    Scanner userInput = new Scanner (System.in);
    public EventLoop () {
        System.out.println("Hello game!");
//        String textIn = userInput.nextLine();
//        if (textIn.equals("q")) {
//            System.out.println("good-bye!");
//            return;
//        }
    }


    public void RunGame () {
        Parser parser = new Parser ();
        ProcessCommand processCommand = new ProcessCommand();

        for (boolean keepGoing=true; keepGoing; ) {

            System.out.print(">>");
            String textIn = userInput.nextLine();
//            System.out.printf(">>%s<<\n", textIn);
            if (textIn.equals("q")) {
//                System.out.printf(">>%s<<\n", textIn);
                return;
            }
            processCommand.runCommand(textIn);
            System.out.println("");

        }
    }

}
