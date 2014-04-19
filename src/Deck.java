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
    private boolean    has_jokers_; // If jokers are in play
    private int        size_;      // Total number of cards in play

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
     * Constructor
     * @param number_of_decks This is the number of full decks to add
     * @param has_jokers Boolean if Jokers are needed
     */
    public Deck (int number_of_decks, boolean has_jokers) {
        has_jokers_ = has_jokers;
        size_       = number_of_decks;
        determine_size();
        factory_order();
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
    public int cards_left() { return draw_.size(); }

    /**
     * Adds the card given to the discard pile
     * @param garbage The card to discard
     */
    public void discard( Card garbage ) { discard_.add(garbage); }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        List<Card> temp = new LinkedList<Card>();

        while ( !draw_.isEmpty() ) {
            Random r = new Random();
            temp.add( draw_.get(r.nextInt() % draw_.size()) );
            draw_.remove( r );
        }

        draw_ = new LinkedList<Card>(temp);
    }

    /**
     * Combines the discard and draw pile
     */
    public void combine() {
        // Check if there are any cards in the discard pile
        if ( discard_.isEmpty() ) return;

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
}
