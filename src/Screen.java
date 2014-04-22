import java.lang.String;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen{
    static ScreenState welcomeScreen;
    static ScreenState selectGameScreen;
    static ScreenState wonGameScreen;
    static ScreenState euchreGameScreen;
    private static Dealer joe;
    private static String name;

    public static ScreenState currentState;

    public Screen (){
        welcomeScreen = new WelcomeScreen(this);
        selectGameScreen = new SelectGameScreen(this);
        wonGameScreen = new WonGameScreen(this);
        euchreGameScreen = new EuchreGameScreen(this);

        currentState = welcomeScreen;
        currentState.DrawScreen();
    }

    public void SetName(String theName){
        name = theName;
    }

    public static String GetName(){
        return name;
    }

    public static ScreenState GetCurrentState(){
        return currentState;
    }

    public static void SetCurrentState(ScreenState state){
        currentState.HideScreen();
        currentState = state;
        currentState.DrawScreen();
    }

    public static Dealer GetDealer(){
        return joe;
    }

    public static void SetDealer(Dealer dealer){
        joe = dealer;
    }

    public static ScreenState GetWelcomeState(){
        return welcomeScreen;
    }

    public static ScreenState GetSelectGameState(){
        return selectGameScreen;
    }

    public static ScreenState GetWonGameState(){
        return wonGameScreen;
    }

    public static ScreenState GetEuchreGameState() {
        return euchreGameScreen;
    }

}
