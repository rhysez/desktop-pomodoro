public class FocusPeriod {
    private long seconds;

    public FocusPeriod(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMinutes() {
        return seconds / 60;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }
}
