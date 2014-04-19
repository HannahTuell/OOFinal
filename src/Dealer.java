import java.util.Scanner;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class Dealer {

  private Game game_;
  private Deck deck_;
  private Player board_;
  private Player user_;
  private Player partner_;
  private Player ai1_;
  private Player ai2_;

  /**
   * Constructor
   */
  public Dealer( ) {
    board_   = new Player( "Board" );
    partner_ = new Player( "Wallace" );
    ai1_     = new Player( "Scott" );
    ai2_     = new Player( "Ramona" );

    System.out.println( partner_.name() + " has joined the game. This is your partner.");
    System.out.println( ai1_.name() + " has joined the game. This is your opponent");
    System.out.println( ai2_.name() + " has joined the game. This is your opponent");
  }

  /**
   * Register the User
   * @param user
   */
  public void user( Player user ) {
    user_ = user;
    System.out.println("Welcome " + user_.name() + "! You have joined the game.");
  }

  public void game( Game game ) {
    game_ = game;
    deck_ = game_.deck();
    System.out.println( "You've chosen to play, \"" + game_.title()+"\""  );
  }

  /**
   * Play the game specified by the game_ attribute
   */
  public void play() {
    deal_round();
    print();
  }

  /**
   * Deal the round
   */
  public void deal_round() {
    deck_.combine();
    for (int i = 0; i < game_.deal_number(); ++i ) {
      user_.take_card( deck_.draw() );
      ai1_.take_card( deck_.draw() );
      partner_.take_card( deck_.draw() );
      ai2_.take_card( deck_.draw() );
    }
    Card trump = deck_.draw();
    game_.trump( trump.suit() );
    deck_.discard( trump );
  }

  /**
   * Print the current state of the game
   */
  public void print() {
    if ( game_.trump() != Suit.JOKERS ) {
      System.out.println( "The trump is: " + game_.trump() );
    }

    deck_.print();
    board_.print();
    user_.print();
    ai1_.print();
    partner_.print();
    ai2_.print();
  }
}