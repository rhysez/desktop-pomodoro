import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Pomodoro {
    private ArrayList<FocusPeriod> focusPeriods;
    private int shortBreakDuration;
    private int longBreakDuration;
    private int currentDuration;
    private boolean running;

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
                Pomodoro.this.setRunning(true);
                Pomodoro.this.setCurrentDuration(focusPeriod.getSeconds());

                if (Pomodoro.this.getCurrentDuration() > 0) {
                    focusPeriod.setSeconds(focusPeriod.getSeconds() - 1);
                    System.out.println(Pomodoro.this.getCurrentDuration() + " seconds remaining in focus period");
                } else {
                    if (currentFocusPeriodIndex.get() == focusPeriods.size() - 1) {
                        timer.cancel();
                        Pomodoro.this.setRunning(false);
                    } else {
                        currentFocusPeriodIndex.incrementAndGet();
                    }
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

    public int getCurrentDuration() {
        return currentDuration;
    }

    public void setCurrentDuration(int seconds) {
        this.currentDuration = seconds;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
