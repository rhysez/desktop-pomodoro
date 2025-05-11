import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AppWindow extends JFrame {
    public JLabel appTitle = new JLabel("Desktop Pomodoro");
    // Globals.
    ArrayList<FocusPeriod> focusPeriods = new ArrayList<FocusPeriod>() {{
        add(new FocusPeriod(5));
        add(new FocusPeriod(5));
    }};
    Pomodoro pomodoro = new Pomodoro(focusPeriods);
    JButton startGenericPomodoroButton = new JButton("Start Generic Pomodoro");

    private Timer timer;

    public AppWindow() {
        this.setTitle("Desktop Pomodoro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x8ADA90));
        this.setLayout(null);

        // The title of the application.
        appTitle.setHorizontalTextPosition(JLabel.CENTER);
        appTitle.setHorizontalAlignment(JLabel.CENTER);
        appTitle.setVerticalAlignment(JLabel.CENTER);
        appTitle.setFont(appTitle.getFont().deriveFont(Font.BOLD, 24));
        appTitle.setBounds(100, 100, 600, 50);
        this.add(appTitle);

        // Buttons logic.
        startGenericPomodoroButton.setHorizontalTextPosition(JLabel.CENTER);
        startGenericPomodoroButton.setHorizontalAlignment(JLabel.CENTER);
        startGenericPomodoroButton.setVerticalTextPosition(JLabel.CENTER);
        startGenericPomodoroButton.setVerticalAlignment(JLabel.CENTER);
        startGenericPomodoroButton.setBounds(300, 200, 200, 50);
        startGenericPomodoroButton.setFocusable(false);
        startGenericPomodoroButton.setBackground(new Color(0x3F7C46));
        startGenericPomodoroButton.setForeground(Color.WHITE);
        startGenericPomodoroButton.addActionListener(e -> this.run());
        this.add(startGenericPomodoroButton);
    }

    public void run() {
        pomodoro.setFocusPeriodIndex(new AtomicInteger(0));
        FocusPeriod focusPeriod = pomodoro.getFocusPeriods().get(pomodoro.getFocusPeriodIndex().get());
        pomodoro.setCurrentDuration(focusPeriod.getSeconds());
        timer = new Timer(1000, (ActionEvent e) -> {
            if (pomodoro.getCurrentDuration() > 0) {
                appTitle.setText(Integer.toString(pomodoro.getCurrentDuration()));
                pomodoro.setCurrentDuration(pomodoro.getCurrentDuration() - 1);
                System.out.println(pomodoro.getCurrentDuration() + " seconds remaining in focus period");
            } else {
                if (pomodoro.getFocusPeriodIndex().get() == pomodoro.getFocusPeriodsCount() - 1) {
                    timer.stop();
                    appTitle.setText("Desktop Pomodoro");
                } else {
                    pomodoro.incrementFocusPeriodIndex();
                    pomodoro.setCurrentDuration(pomodoro.getFocusPeriods().get(pomodoro.getFocusPeriodIndex().get()).getSeconds());
                }
            }
        });
        timer.start();
    }
}
