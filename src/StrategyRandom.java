import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class StrategyRandom implements Strategy {

    private Random randy_;

    public StrategyRandom( ) {
        randy_ = new Random();
    }

    public Integer pick_card( List<Card> hand, Suit trump, Suit round ) {
        return randy_.nextInt( hand.size() );
    }
}
