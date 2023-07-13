package fortesting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMovementExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Movement Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(100, 100, 100, 100);

        int initialX = panel.getX();
        int limitX = 200;

        Timer timer = new Timer(10, new ActionListener() {
            private int dx = 1;

            public void actionPerformed(ActionEvent e) {
                int x = panel.getX() + dx;
                if (x >= limitX || x <= initialX) {
                    dx *= -1;
                }
                panel.setLocation(x, panel.getY());
            }
        });
        timer.start();

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
