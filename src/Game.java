import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pevargas90 on 4/18/14.
 */
public abstract class Game {

    private String  title_;
    private Integer decks_;
    private Boolean has_jokers_;
    private Integer deal_number_;
    private Suit    trumps_;
    private Integer winning_score_;
    private List<Submission>       board_;
    protected Map<String, Integer> score;

    /**
     * Constructor
     */
    public Game(String name, int decks, boolean has_jokers, int deal_number, int winning_score) {
        score          = new HashMap<String, Integer>();
        board_         = new LinkedList<Submission>();
        title_         = name;
        decks_         = decks;
        has_jokers_    = has_jokers;
        deal_number_   = deal_number;
        winning_score_ = winning_score;
        trumps_        = Suit.JOKERS;
    }

    /**
     * Get the number of decks needed
     * @return The number of compete decks needed
     */
    public Integer decks() {
        return decks_;
    }

    /**
     * Get if Jokers are needed to the game
     * @return Has jokers or not
     */
    public Boolean has_jokers() {
        return has_jokers_;
    }

    /**
     * Get the number of cards to deal to each player per hand
     * @return The number of cards each player should have at start of round
     */
    public Integer deal_number( ) {
        return deal_number_;
    }

    /**
     * Get the trump for this round
     * @return The trump
     * @see Suit
     */
    public Suit trump() {
        return trumps_;
    }

    /**
     * Set the trump for the round
     * @param s The trump to be set as
     * @see Suit
     */
    public void trump ( Suit s ) {
        trumps_ = s;
    }

    /**
     * Get the name of the game.
     * @return The name of the game
     */
    public String title () {
      return title_;
    }

    /**
     * Add player to game
     * @param player
     */
    public void register_player(String player) {
        score.put(player, 0);
        System.out.println( player + " has joined the game.");
    }

    /**
     * Take Cards from players
     * @param sub A submission object
     */
    public void take_card( Submission sub ) {
        board_.add(sub);
    }

    /**
     * Pick the winner and display them
     */
    public void pick_winner() {
        String winner = analyze_round( board_ );
        score.put(winner, score.get(winner) + 1 );
        System.out.println(winner + " won that round");
        print_scores();
    }

    /**
     * Determine if someone has reached the score level.
     * @return
     */
    public Boolean is_game_win() {
        for ( Map.Entry<String, Integer> entry : score.entrySet())
            if ( entry.getValue() >= winning_score_) return true;
        return false;
    }

    /**
     * The player's hand has been added to the discard pile
     * @param deck The deck in play
     */
    public void clear_hand( Deck deck ) {
        for( Submission s : board_ ) {
            deck.discard( s.card );
        }

        board_.clear();
    }

    /**
     * Print the state of the board
     */
    public void print() {
        System.out.println("*** The Game Board ***");
        if ( board_.isEmpty() )
            System.out.print("No Cards Available");
        else
            for ( Submission s : board_ )
                System.out.print("["+s.who + ":" + s.card.toString() +"]");
        System.out.print("\n");
    }

    public void print_scores() {
        System.out.println("============ Scores ============");
        for (Map.Entry<String, Integer> user : score.entrySet())
            System.out.print("["+user.getKey() + ":" + user.getValue()+"]");
        System.out.print("\n");
    }

    /**
     * Gives the Game specific deck of cards
     * @return Game specific deck
     */
    public abstract Deck deck();

    /**
     * Analyze who one the round
     * @return Name of player
     */
    public abstract String analyze_round( List<Submission> list );
}
