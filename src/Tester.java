import java.util.Scanner;

/**
 * Created by pevargas90 on 4/18/14.
 */

public class Tester {
    public static void main( String[] args ) {
      Game game = new Euchre();
      Dealer joe = new Dealer( );
      joe.game( game );
      Scanner console = new Scanner(System.in);

      System.out.print("What is your name? ");
      System.out.flush();
      String input = console.nextLine();
      joe.user( new Player( input ) );

      joe.play();
    }

}
