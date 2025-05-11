import java.util.ArrayList;

public class Pomodoro {
    private ArrayList<FocusPeriod> focusPeriods;

    public Pomodoro(ArrayList<FocusPeriod> focusPeriods) {
        this.focusPeriods = focusPeriods;
    }

    public int getFocusPeriodsCount() {
        return focusPeriods.size();
    }
}
