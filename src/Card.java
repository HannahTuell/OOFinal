/**
 * Created by pevargas90 on 4/18/14.
 *
 * Provides a basic card class for use in a card game program or simulation.
 */
public class Card {
    private Integer rank_;
    private Suit    suit_;
    private Integer value_;
    private Boolean is_face_up_;

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
    public void rank(int rank) {
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
    public void value(int value) {
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

    /**
     * Converts card to string representation
     * @return String of information
     */
    public String toString() {
        String temp;

        switch ( rank_ ) {
            case 14: temp = "O"; break;
            case 13: temp = "K"; break;
            case 12: temp = "Q"; break;
            case 11: temp = "J"; break;
            case 1:  temp = "A"; break;
            default: temp = rank_.toString(); break;
        }
        switch ( suit_ ) {
            case SPADES:   temp += "S"; break;
            case DIAMONDS: temp += "D"; break;
            case CLUBS:    temp += "C"; break;
            case HEARTS:   temp += "H"; break;
            case JOKERS:   temp += "J"; break;
            default:       temp += "O"; break;
        }

        return temp;
    }

    /**
     * Prints to command line
     */
    public void print() {
        String temp;
        switch ( rank_ ) {
            case 14: temp = "Joker"; break;
            case 13: temp = "King"; break;
            case 12: temp = "Queen"; break;
            case 11: temp = "Jack"; break;
            case 1:  temp = "Ace"; break;
            default: temp = rank_.toString(); break;
        }
        System.out.print(temp + " of ");

        switch ( suit_ ) {
            case SPADES:   temp = "Spades"; break;
            case DIAMONDS: temp = "Diamonds"; break;
            case CLUBS:    temp = "Clubs"; break;
            case HEARTS:   temp = "Hearts"; break;
            case JOKERS:   temp = "Jokers"; break;
            default:       temp = "Other"; break;
        }
        System.out.println(temp);
    }
}
