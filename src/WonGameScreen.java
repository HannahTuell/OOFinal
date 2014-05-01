import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by justinwoodward on 4/21/14.
 */
public class WonGameScreen implements ScreenState, ActionListener {
    JFrame frame;
    JPanel panel;
    Screen screen;
    JLabel emptyLabel;

    public WonGameScreen(Screen theScreen){
        screen = theScreen;
        //1. Create the frame.
        frame = new JFrame("Congrats!");
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
        emptyLabel = new JLabel("Congratulations " + screen.GetName() + " you won your game!");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        panel.add(emptyLabel, BorderLayout.NORTH);
        JButton euchreButton = Creater.CreateButton("Play Again", "playAgain");
        euchreButton.addActionListener(this);
        panel.add(euchreButton, BorderLayout.CENTER);
        JButton selectGame = Creater.CreateButton("Select Game Screen", "selectGame");
        selectGame.addActionListener(this);
        panel.add(selectGame, BorderLayout.CENTER);
    }

    public boolean DrawScreen(){
        emptyLabel.setText("Congratulations " + screen.GetName() + " you won your game!");
        if ( !frame.isVisible() )
            frame.setVisible(true);
        return false;
    }

    public void HideScreen(){
        frame.setVisible(false);
    }

    public void Print(){

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
        if ("playAgain".equals(e.getActionCommand())) {
            System.out.println("Nope!");
        }
        else if("selectGame".equals(e.getActionCommand())){
            screen.SetCurrentState(new SelectGameScreen(screen));
        }
        System.out.print("Here");
    }
}
