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
    private AtomicInteger focusPeriodIndex;
    private String state;

    public Pomodoro(ArrayList<FocusPeriod> focusPeriods) {
        this.focusPeriods = focusPeriods;
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

    public AtomicInteger getFocusPeriodIndex() {
        return focusPeriodIndex;
    }

    public void setFocusPeriodIndex(AtomicInteger focusPeriodIndex) {
        this.focusPeriodIndex = focusPeriodIndex;
    }

    public void incrementFocusPeriodIndex() {
        this.focusPeriodIndex.incrementAndGet();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
