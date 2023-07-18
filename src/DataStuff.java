import javax.swing.*;

import QoLTools.AudioPlayer;
import QoLTools.ExceptionHandler;
import QoLTools.ScreenDimensions;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DataStuff {
    public static void main(String[] args) {
        dataSave();
    }

    public DataStuff() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    winningScreen();
                }catch(Exception e){ExceptionHandler.handleException(e);}
            }
        });
    }

    private static void winningScreen() {
        /* I tried. I tried. But I can't
         * I tried to install javafx to play the video for the yippee but i couldn't.
         * It was simply too hard for me to understand.
         * This is my message.
         *                  - pieb
         */
        Menu obj = new Menu();

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
            "<html>Pop ups closed: %d<br>Difficulty: %d<br>Time: %d</html>", Gameplay.closed, obj.diff, obj.time
        );
        JLabel info = new JLabel(stormg);
        info.setForeground(Color.WHITE);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        
        ImageIcon thegifitself = new ImageIcon("assets/textures/yippee.gif");
        JLabel gif = new JLabel(thegifitself);
        gif.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {Gameplay.retard();frae.dispose();}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        panl.add(info, BorderLayout.CENTER);
        panl.add(gif, BorderLayout.SOUTH);
        panl.add(label, BorderLayout.NORTH);
        frae.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AudioPlayer.stopAudio();
                obj.GUI();
                dataSave();
            }
        });
        frae.getContentPane().add(panl);
        frae.setVisible(true);
    }    

    private static void dataSave() {
        try (FileOutputStream fileOut = new FileOutputStream("highscores.ser");
            ObjectOutputStream obejctOut = new ObjectOutputStream(fileOut)) {
                Menu menuobj = new Menu();
                int diff = menuobj.diff;
                int time = menuobj.time;
                int diffidk = 0;
                int timeidk = 0;
                int[] highSData = new int[20];
                if(loadedHighS == null) {
                    for(int e=0;e<20;e++){highSData[e]=0;}
                } else {
                    highSData = loadedHighS;
                }
                
                /* making sure nothing goes wrong
                * HEY NO CHEATING
                */

                for (int l = 0; l < 5; l++) {
                    diffidk = 0;
                    timeidk++;
                
                    if (timeidk == time) {
                        for (int bruh = 0; bruh < 4; bruh++) {
                            diffidk++;
                
                            if (diffidk == diff) {
                                if (Gameplay.closed < highSData[bruh]) {
                                    highSData[bruh] = Gameplay.closed;
                                }
                            }
                        }
                    }
                }                

                obejctOut.writeObject(highSData);
                // im a GENIUS
        }catch(Exception e){ExceptionHandler.handleException(e);}
    }
    public static int[] loadedHighS;
    public static void dataLoad() {
        try{try{try{
                FileInputStream fileIn = new FileInputStream("highscores.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);

                loadedHighS = (int[]) in.readObject();
                
                in.close();
                fileIn.close();
                }catch(Exception eee){} 
            } catch (Exception e) {
                ExceptionHandler.handleException(e);
            }
        }catch(Exception ee) {
            ExceptionHandler.handleException(ee);
        }
    }
}
