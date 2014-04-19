/**
 * Created by pevargas90 on 4/18/14.
 */
public abstract class Game {

    protected Integer decks_;
    protected Boolean has_jokers_;
    protected Integer deal_number_;
    protected Suit    trumps_;

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

    public abstract Deck deck();
}
