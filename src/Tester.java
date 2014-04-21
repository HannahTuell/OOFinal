import java.io.Console;
import java.util.Scanner;

/**
 * Created by pevargas90 on 4/18/14.
 */

public class Tester {

    public static void main( String[] args ) {
        Screen sc = new Screen();
        
        Scanner console = new Scanner(System.in);
//        Console console = System.console();
        Dealer joe = new Dealer( );
        Game game;
        System.out.println("Available Games");
        System.out.println("\t0: Euchre");
        System.out.println("\t1: War");
//        String selection = console.readLine("Please Pick a Game: ");
        System.out.print("Please Pick a Game: ");
        String selection = console.next();
        if ( selection.matches("1") ) { game = new War();    }
        else                          { game = new Euchre(); }
        joe.game(game);

//        console.flush();
//        String name = console.readLine("\nWhat is your name? ");
        System.out.print("\nWhat is your name? ");
        String name = console.next();

        joe.user( new Player( name ) );
        joe.play();
    }

}
