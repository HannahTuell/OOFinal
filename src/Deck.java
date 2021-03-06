import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by pevargas90 on 4/18/14.
 * Provides a basic deck class for use in a card game program or simulation.
 */
public class Deck {
    private List<Card> draw_;      // Draw Pile
    private List<Card> discard_;   // Discard Pile
    private Boolean    has_jokers_; // If jokers are in play
    private Integer    size_;      // Total number of cards in play

    /**
     * Constructor
     */
    public Deck () {
        has_jokers_ = false;
        size_       = 1;
        draw_       = new LinkedList<Card>();
        discard_    = new LinkedList<Card>();
        determine_size();
        factory_order();
    }

    /**
     * Copy Constructor
     * @param other The other deck to copy
     */
    public Deck ( Deck other ) {
        has_jokers_ = new Boolean(other.has_jokers());
        size_       = new Integer(other.size());
        draw_       = new ArrayList<Card>(other.draw_pile());
        discard_    = new ArrayList<Card>(other.discard_pile());
    }

    /**
     * Constructor
     * @param number_of_decks This is the number of full decks to add
     * @param has_jokers Boolean if Jokers are needed
     */
    public Deck (int number_of_decks, boolean has_jokers) {
        has_jokers_ = has_jokers;
        size_       = number_of_decks;
        draw_       = new LinkedList<Card>();
        discard_    = new LinkedList<Card>();
        determine_size();
        factory_order();
    }

    /**
     * Set the draw deck with the one passed in.
     * @param deck The new deck to be used.
     */
    public void draw( List<Card> deck ) {
        draw_.clear();
        discard_.clear();
        draw_       = new LinkedList<Card>( deck );
    }

    /**
     * Get the draw deck
     * @return The Draw Deck
     */
    public List<Card> draw_pile() {
        return draw_;
    }

  /**
   * Get the discard pile
   * @return The discard pile
   */
    public List<Card> discard_pile() {
        return discard_;
    }

    /**
     * Sets the size of the deck;
     * @param size Number of cards
     */
    public void size( Integer size ) {
        size_ = size;
    }

    /**
     * Gets the total number of cards in deck
     * @return Number of cards
     */
    public Integer size( ) {
        return size_;
    }

    /**
     * Does the deck contain jokers?
     * @return True or False
     */
    public Boolean has_jokers() {
        return has_jokers_;
    }

    /**
     * Determines the number of cards to create
     */
    private void determine_size() {
        if (has_jokers_) { size_ = size_  * 54; }
        else { size_ = size_ * 52; }
    }

    /**
     * Sets the factory order of the draw deck
     */
    public void factory_order() {
        draw_.clear();
        discard_.clear();
        int deck_size = 52;
        if (has_jokers_) deck_size = 54;
        for (int i = 0; i < size_; ++i) {
            Suit temp;
            if      (i % deck_size < 13) { temp = Suit.SPADES;   }
            else if (i % deck_size < 26) { temp = Suit.DIAMONDS; }
            else if (i % deck_size < 39) { temp = Suit.CLUBS;    }
            else if (i % deck_size < 52) { temp = Suit.HEARTS;   }
            else                         { temp = Suit.JOKERS;   }

            draw_.add( new Card( (i % 13) + 1, temp ) );
        }
    }

    /**
     * Gets teh number of cards left in the draw pile
     * @return Number of cards left
     */
    public Integer cards_left() { return draw_.size(); }

    /**
     * Adds the card given to the discard pile
     * @param garbage The card to discard
     */
    public void discard( Card garbage ) { discard_.add(garbage); }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        System.out.println("Shuffling Deck");

        List<Card> temp = new LinkedList<Card>();
        Random r = new Random();
        int index;

        while ( !draw_.isEmpty() ) {
            index = r.nextInt( draw_.size() );
            temp.add( draw_.get( index ) );
            draw_.remove( index );
        }

        draw_ = new LinkedList<Card>(temp);
    }

    /**
     * Combines the discard and draw pile
     */
    public void combine() {
        System.out.println("Combining Decks");

        for( Card c : discard_ ) {
            draw_.add(c);
        }

        discard_.clear();

        // Shuffle the new deck;
        shuffle();
    }

    /**
     * Draw a card from the deal pile
     * @return The top most card has been add to the deck
     */
    public Card draw() {
        Card temp;

        // Make sure there are cards available
        if ( draw_.isEmpty() ) combine();

        temp = draw_.get(0);
        draw_.remove(0);
        return temp;
    }

    /**
     * Print the state of the deck
     */
    public void print() {
        System.out.println("*** Draw Deck ***");
        if ( draw_.isEmpty() )
            System.out.print("No Cards Available");
        else
            for ( Card c : draw_ )
                System.out.print(c.toString() + ", ");
        System.out.println("\n*** Discard Deck *** ");
        if ( discard_.isEmpty() )
            System.out.print("No Cards Available");
        else
            for ( Card c : discard_ )
                System.out.print(c.toString() + ", ");
        System.out.print("\n");
    }
}
