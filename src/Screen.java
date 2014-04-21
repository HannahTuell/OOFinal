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
