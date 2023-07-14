import javax.swing.*;

import QoLTools.AudioPlayer;
import QoLTools.ExceptionHandler;
import QoLTools.ScreenDimensions;
import QoLTools.SwingExtras;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.*;

// haha pp
public class Gameplay {
    public static void main(String[] args) {
        countdown();
    }

    public static int closed = 0;
    private static int loops;
    private static int delay;

    public Gameplay() {
        loopCalc(delay, loops);
        delayCalc(loops);
        countdown();
    }

    private static Timer timer;
    private static void countdown() {
        try {
            JFrame cdf = new JFrame("Countdown");
            ImageIcon wtfbruh = new ImageIcon("assets/icon.png");
            cdf.setIconImage(wtfbruh.getImage());
            cdf.setSize(250, 250);
            cdf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            int swidth = ScreenDimensions.getWidth();
            int sheight = ScreenDimensions.getHeight();
            int swcenter = swidth / 2;
            int shcenter = sheight / 2;
            cdf.setLocation(swcenter - 250 / 2, shcenter - 250 / 2);

            JPanel cdp = new JPanel();
            cdp.setLayout(new BorderLayout());
            cdp.setBackground(Color.DARK_GRAY);
            JLabel label = new JLabel("3");
            label.setForeground(Color.RED);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            Font labelFont = label.getFont();
            Font newFont = labelFont.deriveFont(48f);
            label.setFont(newFont);

            AtomicInteger seconds = new AtomicInteger(3);
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int currentSeconds = seconds.getAndDecrement();
                    switch (currentSeconds) {
                        case 3:
                            label.setText("2");
                            label.setForeground(Color.WHITE);
                            break;
                        case 2:
                            label.setText("1");
                            label.setForeground(Color.RED);
                            break;
                        case 1:
                            timer.stop();
                            label.setText("GO!");
                            label.setForeground(Color.WHITE);
                            break;
                    }
                }
            });
            cdp.add(label);
            cdf.add(cdp);
            cdf.setVisible(true);
            timer.start();
            Thread.sleep(4000);
            cdf.dispose();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }





    private static Timer timerc;
    private static double timerDisplay;
    private static int thetime = 1;

    private static JLabel motivationalLabel;
    private static JLabel timeLabel;
    private static JLabel counter;

    private static JFrame ppcf;
    private static JFrame theuhhhframeyeah;
    private static void popupcTimer() {
        // temporary (later change this in the switch() with objMenu.time)
        int gwagwa = 15;

        //Menu objMenu = new Menu();
        switch(gwagwa) {
            case 5:
                timerDisplay = 5.0;
                thetime = 49;
                break;
            case 15:
                timerDisplay = 15.0;
                thetime = 149;
                break;
            case 30:
                timerDisplay = 30.0;
                thetime = 299;
                break;
            case 45:
                timerDisplay = 45.0;
                thetime = 449;
                break;
            case 60:
                timerDisplay = 60.0;
                thetime = 599;
                break;

        }

        timerc = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thetime--;
                if(thetime > 0) {
                    timerDisplay-=0.1;
                    timeLabel.setText(String.format("%.1f", timerDisplay));
                } else {
                    win();
                }
            }
        });
    }
    private static void popupc() { // this is the window that shows timer and counts windows closed
        //File file = new File("assets/sounds/vslancer.wav");
        //AudioPlayer.setAudio(file);
        AudioPlayer.playAudio(true);

        ppcf = new JFrame("Counter");
        ppcf.setSize(425, 400);
        ppcf.setLocation(SwingExtras.JFrameRandomX(425), SwingExtras.JFrameRandomY(400));
        JPanel ppcp = new JPanel(new BorderLayout());
        ppcp.setBackground(Color.DARK_GRAY);
        
        motivationalLabel = new JLabel("<html>Come on! I know you can do this!<html>");
        motivationalLabel.setForeground(Color.RED);
        motivationalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font fonta = motivationalLabel.getFont();
        Font fontb = fonta.deriveFont(24f);
        Font fontc = fonta.deriveFont(12f);
        motivationalLabel.setFont(fontb);

        counter = new JLabel("Pop-ups closed: " + closed);
        counter.setForeground(Color.WHITE);
        counter.setHorizontalAlignment(SwingConstants.CENTER);
        counter.setFont(fontc);

        timeLabel = new JLabel("" + timerDisplay);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(fontc);

        ppcp.add(timeLabel , BorderLayout.NORTH);
        ppcp.add(motivationalLabel, BorderLayout.CENTER);
        ppcp.add(counter, BorderLayout.SOUTH);
        ppcf.add(ppcp, BorderLayout.CENTER);
        ppcf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
                popupcReinitialize();
            }
        });
        ppcf.setVisible(true);
        popupcTimer();
        timerc.start();
    }
    public static void popupcReinitialize() {
        popupcNew();
    }
    public static void popupcNew() {
        theuhhhframeyeah = new JFrame("Counter");
        ImageIcon THISFUCKINGIMAGEICON = new ImageIcon("assets/icon.png");
        theuhhhframeyeah.setIconImage(THISFUCKINGIMAGEICON.getImage());
        theuhhhframeyeah.setSize(425, 400);
        theuhhhframeyeah.setLocation(SwingExtras.JFrameRandomX(425), SwingExtras.JFrameRandomY(400));
        JPanel goddamnasspanel = new JPanel(new BorderLayout());
        goddamnasspanel.setBackground(Color.DARK_GRAY);

        counter.setText("Pop-ups closed: " + closed);

        goddamnasspanel.add(timeLabel , BorderLayout.NORTH);
        goddamnasspanel.add(motivationalLabel, BorderLayout.CENTER);
        goddamnasspanel.add(counter, BorderLayout.SOUTH);
        theuhhhframeyeah.add(goddamnasspanel, BorderLayout.CENTER);
        theuhhhframeyeah.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
                popupcReinitialize();
            }
        });
        theuhhhframeyeah.setVisible(true);
    }


    private static void win() {
        SwingExtras.frameDisposeAll(popups.pp9f, popups.pp8f, popups.pp7f, popups.pp6f, popups.pp5f, popups.pp4f, popups.pp3f, popups.pp2f, popups.pp1f, popups.pp0f);
        theuhhhframeyeah.dispose();
        ppcf.dispose();
        AudioPlayer.stopAudio();
        timerc.stop();
    }


    

    public static void retard() {
        try{
            SwingExtras.frameDisposeAll(popups.pp9f, popups.pp8f, popups.pp7f, popups.pp6f, popups.pp5f, popups.pp4f, popups.pp3f, popups.pp2f, popups.pp1f, popups.pp0f);
            AudioPlayer.stopAudio();
            File thefile = new File("assets/sounds/fail.wav");
            AudioPlayer.setAudio(thefile);
            AudioPlayer.playAudio(false);
            Desktop.getDesktop().browse(new URI("https://youtu.be/fO5L68MpPkc"));
            JFrame frame = new JFrame("retard");
            JLabel label = new JLabel("youre retarded");
            label.setForeground(Color.WHITE);
            Font labelFont = label.getFont();
            Font newFont = labelFont.deriveFont(48f);
            label.setFont(newFont);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(Color.DARK_GRAY);
            panel.add(label, BorderLayout.CENTER);
            frame.add(panel);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Menu objectthing = new Menu();
                    objectthing.GUI();
                }
            });
            frame.pack();
            frame.setVisible(true);
        } catch(Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static int loopCalc(int lcDiff, int lcTime) {
        int l = 0;
        if(lcTime == 5 && lcDiff == 1) {
            l = 2;
        } else if(lcTime == 5 && lcDiff == 2) {
            l = 5;
        } else if(lcTime == 5 && lcDiff == 3) {
            l = 10;
        } else if(lcTime == 5 && lcDiff == 4) {
            l = 50;
        }
        else if(lcTime == 15 && lcDiff == 1) {
            l = 7;
        } else if(lcTime == 15 && lcDiff == 2) {
            l = 15;
        } else if(lcTime == 15 && lcDiff == 3) {
            l = 30;
        } else if(lcTime == 15 && lcDiff == 4) {
            l = 150;
        }
        else if(lcTime == 30 && lcDiff == 1) {
            l = 15;
        } else if(lcTime == 30 && lcDiff == 2) {
            l = 30;
        } else if(lcTime == 30 && lcDiff == 3) {
            l = 60;
        } else if(lcTime == 30 && lcDiff == 4) {
            l = 300;
        }
        else if(lcTime == 45 && lcDiff == 1) {
            l = 22;
        } else if(lcTime == 45 && lcDiff == 2) {
            l = 45;
        } else if(lcTime == 45 && lcDiff == 3) {
            l = 90;
        } else if(lcTime == 45 && lcDiff == 4) {
            l = 450;
        }
        else if(lcTime == 60 && lcDiff == 1) {
            l = 30;
        } else if(lcTime == 60 && lcDiff == 2) {
            l = 60;
        } else if(lcTime == 60 && lcDiff == 3) {
            l = 120;
        } else if(lcTime == 60 && lcDiff == 4) {
            l = 600;
        } else {
            System.out.println("Something's wrong i can feel it.");
        }
        return l;
    }
    private static int delayCalc(int dcDiff) {
        int d = 0;
        switch(dcDiff) {
            case(1):
                d = 2000;
                break;
            case(2):
                d = 1000;
                break;
            case(3):
                d = 500;
                break;
            case(4):
                d = 100;
                break;
        }
        return d;
    }
}
