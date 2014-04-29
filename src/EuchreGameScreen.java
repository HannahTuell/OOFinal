import javax.accessibility.AccessibleRelation;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

/**
 * Created by justinwoodward on 4/21/14.
 */
public class EuchreGameScreen implements ScreenState, ActionListener {
    private Screen screen;
    JFrame frame;
    JPanel panel;
    List<JTextField> playersTextFields = new LinkedList<JTextField>();
    JTextField ai1;
    JTextField ai2;
    JTextField ai3;
    JTextField player;
    List<JLabel> playersLabels = new LinkedList<JLabel>();
    JLabel aiLabel1;
    JLabel aiLabel2;
    JLabel aiLabel3;
    JLabel playerLabel;
    JPanel aiPanel1;
    JPanel aiPanel2;
    JPanel aiPanel3;
    JPanel playerPanel;
    boolean buttonPressed = false;
    int cardPicked;
    List<Player> playerList;


    public EuchreGameScreen(Screen theScreen){
        CreateScreen(theScreen);
    }

    public void DrawScreen(){
        frame.setVisible(true);
    }

    public void HideScreen(){
        frame.setVisible(false);
    }

    public void CreateScreen(Screen theScreen){
        screen = theScreen;

        //1. Create the frame.
        frame = new JFrame("Euchre");
        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //panel = new JPanel();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setSize(20,20);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.setSize(400,400);
        //frame.pack();

        ai1 = Creater.CreateTextBox();
        aiLabel1 = new JLabel();
        ai2 = Creater.CreateTextBox();
        aiLabel2 = new JLabel();
        ai3 = Creater.CreateTextBox();
        aiLabel3 = new JLabel();
        player = Creater.CreateTextBox();
        playerLabel = new JLabel();

        playersTextFields.add(ai1);
        playersTextFields.add(ai2);
        playersTextFields.add(ai3);
        playersTextFields.add(player);

        playersLabels.add(aiLabel1);
        playersLabels.add(aiLabel2);
        playersLabels.add(aiLabel3);
        playersLabels.add(playerLabel);

        aiPanel1 = new JPanel();
        aiPanel2 = new JPanel();
        aiPanel3 = new JPanel();
        playerPanel = new JPanel();

        aiPanel1.add(ai1, BorderLayout.NORTH);
        aiPanel2.add(ai2, BorderLayout.NORTH);
        aiPanel3.add(ai3, BorderLayout.NORTH);
        //playerPanel.add(player, BorderLayout.NORTH);

        aiPanel1.add(aiLabel1, BorderLayout.SOUTH);
        aiPanel2.add(aiLabel2, BorderLayout.SOUTH);
        aiPanel3.add(aiLabel3, BorderLayout.SOUTH);
        playerPanel.add(playerLabel, BorderLayout.SOUTH);

        frame.add(aiPanel1, BorderLayout.NORTH);
        frame.add(aiPanel2, BorderLayout.EAST);
        frame.add(aiPanel3, BorderLayout.WEST);
        frame.add(playerPanel, BorderLayout.SOUTH);


    }

    public void Print(List<Player> players){
        int i = 0;
        playerList = players;
        playerPanel.removeAll();
        for ( Player player : players) {
            //System.out.print(player.name() + "'s Hand: ");
            playersLabels.get(i).setText(player.name());
            String text = "";
            if (player.GetHand().isEmpty())
                System.out.print("No Cards Available");
            else {
                if(screen.GetName().equals(player.name())){
                    playerPanel.add(playerLabel);
                    for (Card c : player.GetHand()) {
                        JButton button = Creater.CreateButton(c.toString(), "card");
                        System.out.println(c.toString() + " The Card");
                        playerPanel.add(button);

                    }
                }else {
                    System.out.println(player.GetHand().toString());
                    for (Card c : player.GetHand()) {
                        //System.out.print(c.toString() + ", ");
                        //text = playersTextFields.get(i).getText();
                        text += c.toString() + ",";
                        playersTextFields.get(i).setText(text);

                    }
                }

            }
            System.out.print("\n");
            i++;
        }
        frame.setVisible(true);
//        frame.revalidate();
    }
    public void DrawCard(){

    }

    public Integer PickCard(){
        frame.setVisible(false);
        frame.setVisible(true);
        while(!buttonPressed){
            //frame.repaint();
            //playerPanel.repaint();
        }
        buttonPressed = false;
        return cardPicked;
    }

    public void DiscardCard(){

    }

    public Screen getScreen() { return screen; }

    public void actionPerformed(ActionEvent e) {
        if ("card".equals(e.getActionCommand())) {
            cardPicked = Integer.parseInt(e.toString());
            buttonPressed = true;
            System.out.println(e.toString());

        }
        System.out.println(e.toString());

    }

}
