import java.util.List;

/**
 * Created by hannahtuell on 4/19/14.
 *
 * Implements a specific game of War
 */
public class War extends Game {


    /**
     * Constructor
     */
    public War() {
        super(
                "War", // Name of Game
                1,     // Number of Decks
                false, // Has Jokers
                26,    // Deal Number: 2 Players, half the deck each
                0      // Winning Score
        );
    }

    /**
     * Gives the Game specific deck of cards
     * @return Game specific deck
     */
    @Override
    public Deck deck() {
        // builds a new deck with the number of decks specified and whether or not we want jokers
        Deck deck = new Deck( decks(), has_jokers() );
        return deck;
    }

    /**
     * Analyze who won the round
     * @return winner's name
     */
    @Override
    public String analyze_round( List<Submission> list ) {
        if ( list.isEmpty() ) return null;

        Submission p1 = list.get(0);
        Submission p2 = list.get(1);

        Integer p1Rank = p1.card.rank();
        Integer p2Rank = p2.card.rank();

        if (p1Rank > p2Rank) {

            return p1.who + " wins this round!";
        }

        if (p1Rank < p2Rank) {
            return p2.who + " wins this round!";
        }

        if (p1Rank == p2Rank) {

            return "This round was a tie -- War!";
        }

        return null;
    }
}
