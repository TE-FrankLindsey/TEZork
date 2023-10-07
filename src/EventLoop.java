
import ParseGroup.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

        for (boolean keepGoing=true; keepGoing; ) {

            System.out.println("??!");
            String textIn = userInput.nextLine();
            System.out.printf(">>%s<<\n", textIn);
            if (textIn.equals("q")) {
//                System.out.printf(">>%s<<\n", textIn);
                return;
            }
            parser.parseText(textIn);

        }
    }

}
