import java.util.List;
import java.util.Scanner;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class StrategyHuman implements Strategy {

    public Integer pick_card( List<Card> hand, Suit trump, Suit round ) {
        Integer index;
//        print( hand );
        Scanner console = new Scanner(System.in);
        System.out.print("Card Choice? [0-"+new Integer(hand.size()-1).toString()+"]: ");
        index = console.nextInt();

        return index;
    }

    private void print( List<Card> hand ) {
        System.out.print("Your Hand: ");
        for ( Card c : hand )
            System.out.print(c.toString() + ", ");
        System.out.print("\n");
    }
}
