import java.util.ArrayList;

public class Pomodoro {
    public Pomodoro(ArrayList<FocusPeriod> focusPeriods) {
        this.focusPeriods = focusPeriods;
    }

    private ArrayList<FocusPeriod> focusPeriods;
    private int shortBreakDuration;
    private int longBreakDuration; // If value is 0, Pomodoro does not have long break.

    public int getFocusPeriodsCount() {
        return focusPeriods.size();
    }

    public ArrayList<FocusPeriod> getFocusPeriods() {
        return focusPeriods;
    }

    public void setFocusPeriods(ArrayList<FocusPeriod> focusPeriods) {
        this.focusPeriods = focusPeriods;
    }

    public int getShortBreakDuration() {
        return shortBreakDuration;
    }

    public void setShortBreakDuration(int shortBreakDuration) {
        this.shortBreakDuration = shortBreakDuration;
    }

    public int getLongBreakDuration() {
        return longBreakDuration;
    }

    public void setLongBreakDuration(int longBreakDuration) {
        this.longBreakDuration = longBreakDuration;
    }
}
