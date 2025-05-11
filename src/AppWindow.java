import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    // Globals.
    ArrayList<FocusPeriod> focusPeriods = new ArrayList<FocusPeriod>() {{
        add(new FocusPeriod(5));
        add(new FocusPeriod(5));
        add(new FocusPeriod(10));
        add(new FocusPeriod(15));
    }};

    Pomodoro pomodoro = new Pomodoro(focusPeriods);

    JButton startGenericPomodoroButton = new JButton("Start Generic Pomodoro");

    public AppWindow() {
        this.setTitle("Flexible Pomodoro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x98BBF5));
        this.setLayout(null);

        // The title of the application.
        JLabel appTitle = new JLabel("Flexible Pomodoro");
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
        startGenericPomodoroButton.setBackground(new Color(0x30589E));
        startGenericPomodoroButton.setForeground(Color.WHITE);
        startGenericPomodoroButton.addActionListener(e -> pomodoro.startPomodoroTimer());
        this.add(startGenericPomodoroButton);
    }
}
