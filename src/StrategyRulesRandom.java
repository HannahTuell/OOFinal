import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class StrategyRulesRandom implements Strategy {

    private Random randy_;

    public StrategyRulesRandom( ) {
        randy_ = new Random();
    }

    public Integer pick_card( List<Card> hand, Suit trump, Suit round ) {
        Integer index;
        if ( trump != null ) {
            List<Card> options = is_suit(hand, trump);
            index = randy_.nextInt( options.size() );
            return hand.indexOf( options.get(index) );
        }
        if ( round != null ) {
            List<Card> options = is_suit(hand, round);
            index = randy_.nextInt( options.size() );
            return hand.indexOf( options.get(index) );
        }
        return randy_.nextInt( hand.size() );
    }

    /**
     * Creates a list of all the cards in belonging to the suit in question
     * @param input The list of cards
     * @param suit The suit to search for
     * @return Only cards belonging to that suit are held within
     */
    private List<Card> is_suit( List<Card> input, Suit suit ) {
        List<Card> is_suit = new LinkedList<Card>();
        for ( Card card : input ) {
            if ( card.suit() == suit){
                is_suit.add(card);
            }
        }
        return is_suit;
    }
}
