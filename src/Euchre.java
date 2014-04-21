import sun.print.SunMinMaxPage;

import java.util.ArrayList;
import java.util.LinkedList;
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
                5,        // Deal Number
                10        // Winning game score
        );
    }

    /**
     * Gives the Game specific deck of cards
     * @return Game specific deck
     */
    @Override
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
                    if ( i == 1 ) result.add(new Card(14, temp));
                    else          result.add(new Card((i % 13) + 1, temp));
                    break;
            }
        }

        deck.draw( result );
        deck.size( size );

        return deck;
    }

    /**
     * Analyze who won the round
     * @return
     */
    @Override
    public String analyze_round( List<Submission> list ) {
        if ( list.isEmpty() ) return null;

        List<Submission> trumps = is_suit(list, trump());
        if (trumps.size() == 1) {
            return trumps.get(0).who;
        }
        if ( !trumps.isEmpty() ) {
            return is_rankier(trumps).who;
        }

        List<Submission> round = is_suit(list, list.get(0).card.suit());
        if (round.size() == 1) {
            return round.get(0).who;
        }
        if ( !round.isEmpty() ) {
            return is_rankier(round).who;
        }

        return null;
    }

    /**
     * Creates a list of all the cards in belonging to the suit in question
     * @param input The list of cards
     * @param suit The suit to search for
     * @return Only cards belonging to that suit are held within
     */
    private List<Submission> is_suit( List<Submission> input, Suit suit ) {
        List<Submission> is_suit = new LinkedList<Submission>();
        for ( Submission s : input ) {
            if ( s.card.suit() == suit){
                is_suit.add(s);
            }
        }
        return is_suit;
    }

    /**
     * In a list of cards with all the same rank, choose the highest card.
     * @param input List of cards with all the same rank
     * @return The card with the highest rank
     */
    private Submission is_rankier( List<Submission> input ) {
        if ( input.isEmpty() ) return null;
        Submission winner = null;

        for ( Submission s : input ) {
            if ( winner == null ) {
                winner = s;
            }
            else {
                if ( s.card.rank() > winner.card.rank() ) {
                    winner = s;
                }
            }
        }

        return winner;
    }
}
