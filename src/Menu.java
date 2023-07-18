import javax.swing.*;

import QoLTools.AudioPlayer;
import QoLTools.ExceptionHandler;
import QoLTools.ScreenDimensions;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Menu { // dont you think its absolutely pointless to set all these vars into private
    private JFrame mainf;
    private JPanel mainp;
    private JLabel title;
    private JLabel subtitle;
    private JLabel description;
    private JButton start;
    private JButton extras;
    private JLabel mainLHSa;
    private JLabel mainLHSb;
    private JButton timer5;
    private JButton timer15;
    private JButton timer30;
    private JButton timer45;
    private JButton timer60;
    private JButton diff1;
    private JButton diff2;
    private JButton diff3;
    private JButton diff4;
    private JLabel timerTitle;
    private JLabel diffTitle;
    private JLabel diffDescription;
    private Font titleFont = new Font("Arial", Font.BOLD + Font.ITALIC, 48);
    private Font subtitleFont = new Font("Arial", Font.BOLD + Font.ITALIC, 12);

    private JPanel mainp2;
    private JButton p2Back;
    private JLabel version;
    private JLabel credits;
    private JLabel changelog;
    private JLabel pieb;
    private JLabel toby;
    private JLabel chatgpt;

    public int diff = 0;
    public int time = 0;
    
    private int highs = 0;

    private int swidth;
    private  int sheight;
    private int swcenter;
    private int shcenter;
    private int mainfsx = 616; // dont mind this very specific size
    private int mainfsy = 750;
    public void GUI(){
        // most important
        DataStuff.dataLoad();
        try{
            // frame
            mainf = new JFrame("Pop Up Blocker");
            ImageIcon icon = new ImageIcon("assets/icon.png");
            mainf.setIconImage(icon.getImage());
            mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainf.setSize(mainfsx, mainfsy);
            mainf.setResizable(false);
            // the frame location
            swidth = ScreenDimensions.getWidth();
            sheight = ScreenDimensions.getHeight();
            swcenter = swidth / 2;
            shcenter = sheight / 2;
            mainf.setLocation(swcenter - mainfsx / 2, shcenter - mainfsy / 2);
            // main stuff
            {
                title = new JLabel("Pop Up Blocker");
                title.setHorizontalAlignment(SwingConstants.CENTER);
                title.setBounds(50, 0, 500, 50);
                title.setFont(titleFont);
                title.setForeground(Color.RED);
                subtitle = new JLabel("Closing Windows to The End of Time");
                subtitle.setHorizontalAlignment(SwingConstants.CENTER);
                subtitle.setBounds(0, 60, 500, 15);
                subtitle.setFont(subtitleFont);
                subtitle.setForeground(Color.ORANGE);
                subtitle.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        subtitle.setText("gwa gwa");
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        subtitle.setText("Closing Windows to The End of Time");
                    }
                });
                description = new JLabel("<html>Welcome to Pop Up Blocker! No, this does not blocks those annoying pop ups. Instead, you'll be blocking those pop ups! Close as much pop ups as possible in a certain time range that you set. Higher difficulty means more pop ups appearing. Have fun!<html>");
                description.setBounds(25, 100, 250, 95);
                description.setForeground(Color.WHITE);
                start = new JButton("Start");
                start.setBounds(400, 100, 150, 100);
                start.setBackground(Color.GRAY);
                start.setForeground(Color.RED);
                start.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(diff != 0 && time != 0) {
                            mainf.dispose();
                            AudioPlayer.stopAudio();
                            new Gameplay();
                        } else {}
                    }
                });
                extras = new JButton("Extras");
                extras.setHorizontalAlignment(SwingConstants.LEFT);
                extras.setBounds(25, 200, 100, 25);
                extras.setBackground(Color.WHITE);
                extras.setForeground(Color.BLACK);
                extras.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainf.getContentPane().remove(mainp);
                        mainf.getContentPane().add(mainp2);
                        mainf.revalidate();
                        mainf.repaint();
                    }
                });
                mainLHSa = new JLabel("Highscore (time = " + time + " + diff = " + diff + "):");
                mainLHSa.setBounds(375, 200, 200, 15);          
                mainLHSa.setHorizontalAlignment(SwingConstants.CENTER);
                mainLHSa.setForeground(Color.WHITE);  
                mainLHSb = new JLabel("" + highs);
                mainLHSb.setBounds(375, 215, 200, 15);
                mainLHSb.setHorizontalAlignment(SwingConstants.CENTER);
                mainLHSb.setForeground(Color.WHITE);
            }
            // timer stuff
            {
                timerTitle = new JLabel("Choose the time");
                timerTitle.setHorizontalAlignment(SwingConstants.CENTER);
                timerTitle.setBounds(250, 275, 100, 15);
                timerTitle.setForeground(Color.WHITE);
                { // 5 seconds timer button
                    timer5 = new JButton("5 seconds");
                    timer5.setBounds(0, 300, 120, 150);
                    timer5.setBackground(Color.GRAY);
                    timer5.setForeground(Color.WHITE);
                    timer5.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            timerTitle.setText("5 seconds");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitTimer();
                        }
                    });
                    timer5.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            time = 5;
                            startJBCol();
                        }
                    });
                }
                { // 15 seconds timer button
                    timer15 = new JButton("15 seconds");
                    timer15.setBounds(120, 300, 120, 150);
                    timer15.setBackground(Color.GRAY);
                    timer15.setForeground(Color.WHITE);
                    timer15.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            timerTitle.setText("15 seconds");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitTimer();
                        }
                    });
                    timer15.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            time = 15;
                            startJBCol();
                        }
                    });
                }
                { // 30 seconds timer button
                    timer30 = new JButton("30 seconds");
                    timer30.setBounds(240, 300, 120, 150);
                    timer30.setBackground(Color.GRAY);
                    timer30.setForeground(Color.WHITE);
                    timer30.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            timerTitle.setText("30 seconds");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitTimer();
                        }
                    });
                    timer30.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            time = 30;
                            startJBCol();
                        }
                    });
                }
                { // 45 seconds timer button
                    timer45 = new JButton("45 seconds");
                    timer45.setBounds(360, 300, 120, 150);
                    timer45.setBackground(Color.GRAY);
                    timer45.setForeground(Color.WHITE);
                    timer45.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            timerTitle.setText("45 seconds");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitTimer();
                        }
                    });
                    timer45.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            time = 45;
                            startJBCol();
                        }
                    });
                }
                { // 60 seconds timer button
                    timer60 = new JButton("60 seconds");
                    timer60.setBounds(480, 300, 120, 150);
                    timer60.setBackground(Color.GRAY);
                    timer60.setForeground(Color.WHITE);
                    timer60.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            timerTitle.setText("60 seconds");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitTimer();
                        }
                    });
                    timer60.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            time = 60;
                            startJBCol();
                        }
                    });
                }
            }
            // difficulty stuff
            {
                diffTitle = new JLabel("Choose difficulty");
                diffTitle.setHorizontalAlignment(SwingConstants.CENTER);
                diffTitle.setBounds(250, 475, 100, 15);
                diffTitle.setForeground(Color.WHITE);
                diffDescription = new JLabel("");
                diffDescription.setBounds(175, 500, 300, 50);
                diffDescription.setHorizontalAlignment(SwingConstants.CENTER);
                diffDescription.setForeground(Color.WHITE);
                { // uh oh // also its easy diff (window appears every 2 seconds)
                    diff1 = new JButton("<html>Easy difficulty<html>");
                    diff1.setBounds(0, 560, 150, 150);
                    diff1.setBackground(Color.GRAY);
                    diff1.setForeground(Color.WHITE);
                    diff1.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            diffTitle.setText("<html><span style='color: lime;'>Easy difficulty</span>");
                            diffDescription.setText("<html>A pop up appears every 2 seconds. For noobs who are new to the game.<html>");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitDiff();
                        }
                    });
                    diff1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            diff = 1;
                            startJBCol();
                        }
                    });
                }
                { // med diff (window appears every 1 second)
                    diff2 = new JButton("<html>Medium difficulty<html>");
                    diff2.setBounds(150, 560, 150, 150);
                    diff2.setBackground(Color.GRAY);
                    diff2.setForeground(Color.WHITE);
                    diff2.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            diffTitle.setText("<html><span style='color: yellow;'>Medium difficulty</span>");
                            diffDescription.setText("<html>A pop up appears every 1 second. For people who aren't new.");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitDiff();
                        }
                    });
                    diff2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            diff = 2;
                            startJBCol();
                        }
                    });
                }
                { // hard diff (window appears every 0.5 second)
                    diff3 = new JButton("<html>Hard difficulty<html>");
                    diff3.setBounds(300, 560, 150, 150);
                    diff3.setBackground(Color.GRAY);
                    diff3.setForeground(Color.WHITE);
                    diff3.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            diffTitle.setText("<html><span style='color: orange;'>Hard difficulty</span>");
                            diffDescription.setText("<html>A pop up appears every 0.5 seconds. For pros who... uhhh... plays the game.<html>");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitDiff();
                        }
                    });
                    diff3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            diff = 3;
                            startJBCol();
                        }
                    });
                }
                { // extreme diff (window appears every 0.1 second) (also give warning that it might be heavy)
                    diff4 = new JButton("<html>Extreme difficulty<html>");
                    diff4.setBounds(450, 560, 150, 150);
                    diff4.setBackground(Color.GRAY);
                    diff4.setForeground(Color.WHITE);
                    diff4.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            diffTitle.setText("<html><span style='color: red;'>Extreme difficulty</span>");
                            diffDescription.setText("<html>A pop up will appear every 0.1 seconds. For true pros. \n<span style='color: red;'>WARNING: might affect your performance. Also kinda buggy.</span><html>");
                        }
                        public void mouseExited(MouseEvent e) {
                            mouseExitDiff();
                        }
                    });
                    diff4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            diff = 4;
                            startJBCol();
                        }
                    });
                }
            }
            // array for components because im cool
            Component[] components = new Component[19];
            {
                components[0] = title;
                components[1] = subtitle;
                components[2] = description;
                components[3] = start;
                {
                    components[4] = timerTitle;
                    components[5] = timer5;
                    components[6] = timer15;
                    components[7] = timer30;
                    components[8] = timer45;
                    components[9] = timer60;
                }
                {
                    components[10] = diffTitle;
                    components[11] = diffDescription;
                    components[12] = diff1;
                    components[13] = diff2;
                    components[14] = diff3;
                    components[15] = diff4;
                }
                components[16] = mainLHSa;
                components[17] = mainLHSb;
                components[18] = extras;
            } // you can see the order of which component is made first
            // panel
            mainp = new JPanel();
            mainp.setLayout(null);
            mainp.setBackground(Color.DARK_GRAY);
            for(Component component : components) {
                mainp.add(component);
            }
            { // second panel
                mainp2 = new JPanel();
                mainp2.setLayout(null);
                mainp2.setBackground(Color.DARK_GRAY);

                p2Back = new JButton("Go back");
                p2Back.setBounds(0, 685, 100, 25);
                p2Back.setBackground(Color.WHITE);
                p2Back.setForeground(Color.BLACK);
                p2Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainf.getContentPane().remove(mainp2);
                        mainf.getContentPane().add(mainp);
                        mainf.revalidate();
                        mainf.repaint();
                    }
                });
                version = new JLabel("Version 1.0");
                version.setBounds(110, 690, 100, 25);
                version.setForeground(Color.WHITE);
                
                Font creditsFont = new Font("Arial", Font.BOLD, 15);
                credits = new JLabel("<html>Credits:<br/>Developed by pieb (hes epic)<br/>Musics by Toby Fox (cool music and game)<br/>Special thanks to ChatGPT (helped me a lot)<html>");
                credits.setBounds(50, 0, 350, 250);
                credits.setFont(creditsFont);
                credits.setForeground(Color.WHITE);

                changelog = new JLabel("<html>Changelog 1.0: <br>- the game was just made lmfao<html>");
                changelog.setBounds(275, 475, 250, 250);
                changelog.setForeground(Color.WHITE);

                // TODO: these gifs
                pieb = new JLabel("pieb gif goes here");
                pieb.setBounds(385, 50, 200, 15);
                pieb.setForeground(Color.WHITE);

                ImageIcon tobyGif = new ImageIcon("assets/textures/toby.gif");
                toby = new JLabel(tobyGif);
                toby.setBounds(450, 150, toby.getIcon().getIconWidth(), toby.getIcon().getIconHeight());

                chatgpt = new JLabel("chatgpt gif goes here");
                chatgpt.setBounds(150, 250, 200, 15);
                chatgpt.setForeground(Color.WHITE);
                // finishing the panel (i dont use array, im not cool)
                {
                    mainp2.add(p2Back);
                    mainp2.add(version);
                    mainp2.add(credits);
                    mainp2.add(changelog);
                    mainp2.add(toby);
                    mainp2.add(pieb);
                    mainp2.add(chatgpt);
                }
            }
            // background music (sans)
            try{
                File bgmusic = new File("assets/sounds/sans.wav");
                AudioPlayer.setAudio(bgmusic);
                AudioPlayer.playAudio(true);
            } catch(Exception e) {
                ExceptionHandler.handleException(e);
            }
            // finishing
            mainf.getContentPane().add(mainp);
            mainf.setVisible(true);
        } catch(Exception e) {
            ExceptionHandler.handleException(e);
        }
    }



    public void startJBCol() {
        if(time != 0 && diff != 0) {
            start.setForeground(Color.GREEN);
        } else {
            start.setForeground(Color.RED);
        }
    }
    public void mouseExitTimer() {
        switch (time) {
            case 5:
                timerTitle.setText("5 seconds");
                break;
            case 15:
                timerTitle.setText("15 seconds");
                break;
            case 30:
                timerTitle.setText("30 seconds");
                break;
            case 45:
                timerTitle.setText("45 seconds");
                break;
            case 60:
                timerTitle.setText("60 seconds");
                break;
            default:
                timerTitle.setText("Choose the time");
                break;
        }
    }
    public void mouseExitDiff() {
        switch (diff) {
            case 1:
                diffTitle.setText("<html><span style='color: lime;'>Easy difficulty</span>");
                diffDescription.setText("<html>A pop up appears every 2 seconds. For noobs who are new to the game.<html>");
                break;
            case 2:
                diffTitle.setText("<html><span style='color: yellow;'>Medium difficulty</span>");
                diffDescription.setText("<html>A pop up appears every 1 second. For people who aren't new.");
                break;
            case 3:
                diffTitle.setText("<html><span style='color: orange;'>Hard difficulty</span>");
                diffDescription.setText("<html>A pop up appears every 0.5 seconds. For pros who... uhhh... plays the game.<html>");
                break;
            case 4:
                diffTitle.setText("<html><span style='color: red;'>Extreme difficulty</span>");
                diffDescription.setText("<html>A pop up will appear every 0.1 seconds. For true pros. \n<span style='color: red;'>WARNING: might affect your performance. Also kinda buggy</span><html>");
                break;  
            default:
                diffTitle.setText("Choose difficulty");
                diffDescription.setText("");
                break;
        }
    }
}
