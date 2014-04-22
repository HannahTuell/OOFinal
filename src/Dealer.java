import java.util.ArrayList;
import java.util.List;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class Dealer {

  private Game   game_;
  private Deck   deck_;
  private List<Player> players_;

  /**
   * Constructor
   */
  public Dealer( ) {
      players_ = new ArrayList<Player>();
  }

  /**
   * Register the User
   * @param user
   */
  public void user( Player user ) {
      user.strategy( new StrategyHuman() );
      game_.register_player( user.name() );
      players_.add( user );
  }

  /**
   * Set the game to be used
   * @param game The game
   */
  public void game( Game game ) {
      game_ = game;
      deck_ = game_.deck();
      System.out.println( "You've chosen to play, \"" + game_.title()+"\""  );
      players_ = game_.get_opponents();
  }

  /**
   * Play the game specified by the game_ attribute
   */
  public void play() {
      while( !game_.is_game_win() ) {
          deal_round();

          Suit round = null;
          Submission temp;
          for ( Player player : players_ ) {
              if ( player.is_human() ) {
                  print();
              }
              // Player will draw a card from the draw pile
              if ( game_.turn_.draw() ) {
                  player.take_card( deck_.draw() );
              }
              // Player will pick a card to play
              if ( game_.turn_.play() ) {
                  temp = player.pick_card(game_.trump(), round);
                  if (round == null) {
                      round = temp.card.suit();
                  }
                  game_.take_card(temp);
              }
              // Player will discard a card
              if ( game_.turn_.discard() ) {
                  // Discard a card
              }

          }

          String winner;

          do {
              winner = game_.pick_winner();
              if (winner == null) {
                  for (int i = 0; i < 3; i++) {
                      for (Player player : players_) {
                          game_.take_card(player.pick_card(null, null));
                      }
                  }
              }
          } while( winner == null );

          // If the game requires the cards on the board be given to the winner of the round
          if ( game_.turn_.collect() ) {
              for(Player player : players_) {
                  if ( player.name() == winner) {
                      for ( Card card : game_.collect_hand()) {
                          player.take_card( card );
                      }
                  }
              }
          }
          else {
              game_.clear_hand(deck_);
          }

      }
  }

  /**
   * Deal the round
   */
  public void deal_round() {
      if ( players_.get(0).cards_in_hand() == 0 ) {
          deck_.combine();
          for (int i = 0; i < game_.deal_number(); ++i ) {
              for (Player player : players_) {
                  player.take_card(deck_.draw());
              }
          }
          if ( game_.turn_.trump() ) {
              if ( deck_.cards_left() > 0 ) {
                  Card trump = deck_.draw();
                  game_.trump(trump.suit());
                  deck_.discard(trump);
              }
          }
      }

  }

  /**
   * Print the current state of the game
   */
  public void print() {
      deck_.print();
      game_.print();

      if ( game_.turn_.trump() ) {
          System.out.println( "The trump is: " + game_.trump() );
          System.out.println( "The round is: " + game_.round() );
      }

      //for ( Player player : players_ )
        //player.print();
      Screen.GetCurrentState().Print(players_);
  }
}