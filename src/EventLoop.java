
import ParseGroup.Parser;
import ParseGroup.ProcessCommand;

import java.util.Scanner;

public class EventLoop {


    Scanner userInput = new Scanner (System.in);
    public EventLoop () {

    }


    public void RunGame () {
        Parser parser = new Parser ();
        ProcessCommand processCommand = new ProcessCommand();

        for (boolean keepGoing=true; keepGoing; ) {

            System.out.print("\n>>");
            String textIn = userInput.nextLine();
            if (textIn.equals("q")) {
                return;
            }
            processCommand.runCommand(textIn);
        }
    }

}
