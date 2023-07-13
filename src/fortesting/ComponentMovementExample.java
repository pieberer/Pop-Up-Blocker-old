package fortesting;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentMovementExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Component Movement Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Moving Label");
        label.setBounds(10, 10, 100, 30);
        panel.add(label);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);

        int startX = label.getX();
        int targetX = startX + 100;
        int stepSize = 1;
        int delay = 10;

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentX = label.getX();
                if (currentX < targetX) {
                    int newX = Math.min(currentX + stepSize, targetX);
                    label.setLocation(newX, label.getY());
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
