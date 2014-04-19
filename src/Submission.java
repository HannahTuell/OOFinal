/**
 * Created by pevargas90 on 4/19/14.
 *
 * Submission object to store who's playing what card
 */
public class Submission {
    public String who;
    public Card   card;

    public Submission(String name, Card what) {
        who  = name;
        card = what;
    }
}
