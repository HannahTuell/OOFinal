/**
 * Created by justinwoodward on 4/18/14.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeScreen implements ScreenState, ActionListener {
    JFrame frame;
    JPanel panel;
    Screen screen;
    private String buttonActionCommand = "Continue";
    JTextField textBox = Creater.CreateTextBox();

    public WelcomeScreen(Screen theScreen) {
        screen = theScreen;
        //1. Create the frame.
        frame = new JFrame("Welcome");
        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        panel = new JPanel();
        panel.setSize(20,20);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.setSize(400,400);
        //frame.pack();

        JLabel emptyLabel = new JLabel("Welcome Enter you Name");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        panel.add(emptyLabel, BorderLayout.NORTH);

        panel.add(textBox, BorderLayout.CENTER);
        JButton button = Creater.CreateButton("Continue", buttonActionCommand);
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);
    }

    public void DrawScreen(){
        //5. Show it.
        frame.setVisible(true);
    }

    public void HideScreen(){
        frame.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (buttonActionCommand.equals(e.getActionCommand())) {
            screen.SetName(textBox.getText());
            screen.SetCurrentState(screen.GetSelectGameState());

        }
    }
}
