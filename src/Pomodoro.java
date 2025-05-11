import java.util.ArrayList;

public class Pomodoro {
    private ArrayList<Interval> intervals;

    public Pomodoro(ArrayList<Interval> intervals) {
        this.intervals = intervals;
    }

    public int getIntervalsCount() {
        return intervals.size();
    }
}
