/**
 * Created by pevargas90 on 4/19/14.
 */
public class Dealer {

  private Game   game_;
  private Deck   deck_;
  private Player user_;
  private Player partner_;
  private Player ai1_;
  private Player ai2_;

  /**
   * Constructor
   */
  public Dealer( ) {
      partner_ = new Player( "Wallace" );
      ai1_     = new Player( "Scott" );
      ai2_     = new Player( "Ramona" );

      partner_.strategy(new StrategyRulesRandom());
      ai1_.strategy(new StrategyRandom());
      ai2_.strategy(new StrategyRandom());
  }

  /**
   * Register the User
   * @param user
   */
  public void user( Player user ) {
      user_ = user;
      user_.strategy(new StrategyHuman());
      game_.register_player(user_.name());
  }

    /**
     * Set the game to be used
     * @param game The game
     */
  public void game( Game game ) {
      game_ = game;
      deck_ = game_.deck();
      System.out.println( "You've chosen to play, \"" + game_.title()+"\""  );
      game_.register_player(partner_.name());
      game_.register_player(ai1_.name());
      game_.register_player(ai2_.name());
  }

  /**
   * Play the game specified by the game_ attribute
   */
  public void play() {

      while( !game_.is_game_win() ) {

          if ( partner_.cards_in_hand() == 0 ) {
              deal_round();
          }

          Suit round = null;
          Submission temp;
          game_.take_card( (temp = ai1_.pick_card(game_.trump(), round) ));
          round = temp.card.suit();
          game_.take_card(partner_.pick_card(game_.trump(), round));
          game_.take_card(ai2_.pick_card(game_.trump(), round));

          print();
          game_.take_card(user_.pick_card(game_.trump(), round));
          game_.pick_winner();

          game_.clear_hand(deck_);
      }
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
      deck_.discard(trump);
  }

  /**
   * Print the current state of the game
   */
  public void print() {
      if ( game_.trump() != Suit.JOKERS ) {
          System.out.println( "The trump is: " + game_.trump() );
      }

      deck_.print();
      game_.print();
      ai1_.print();
      partner_.print();
      ai2_.print();
      user_.print();
  }
}