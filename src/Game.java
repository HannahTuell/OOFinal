import java.util.*;

/**
 * Created by pevargas90 on 4/18/14.
 */
public abstract class Game {

    private String      title_;
    private Integer     decks_;
    private Boolean     has_jokers_;
    private Integer     deal_number_;
    private Suit        trumps_;
    private Integer     init_score_;
    private Integer     winning_score_;
    private Integer     number_of_players_; // Including User
    private Strategy    ai_strategy_;
    private List<Submission>       board_;
    protected Map<String, Integer> score;
    public TurnPattern turn_;

    /**
     * Constructor
     */
    public Game(String name, int players_, Strategy strategy, int decks, boolean has_jokers, int deal_number, int init_score, int winning_score) {
        score              = new HashMap<String, Integer>();
        board_             = new LinkedList<Submission>();
        title_             = name;
        number_of_players_ = players_;
        ai_strategy_       = strategy;
        decks_             = decks;
        has_jokers_        = has_jokers;
        deal_number_       = deal_number;
        init_score_        = init_score;
        winning_score_     = winning_score;
        trumps_            = Suit.JOKERS;
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
     * Return the current round suit
     * @return The Suit
     * @see Suit
     */
    public Suit round() {
        return board_.get(0).card.suit();
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
        score.put(player, init_score_);
        System.out.println( player + " has joined the game.");
    }

    /**
     * Create the number of opponents needed for game.
     * @return A List of opponents
     */
    public List<Player> get_opponents( ) {
        String names[] = { "Wallace", "Ramona", "Scott", "Pam", "Bob", "Linda", "Greg", "Belidna", "Other Scott" };
        List<Player> opponents = new ArrayList<Player>();

        for (int i = 0; i < number_of_players_ - 1; ++i ) {
            Player temp = new Player( names[ i % names.length ] );
            temp.strategy( ai_strategy_ );
            opponents.add( temp );
            register_player( temp.name() );
        }

        return opponents;
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
     * @return The name of the winner
     */
    public String pick_winner() {
        String winner = analyze_round( board_ );
        score.put(winner, score.get(winner) + 1 );
        System.out.println(winner + " won that round");
        print_scores();
        return winner;
    }

    /**
     * Determine if someone has won
     * @return True or False
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
     * Get the cards from the board
     * @return All the cards from the board
     */
    public List<Card> collect_hand() {
        List<Card> temp = new ArrayList<Card>();
        for (Submission submission : board_) {
            temp.add( submission.card);
        }
        board_.clear();
        return temp;
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

    /**
     * Print the current scores
     */
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
