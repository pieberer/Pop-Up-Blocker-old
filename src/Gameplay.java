import javax.swing.*;

import QoLTools.AudioPlayer;
import QoLTools.ExceptionHandler;
import QoLTools.Randomizer;
import QoLTools.SwingExtras;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.*;
// haha pp
public class Gameplay {
    public static void main(String[] args) {
        popupc();
    }

    public static int closed = 0;
    private static int loops;
    private static int delay;
    private static Random random = new Random();

    public Gameplay() {
        Menu objMenu = new Menu();
        loops = loopCalc(objMenu.diff, objMenu.time);
        delay = delayCalc(objMenu.diff);
        try{
            countdown();
            Thread.sleep(4000);
            { // the actual game
                popupc();
                for(int a = 1; a <= loops; a++) {
                    int bruh = random.nextInt(10 - 1 + 1) + 1;
                    popupRun(bruh);
                    switch(objMenu.diff) {
                        case(1):
                            if(objMenu.time == 5 && a == 2) {
                                Thread.sleep(1000);
                            } else if(objMenu.time == 15 && a == 7) {
                                Thread.sleep(1000);
                            } else if(objMenu.time == 45 && a == 22) {
                                Thread.sleep(1000);
                            } else {
                                Thread.sleep(delay);
                            }
                            break;
                        default:
                            Thread.sleep(delay);
                    }
                }
                winningScreen();
            }
        } catch(Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static Timer timer;
    private static void countdown() {
    try {
        JFrame cdf = new JFrame("Countdown");
        cdf.setSize(250, 250);
        cdf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
    private static void winningScreen() {
        SwingExtras.frameDisposeAll(pp9f, pp8f, pp7f, pp6f, pp5f, pp4f, pp3f, pp2f, pp1f, pp0f);

    }
    private static Timer timerc;
    private static double timerDisplay;
    private static int thetime = 1;
    private static void popupc() { // this is the window that shows timer and counts windows closed
        File file = new File("assets/sounds/vslancer.wav");
        AudioPlayer.setAudio(file);
        AudioPlayer.playAudio(true);

        JFrame ppcf = new JFrame("Counter");
        ppcf.setSize(425, 400);
        ppcf.setLocation(Randomizer.JFrameRandomX(425), Randomizer.JFrameRandomY(400));
        JPanel ppcp = new JPanel(new BorderLayout());
        ppcp.setBackground(Color.DARK_GRAY);
        
        JLabel label = new JLabel("<html>Come on! I know you can do this!<html>");
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font fonta = label.getFont();
        Font fontb = fonta.deriveFont(24f);
        Font fontc = fonta.deriveFont(12f);
        label.setFont(fontb);

        // temporary (later change this in the switch() with objMenu.time)
        int gwagwa = 60;

        Menu objMenu = new Menu();
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

        JLabel timeLabel = new JLabel("" + timerDisplay);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(fontc);

        timerc = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thetime--;
                if(thetime > 0) {
                    timerDisplay-=0.1;
                    timeLabel.setText(String.format("%.1f", timerDisplay));
                } else {
                    ppcf.dispose();
                    timerc.stop();
                }
            }
        });

        JLabel counter = new JLabel("Pop-ups closed: " + closed);
        counter.setForeground(Color.WHITE);
        counter.setHorizontalAlignment(SwingConstants.CENTER);
        counter.setFont(fontc);

        

        ppcp.add(timeLabel , BorderLayout.NORTH);
        ppcp.add(label, BorderLayout.CENTER);
        ppcp.add(counter, BorderLayout.SOUTH);
        ppcf.add(ppcp, BorderLayout.CENTER);
        ppcf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
                popupc();
            }
        });
        ppcf.setVisible(true);
        timerc.start();
    }

    private static JFrame pp0f;
    private static JFrame pp1f;
    private static JFrame pp2f;
    private static JFrame pp3f;
    private static JFrame pp4f;
    private static JFrame pp5f;
    private static JFrame pp6f;
    private static JFrame pp7f;
    private static JFrame pp8f;
    private static JFrame pp9f;

    private static void retard() {
        try{
            SwingExtras.frameDisposeAll(pp9f, pp8f, pp7f, pp6f, pp5f, pp4f, pp3f, pp2f, pp1f, pp0f);
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
    private static void popupRun(int bruh) {
        switch(bruh) { // dont. ask. anything. especially about the numbers.
            case 1 :
                popup0();
                break;
            case 2 :
                popup1();
                break;
            case 3 :
                popup2();
                break;
            case 4 :
                popup3();
                break;
            case 5 :
                popup4();
                break;
            case 6 :
                popup5();
                break;
            case 7 :
                popup6();
                break;
            case 8 :
                popup7();
                break;
            case 9 :
                popup8();
                break;
            case 10 :
                popup9();
                break;
        }
    }

    private static void popup0() {
        pp0f = new JFrame("HOT CHICKS");
        pp0f.setSize(348, 275);
        pp0f.setLocation(Randomizer.JFrameRandomX(348), Randomizer.JFrameRandomY(275));
        JPanel pp0p = new JPanel();
        ImageIcon img = new ImageIcon("assets/textures/popups/hot chicks.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                retard();
            }
        });
        JLabel label = new JLabel("HOT CHICKS NEAR YOU");
        label.setBounds(25, 200, 348, 24);
        Font font = new Font("Arial", Font.BOLD, 24);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        pp0p.setLayout(null);
        pp0p.setBackground(Color.BLACK);
        pp0p.add(imageLabel);
        pp0p.add(label);
        pp0f.add(pp0p);
        pp0f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp0f.setVisible(true);
    }
    private static void popup1() {
        pp1f = new JFrame("DOWNLOAD NOW");
        pp1f.setSize(300, 200);
        JPanel pp1p = new JPanel();
        pp1p.setLayout(null);
        ImageIcon gif = new ImageIcon("assets/textures/popups/sketchy ass button.gif");
        JLabel gifLabel = new JLabel(gif);
        gifLabel.setBounds(25, 10, gif.getIconWidth() + 50, gif.getIconHeight() + 20);
        gifLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                retard();
            }
        });
        JLabel label = new JLabel("<html>ARE YOU SURE YOU WANT TO DOWNLOAD THE FILE???<html>");
        label.setBounds(25, 64, 200, 100);
        pp1p.add(gifLabel);
        pp1p.add(label);
        pp1f.add(pp1p);
        pp1f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp1f.setVisible(true);
    }
    private static void popup2() {
        pp2f = new JFrame();
        JPanel pp2p = new JPanel();
        pp2p.setLayout(null);
        pp2f.add(pp2p);
        pp2f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp2f.setVisible(true);
    }
    private static void popup3() {
        pp3f = new JFrame();
        JPanel pp3p = new JPanel();
        pp3p.setLayout(null);
        pp3f.add(pp3p);
        pp3f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp3f.setVisible(true);
    }
    private static void popup4() {
        pp4f = new JFrame();
        JPanel pp4p = new JPanel();
        pp4p.setLayout(null);
        pp4f.add(pp4p);
        pp4f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp4f.setVisible(true);
    }
    private static  void popup5() {
        pp5f = new JFrame();
        JPanel pp5p = new JPanel();
        pp5p.setLayout(null);
        pp5f.add(pp5p);
        pp5f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp5f.setVisible(true);
    }
    private static void popup6() {
        pp6f = new JFrame();
        JPanel pp6p = new JPanel();
        pp6p.setLayout(null);
        pp6f.add(pp6p);
        pp6f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp6f.setVisible(true);
    }
    private static void popup7() {
        pp7f = new JFrame();
        JPanel pp7p = new JPanel();
        pp7p.setLayout(null);
        pp7f.add(pp7p);
        pp7f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp7f.setVisible(true);
    }
    private static void popup8() {
        pp8f = new JFrame();
        JPanel pp8p = new JPanel();
        pp8p.setLayout(null);
        pp8f.add(pp8p);
        pp8f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp8f.setVisible(true);
    }
    private static void popup9() {
        pp9f = new JFrame();
        JPanel pp9p = new JPanel();
        pp9p.setLayout(null);
        pp9f.add(pp9p);
        pp9f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed+=1;
            }
        });
        pp9f.setVisible(true);
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
