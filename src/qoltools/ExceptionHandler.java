package qoltools;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ExceptionHandler {
    public static void handleException(Exception e) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Oops! The app has encountered an error.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JTextArea textArea = new JTextArea();
        textArea.setText(getStackTraceAsString(e));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setTitle("Crash Report");
        frame.setVisible(true);
    }
    private static String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
