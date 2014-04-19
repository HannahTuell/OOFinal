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
    protected Map<String, Integer> score;

    /**
     * Constructor
     */
    public Game(String name, int decks, boolean has_jokers, int deal_number) {
        score        = new HashMap<String, Integer>();
        title_       = name;
        decks_       = decks;
        has_jokers_  = has_jokers;
        deal_number_ = deal_number;
        trumps_      = Suit.JOKERS;
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
    public void reigister_player( String player ) {
        score.put(player, 0);
    }

    /**
     * Gives the Game specific deck of cards
     * @return Game specific deck
     */
    public abstract Deck deck();
}
