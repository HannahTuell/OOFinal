import java.util.ArrayList;
import java.util.List;

/**
 * Created by pevargas90 on 4/18/14.
 */
public class Euchre extends Game {

    /**
     * Constructor
     */
    public Euchre() {
        super(
                "Euchre", // Name of Game
                1,        // Number of Decks
                false,    // Has Jokers
                5         // Deal Number
        );
    }

    /**
     * Gives the Game specific deck of cards
     * @return Game specific deck
     */
    public Deck deck() {
        List<Card> result = new ArrayList<Card>();
        Deck deck = new Deck( decks(), has_jokers() );
        Integer size = 0;
        Integer deck_size = deck.size();

        for (int i = 0; i < deck_size; ++i) {
            Suit temp;
            if      (i % deck_size < 13) { temp = Suit.SPADES;   }
            else if (i % deck_size < 26) { temp = Suit.DIAMONDS; }
            else if (i % deck_size < 39) { temp = Suit.CLUBS;    }
            else if (i % deck_size < 52) { temp = Suit.HEARTS;   }
            else                         { temp = Suit.JOKERS;   }

            switch( (i % 13) + 1) {
                case 1:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    size++;
                    result.add(new Card((i % 13) + 1, temp));
                    break;
            }
        }

        deck.draw( result );
        deck.size( size );

        return deck;
    }


}
