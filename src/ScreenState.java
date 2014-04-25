import java.util.List;

/**
 * Created by justinwoodward on 4/21/14.
 */
public interface ScreenState {

    void DrawScreen();

    void HideScreen();

    void Print(List<Player> players);

    void DrawCard();

    Integer PickCard();

    void DiscardCard();
}
