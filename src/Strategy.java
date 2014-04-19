import java.util.List;

/**
 * Created by pevargas90 on 4/19/14.
 */
public interface Strategy {
    public Integer pick_card( List<Card> hand, Suit trump, Suit round );
}
