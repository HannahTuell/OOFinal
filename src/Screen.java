<<<<<<< HEAD
import java.lang.String;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen{
    ScreenState welcomeScreen;
    ScreenState selectGameScreen;
    ScreenState wonGameScreen;

    private static String name;

    public ScreenState currentState;

    public Screen (){
        welcomeScreen = new WelcomeScreen(this);
        selectGameScreen = new SelectGameScreen(this);
        wonGameScreen = new WonGameScreen(this);

        currentState = welcomeScreen;
        currentState.DrawScreen();
    }

    public void SetName(String theName){
        name = theName;
    }

    public String GetName(){
        return name;
    }

    public ScreenState GetCurrentState(){
        return currentState;
    }

    public void SetCurrentState(ScreenState state){
        currentState.HideScreen();
        currentState = state;
        currentState.DrawScreen();
    }

    public ScreenState GetWelcomeState(){
        return welcomeScreen;
    }

    public ScreenState GetSelectGameState(){
        return selectGameScreen;
    }

    public ScreenState GetWonGameState(){
        return wonGameScreen;
    }

}
/*
=======
=======
>>>>>>> 5c62be3f17a714069a1cc257ddddaa8705826949
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
<<<<<<< HEAD
//}
>>>>>>> bc226859088d67abfdf3aa6449c72e907b77da01
*/
=======
//}
>>>>>>> 5c62be3f17a714069a1cc257ddddaa8705826949
