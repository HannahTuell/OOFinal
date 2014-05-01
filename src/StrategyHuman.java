import java.util.List;
import java.util.Scanner;

/**
 * Created by pevargas90 on 4/19/14.
 */
public class StrategyHuman implements Strategy {

    public Integer pick_card( List<Card> hand, Suit trump, Suit round ) {
        //This is where everything on the screen gets drawn in at.
//        Screen.GetCurrentState().Print(Screen.GetDealer().GetPlayers());
        Integer index;
//        print( hand );
        Scanner console = new Scanner(System.in);

        //This is where I have my pick card and the currentstate will be the EuchreGameScreen.java so you can just
        //look there to see what will happen next.

//        index = Screen.currentState.PickCard();
        System.out.print("Card Choice? [0-"+new Integer(hand.size()-1).toString()+"]: ");
        index = console.nextInt();

        //If you want to see what the screen should look like set the to 0 or whatever and comment out my
        //index = ... line
        return index;

    }

    private void print( List<Card> hand ) {
        System.out.print("Your Hand: ");
        for ( Card c : hand )
            System.out.print(c.toString() + ", ");
        System.out.print("\n");
    }
}
