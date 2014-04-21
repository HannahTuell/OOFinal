import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JButton otherGame = Creater.CreateButton("Other Game", "OtherGame");
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

    public void actionPerformed(ActionEvent e) {
        if ("Euchre".equals(e.getActionCommand())) {
            screen.SetCurrentState(screen.GetWonGameState());
        }
        if("OtherGame".equals(e.getActionCommand())){
            System.out.println("There is no other game haha!");
        }
    }
}
