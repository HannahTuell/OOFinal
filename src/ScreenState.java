import java.util.List;

/**
 * Created by justinwoodward on 4/21/14.
 */
public interface ScreenState {

    boolean DrawScreen();

    void HideScreen();

    void Print();

    void DrawCard();

    Integer PickCard();

    void DiscardCard();

    Screen getScreen();
}
