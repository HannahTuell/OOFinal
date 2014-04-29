import java.lang.String;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen{
    private static Dealer joe;
    private static String name;

    public static ScreenState currentState;

    public Screen (){
        currentState = new WelcomeScreen(this);
        joe = new Dealer();
        currentState.DrawScreen();
    }

    public void SetName(String theName){
        name = theName;
    }

    public void set_game(Game game) {
        joe.game(game);
    }

    public void set_user(Player user) {
        joe.user(user);
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

}
