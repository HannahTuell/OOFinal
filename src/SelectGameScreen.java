import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by justinwoodward on 4/21/14.
 */
public class SelectGameScreen implements ScreenState, ActionListener {
    JFrame frame;
    JPanel panel;
    Screen screen;
    JLabel emptyLabel;

    public SelectGameScreen(Screen theScreen){
        screen = theScreen;
        //1. Create the frame.
        frame = new JFrame("Select a Game");
        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        panel = new JPanel();
        panel.setSize(20,20);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.setSize(400,400);
        //frame.pack();

        //3. Create components and put them in the frame.
        emptyLabel = new JLabel("Select a Game to Play " + screen.GetName());
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        panel.add(emptyLabel, BorderLayout.NORTH);
        JButton euchreButton = Creater.CreateButton("Play Euchre", "Euchre");
        euchreButton.addActionListener(this);
        panel.add(euchreButton, BorderLayout.CENTER);
        JButton otherGame = Creater.CreateButton("Play War", "war");
        otherGame.addActionListener(this);
        panel.add(otherGame, BorderLayout.CENTER);
    }

    public void DrawScreen(){
        emptyLabel.setText("Select a Game to Play " + screen.GetName());
        frame.setVisible(true);
    }

    public void HideScreen(){
        frame.setVisible(false);
    }

    public void Print(java.util.List<Player> players){

    }

    public void DrawCard(){

    }

    public Integer PickCard(){
        return 0;
    }

    public void DiscardCard(){

    }

    public Screen getScreen() { return screen; }

    public void actionPerformed(ActionEvent e) {
//        Game game;
        if ("Euchre".equals(e.getActionCommand())) {
            screen.set_game(new Euchre());
            screen.SetCurrentState(new EuchreGameScreen(screen));
        }
        else if("war".equals(e.getActionCommand())){
            screen.set_game(new War());
        }
        else{
            screen.set_game(new Euchre());
        }
        screen.set_user(new Player(screen.GetName()));

//        Dealer joe = screen.GetDealer();
//        joe.game(game);
//        joe.user( new Player(screen.GetName()));
        //joe.print();
//        joe.play();
    }
}
