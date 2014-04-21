import java.util.Scanner;

/**
 * Created by pevargas90 on 4/18/14.
 */

public class Tester {

<<<<<<< HEAD

    public static void main(String[] args) {
        //System.out.println("Suprise Bitch");
        Screen sc = new Screen();
=======
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
>>>>>>> bc226859088d67abfdf3aa6449c72e907b77da01
    }

}
