import java.util.LinkedList;
import java.util.List;

/**
 * Created by pevargas90 on 4/18/14.
 *
 * Provides a basic player class for use in a card game program or simulation.
 */
public abstract class Player {

    private List<Card> hand_;
    private String     name_;

    /**
     * Constructor
     * An anonymous player has been created
     */
    public Player() {
        name_ = "Anon";
        hand_ = new LinkedList<Card>();
    }

    /**
     * Constructor
     * @param name The name of the player
     */
    public Player( String name ) {
        name_ = name;
        hand_ = new LinkedList<Card>();
    }

    /**
     * Get the player's name
     * @return The name of the player
     */
    public String name() { return name_; }

    /**
     * The player took a card
     * @param c The card to take
     */
    public void take_card( Card c ) {
        hand_.add( c );
    }

    /**
     * Get the number of cards a player has
     * @return Number of cards the player is holding
     */
    public int cards_in_hand() { return hand_.size(); }

    /**
     * The player's hand has been added to the discard pile
     * @param d The deck in play
     */
    public void clear_hand( Deck d ) {
        for( Card c : hand_ ) {
            d.discard( c );
        }

        hand_.clear();
    }

    /**
     * Print the state of the player's hand
    */
    public void print() {
        System.out.print(name_ + "'s Hand: ");
        if ( hand_.isEmpty() )
            System.out.print("No Cards Available");
        else
            for ( Card c : hand_ )
                System.out.print(c.toString() + ", ");
        System.out.print("\n");
    }

    /**
     * Pick a card to play. Instantiated for AI players and Users
     * @return
     */
    public abstract Card pick_card();
}
