import java.io.Console;
import java.util.Scanner;

/**
 * Created by pevargas90 on 4/18/14.
 */

public class Tester {

    public static void main( String[] args ) {
        Scanner console = new Scanner(System.in);
        System.out.println("Suprise Bitch");

        System.out.print("What is your name? ");
        System.out.flush();
        String input = console.nextLine();
        Player user = new Player(input);
        System.out.println("Welcome " + user.name());

        Game game = new Euchre();
        Deck bicycle = new Deck( game.deck() );
        System.out.println("Shuffling Deck");
        bicycle.shuffle();
        for (int i = 0; i < 5; ++i )
            user.take_card( bicycle.draw() );

        bicycle.print();
        user.print();

        System.out.println("Returning cards to deck");
        user.clear_hand( bicycle );

        bicycle.print();
        user.print();

        System.out.println("Combining Discard");
        bicycle.combine();

        bicycle.print();
        user.print();
    }
}
