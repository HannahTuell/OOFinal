/**
 * Created by pevargas90 on 4/21/14.
 *
 * Object to tell dealer order of events
 */
public class TurnPattern {
    private boolean draw_card_;
    private boolean play_card_;
    private boolean discard_card_;
    private boolean collect_card_;
    private boolean trump_needed_;

    /**
     * Constructor
     */
    public TurnPattern (boolean draw, boolean play, boolean discard, boolean collect, boolean trump) {
        draw_card_    = draw;
        play_card_    = play;
        discard_card_ = discard;
        collect_card_ = collect;
        trump_needed_ = trump;
    }

    /**
     * If each turn requires a draw form pile
     * @return True or False
     */
    public boolean draw() {
        return draw_card_;
    }

    /**
     * If each turn requires a picking of a card to play
     * @return True or False
     */
    public boolean play() {
        return play_card_;
    }

    /**
     * If each turn requires the discarding of a card
     * @return True or False
     */
    public boolean discard() {
        return discard_card_;
    }

    /**
     * If each turn requires someone to pick up cards
     * @return True or False
     */
    public boolean collect() {
        return collect_card_;
    }

    /**
     * If there is a need to pick a trump
     * @return True or False
     */
    public boolean trump() {
        return trump_needed_;
    }
    }
