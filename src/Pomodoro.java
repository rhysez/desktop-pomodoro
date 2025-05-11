import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {
    private ArrayList<FocusPeriod> focusPeriods;
    private int shortBreakDuration;
    private int longBreakDuration;
    public Pomodoro(ArrayList<FocusPeriod> focusPeriods) {
        this.focusPeriods = focusPeriods;
    }

    public void startPomodoroTimer() {
        Timer timer = new Timer();
        ArrayList<FocusPeriod> focusPeriods = this.focusPeriods;

        TimerTask timerTask = new TimerTask() {
            FocusPeriod focusPeriod = focusPeriods.getFirst();

            @Override
            public void run() {
                long remainingSeconds = focusPeriod.getSeconds();
                if (remainingSeconds > 0) {
                    focusPeriod.setSeconds(remainingSeconds - 1);
                    System.out.println(remainingSeconds + " seconds remaining in focus period");
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

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

    public void setShortBreakDuration(int seconds) {
        this.shortBreakDuration = seconds;
    }

    public int getLongBreakDuration() {
        return longBreakDuration;
    }

    public void setLongBreakDuration(int seconds) {
        this.longBreakDuration = seconds;
    }
}
