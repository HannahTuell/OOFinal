<<<<<<< HEAD

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen{

    public Screen (){
        //1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }
}
=======
//package components;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Screen{
//
//    public static void main(String [ ] args)
//    {
//       Screen sc = new Screen();
//    }
//
//    public void Screen (){
//        //1. Create the frame.
//        JFrame frame = new JFrame("FrameDemo");
//
//        //2. Optional: What happens when the frame closes?
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //3. Create components and put them in the frame.
//        //...create emptyLabel...
//        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
//
//        //4. Size the frame.
//        frame.pack();
//
//        //5. Show it.
//        frame.setVisible(true);
//    }
//}
>>>>>>> bc226859088d67abfdf3aa6449c72e907b77da01
