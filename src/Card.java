/**
 * Created by pevargas90 on 4/18/14.
 *
 * Provides a basic card class for use in a card game program or simulation.
 */
public class Card {
    private int     rank_;
    private Suit    suit_;
    private int     value_;
    private boolean is_face_up_;

    /**
     * Constructor
     */
    public Card () {
        rank_       = 1;
        suit_       = Suit.SPADES;
        value_      = 0;
        is_face_up_ = false;
    }

    /**
     * Constructor
     *
     * @param rank The Initial Rank
     * @param suit The Initial Suit
     */
    public Card (int rank, Suit suit) {
        rank_       = rank;
        suit_       = suit;
        value_      = 0;
        is_face_up_ = false;
    }

    /**
     * Constructor
     *
     * @param rank The Initial Rank
     * @param suit The Initial Suit
     * @param value The Initial Value
     */
    public Card (int rank, Suit suit, int value) {
        rank_       = rank;
        suit_       = suit;
        value_      = value;
        is_face_up_ = false;
    }

    /**
     * Gets the rank
     * @return The rank has been returned.
     */
    public int rank() {
        return rank_;
    }

    /**
     * Sets the rank
     * @param rank The rank value
     */
    public void rank(short rank) {
        rank_ = rank;
    }

    /**
     * Gets the suit
     * @return The suit has been returned
     * @see Suit
     */
    public Suit suit() {
        return suit_;
    }

    /**
     * Sets the suit
     * @param suit The suit value
     * @see Suit
     */
    public void suit(Suit suit) {
        suit_ = suit;
    }

    /**
     * Gets the value
     * @return The value has been returned
     */
    public int value() {
        return value_;
    }

    /**
     * Sets the value
     * @param value The value value
     */
    public void value(short value) {
        value_ = value;
    }

    /**
     * Gets the is face up boolean
     * @return Returns if the card is face up or not
     */
    public boolean is_face_up() {
        return is_face_up_;
    }

    /**
     * Sets the face up value
     * @param is_face_up True or False
     */
    public void is_face_up(boolean is_face_up) {
        is_face_up_ = is_face_up;
    }

    /**
     * Flips the card over
     */
    public void flip() {
        is_face_up_ = !is_face_up_;
    }
}
