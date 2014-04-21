import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by justinwoodward on 4/21/14.
 */
public class Creater {

    public Creater(){

    }
    public static JTextField CreateTextBox(){
        JTextField textBox = new JTextField(15);
        return textBox;
    }

    public static JButton CreateButton(String text, String actionCommand){
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        return button;
    }
}
