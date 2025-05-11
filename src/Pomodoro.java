import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger currentFocusPeriodIndex = new AtomicInteger(0);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                FocusPeriod focusPeriod = focusPeriods.get(currentFocusPeriodIndex.get());
                long remainingSeconds = focusPeriod.getSeconds();

                if (remainingSeconds > 0) {
                    focusPeriod.setSeconds(remainingSeconds - 1);
                    System.out.println(remainingSeconds + " seconds remaining in focus period");
                } else {
                    currentFocusPeriodIndex.incrementAndGet();
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
