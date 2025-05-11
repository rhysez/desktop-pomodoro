public class FocusPeriod {
    private int seconds;

    public FocusPeriod(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return seconds / 60;
    }
}
