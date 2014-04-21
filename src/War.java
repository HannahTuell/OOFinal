import java.util.List;
import java.util.Map;

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
<<<<<<< HEAD
                1,       // Number of Decks
                false,   // Has Jokers
                26,       // Deal Number: 2 Players, half the deck each
                3
=======
                2,     // Number of Players including user
                new StrategyPickFirst(), // The strategy for the AI players
                1,     // Number of Decks
                false, // Has Jokers
                26,    // Deal Number: 2 Players, half the deck each
                26,    // Init Score
                0      // Winning Score
        );
        // Set Turn structure of the game
        turn_ = new TurnPattern(
                false, // If players need to draw
                true,  // If players need to play a card
                false, // If players need to discard a card
                true, // If players need to collect cards
                false   // If players need a trump to play by
>>>>>>> 5c62be3f17a714069a1cc257ddddaa8705826949
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
     * @return The name of the player who won
     */
    @Override
    public String analyze_round( List<Submission> list ) {
        if ( list.isEmpty() ) return null;

        Submission p1 = list.get(0);
        Submission p2 = list.get(1);

        Integer p1Rank = p1.card.rank();
        Integer p2Rank = p2.card.rank();

        if (p1Rank > p2Rank) {

            return p1.who;
        }
        else {
            return p2.who;
        }

//        if (p1Rank < p2Rank) {
//            return p2.who;
//        }

//        if (p1Rank == p2Rank) {
//            return null;
//        }

        return null;
    }

    /**
     * Pick the winner and display them
     * @return The name of the winner
     */
    @Override
    public String pick_winner() {
        String winner = super.pick_winner();
        for ( Map.Entry<String, Integer> entry : score.entrySet() ) {
            if ( entry.getKey() != winner )
                score.put(entry.getKey(), entry.getValue() - 1 );
        }
        return winner;
    }

    /**
     * Determine if someone has won
     * @return True or False
     */
    @Override
    public Boolean is_game_win() {
        for ( Map.Entry<String, Integer> entry : score.entrySet())
            if ( entry.getValue() == 0) return true;
        return false;
    }
}
