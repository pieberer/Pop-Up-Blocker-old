import javax.swing.*;
import qoltools.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.*;

// haha pp
public class Gameplay {
    public static int closed = 0;
    private static int loops;
    private static int delay;

    public void game(Menu menu) { // the actual gameplay
        try{ // god help me
            int diff = menu.diff;
            int time = menu.time;
            loops = loopCalc(diff, time);
            delay = delayCalc(diff);

            countdown(menu);
        }catch(Exception e){ExceptionHandler.handleException(e);}
    }

    private static void actualGameplay(Menu menu) { // JUST KIDDING, THIS IS THE REAL ACTUAL GAMEPLAY!
        try{
            popupc(menu);
            realActualGameplay(menu);
        }catch(Exception e){ExceptionHandler.handleException(e);}
    }

    private static int thisisacertifiedbruhmoment;
    private static Timer gameplayTimer;
    private static void realActualGameplay(Menu menu) { // J U S T   K I -
        try{
            new popups(menu);
            gameplayTimer = new Timer(delay, e -> {
                thisisacertifiedbruhmoment = Randomizer.randomizeInt(9, 0);

                switch (thisisacertifiedbruhmoment) {
                    case 0 -> popups.popup0();
                    case 1 -> popups.popup1();
                    case 2 -> popups.popup2();
                    case 3 -> popups.popup3();
                    case 4 -> popups.popup4();
                    case 5 -> popups.popup5();
                    case 6 -> popups.popup6();
                    case 7 -> popups.popup7();
                    case 8 -> popups.popup8();
                    case 9 -> popups.popup9();
                }

                if (menu.diff == 1) {
                    if (loops == 2 && menu.time == 5) {
                    } else if (menu.time == 15 && loops == 15) {
                    } else if (menu.time == 45 && loops == 45) {
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception ex) {
                            ExceptionHandler.handleException(ex);
                        }
                    }
                }
                counter.setText("Pop-ups closed: " + closed);
                if(loops==0){win(menu);}
                loops--;
            });
            gameplayTimer.start();
        }catch(Exception e){ExceptionHandler.handleException(e);}
    }

    private static Timer countdownTimer;
    private static void countdown(Menu menu) {
        try {
            JFrame cdf = new JFrame("Countdown");
            ImageIcon wtfbruh = new ImageIcon("assets/icon.png");
            cdf.setIconImage(wtfbruh.getImage());
            cdf.setSize(250, 250);
            int swidth = ScreenDimensions.getWidth();
            int sheight = ScreenDimensions.getHeight();
            int swcenter = swidth / 2;
            int shcenter = sheight / 2;
            cdf.setLocation(swcenter - 250 / 2, shcenter - 250 / 2);
            cdf.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    countdownTimer.stop();
                    menu.GUI(menu);
                }
            });

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
            countdownTimer = new Timer(1000, e -> {
                int currentSeconds = seconds.getAndDecrement();
                switch (currentSeconds) {
                    case 3 -> {
                        label.setText("2");
                        label.setForeground(Color.WHITE);
                    }
                    case 2 -> {
                        label.setText("1");
                        label.setForeground(Color.RED);
                    }
                    case 1 -> {
                        label.setText("GO!");
                        label.setForeground(Color.WHITE);
                    }
                    case 0 -> {
                        countdownTimer.stop();
                        cdf.dispose();
                        actualGameplay(menu);
                    }
                }
            });
            cdp.add(label);
            cdf.add(cdp);
            cdf.setVisible(true);
            countdownTimer.start();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }





    private static Timer timerc;
    private static double timerDisplay;

    private static JLabel motivationalLabel;
    private static JLabel timeLabel;
    private static JLabel counter;

    private static JFrame ppcf;
    private static JFrame theuhhhframeyeah;
    private static void popupcTimer(Menu menu) {
        switch (menu.time) {
            case 5 -> timerDisplay = 5.0;
            case 15 -> timerDisplay = 15.0;
            case 30 -> timerDisplay = 30.0;
            case 45 -> timerDisplay = 45.0;
            case 60 -> timerDisplay = 60.0;
        }

        timerc = new Timer(100, e -> {
            timerDisplay-=0.1;
            timeLabel.setText(String.format("%.1f", timerDisplay));
        });
    }
    private static void popupc(Menu menu) { // this is the window that shows timer and counts windows closed
        File file = new File("assets/sounds/vslancer.wav");
        AudioPlayer.setAudio(file);
        AudioPlayer.playAudio(true);

        ppcf = new JFrame("Counter");
        ppcf.setSize(425, 400);
        ppcf.setLocation(SwingExtras.jframeRandomX(425), SwingExtras.jframeRandomY(400));
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

        timeLabel = new JLabel(String.valueOf(timerDisplay));
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
        popupcTimer(menu);
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
        theuhhhframeyeah.setLocation(SwingExtras.jframeRandomX(425), SwingExtras.jframeRandomY(400));
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



    private static void win(Menu menu) {
        DataStuff data = new DataStuff();
        data.dataingStuff(menu);
        JFrame[] popupFrames = totalFrame();
        gameplayTimer.stop();
        SwingExtras.frameDisposeAll(popupFrames);
        if(theuhhhframeyeah!=null){theuhhhframeyeah.dispose();}
        if(ppcf!=null){ppcf.dispose();}
        AudioPlayer.stopAudio();
        timerc.stop();
    }

    
    private static JFrame[] totalFrame() {
        JFrame[] frames = new JFrame[10];
        {
            frames[0] = popups.pp0f;
            frames[1] = popups.pp1f;
            frames[2] = popups.pp2f;
            frames[3] = popups.pp3f;
            frames[4] = popups.pp4f;
            frames[5] = popups.pp5f;
            frames[6] = popups.pp6f;
            frames[7] = popups.pp7f;
            frames[8] = popups.pp8f;
            frames[9] = popups.pp9f;
        }
        return frames;
    }


    public static void retard(Menu menu) {
        try{
            if(gameplayTimer!=null){gameplayTimer.stop();}
            JFrame[] popupFrames = totalFrame();
            ppcf.dispose();
            SwingExtras.frameDisposeAll(popupFrames);
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
                    menu.GUI(menu);
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
            System.out.println("Something's wrong in the loops calculator.");
            System.out.println("The time: " + lcTime + " and the difficulty: " + lcDiff);
        } // for debugging
        return l;
    }
    private static int delayCalc(int dcDiff) {
        int d = 0;
        switch (dcDiff) {
            case (1), (2) -> d = 1000;
            case (3) -> d = 500;
            case (4) -> d = 100;
            default -> System.out.println("Something's wrong in the difficulty calculator.");
        }
        return d;
    }
}
