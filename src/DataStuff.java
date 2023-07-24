import javax.swing.*;

import qoltools.AudioPlayer;
import qoltools.ExceptionHandler;
import qoltools.ScreenDimensions;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DataStuff {
    public void dataingStuff(Menu menu) {
        SwingUtilities.invokeLater(() -> {
            try{
                winningScreen(menu);
            }catch(Exception e){ExceptionHandler.handleException(e);}
        });
    }

    private static void winningScreen(Menu menu) {
        /* I tried. I tried. But I can't
         * I tried to install javafx to play the video for the yippee, but I couldn't.
         * It was simply too hard for me to understand.
         * This is my message.
         *                  - pieb
         */
        // hey they got javafx on intellij
        JFrame frae = new JFrame("Congrats!");
        frae.setSize(500, 625);
        int swcenter = ScreenDimensions.getWidth() / 2;
        int shcenter = ScreenDimensions.getHeight() / 2;
        frae.setLocation(swcenter - 400 / 2, shcenter - 400 / 2);
        
        JPanel panl = new JPanel(new BorderLayout());
        panl.setBackground(Color.DARK_GRAY);

        File file = new File("assets/sounds/yippee.wav");
        AudioPlayer.setAudio(file);
        AudioPlayer.playAudio(true);
    
        JLabel label = new JLabel("comgrats!!! you beat the game!!!");
        Font fo = new Font("Arial", Font.BOLD, 28);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.RED);
        label.setFont(fo);

        String stormg = String.format(
            "<html>Pop ups closed: %d<br>Difficulty: %d<br>Time: %d</html>", Gameplay.closed, menu.diff, menu.time
        );
        JLabel info = new JLabel(stormg);
        info.setForeground(Color.WHITE);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        
        ImageIcon theGifItself = new ImageIcon("assets/textures/yippee.gif");
        JLabel gif = new JLabel(theGifItself);
        gif.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e){Gameplay.retard(menu);frae.dispose();}});

        panl.add(info, BorderLayout.CENTER);
        panl.add(gif, BorderLayout.SOUTH);
        panl.add(label, BorderLayout.NORTH);
        frae.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AudioPlayer.stopAudio();
                menu.GUI(menu);
                dataSave();
            }
        });
        frae.getContentPane().add(panl);
        frae.setVisible(true);
    }    

    private static void dataSave() {
        try (FileOutputStream fileOut = new FileOutputStream("highscores.ser");
            ObjectOutputStream obejctOut = new ObjectOutputStream(fileOut)) {
                Menu menu = new Menu();
                int arrayLoc = -1;
                int what = 0;
                Integer[] highSData = new Integer[20];

                if(loadedHighS != null) { highSData = loadedHighS; }

                for (int l = 1; l < 6; l++) {
                    switch(l) {
                        case 1 -> what = 5;
                        case 2 -> what = 15;
                        case 3 -> what = 30;
                        case 4 -> what = 45;
                        case 5 -> what = 60;
                    }
                    for (int bruh = 1; bruh < 5; bruh++) {
                        arrayLoc++;
                        if(what == menu.time) {
                            if (bruh == menu.diff) {
                                if (Gameplay.closed > highSData[arrayLoc]) {
                                    highSData[arrayLoc] = Gameplay.closed;
                                }
                            } else {
                                if(highSData[arrayLoc] != null) {
                                    highSData[arrayLoc] = 0;
                                }
                            }
                        } else {
                            if(highSData[arrayLoc] != null) {
                                highSData[arrayLoc] = 0;
                            }
                            /* making sure nothing goes wrong
                             * HEY NO CHEATING
                             */
                        }
                    }
                }
                obejctOut.writeObject(highSData);
                // im a GENIUS
        }catch(Exception e){ExceptionHandler.handleException(e);}
    }
    public static Integer[] loadedHighS;
    public static void dataLoad() {
        try{
            FileInputStream fileIn;
            ObjectInputStream in;
            try{
                try {
                    try {
                        fileIn = new FileInputStream("highscores.ser");
                        in = new ObjectInputStream(fileIn);
                        loadedHighS = (Integer[]) in.readObject();
                        in.close();
                        fileIn.close();
                    }catch(Exception e){ExceptionHandler.handleException(e);}
                }catch(Exception eee){ExceptionHandler.handleException(eee);}
            }catch(Exception e){ExceptionHandler.handleException(e);}
            for(int e = 0; e < 20; e++) {
                System.out.println(loadedHighS[e]);
            }
        }catch(Exception ee){ExceptionHandler.handleException(ee);}
    }
}
// GOD DAMNIT INTELLIJ STOP BEING GRAMMARLY YOU SUCK ASS