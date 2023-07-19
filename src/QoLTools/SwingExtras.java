package QoLTools;

import java.util.Random;

import javax.swing.JFrame;

public class SwingExtras {
    public static void frameDisposeAll(JFrame[] frames) {
        int totalElements = frames.length; 
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < totalElements; j++) {
                if(frames[j]!=null){frames[j].dispose();}
            }
        }
    }
    private static Random random = new Random();
    public static int JFrameRandomX(int length) {
        int swidth = ScreenDimensions.getWidth();
        int x = random.nextInt(swidth - length);
        return x;
    }
    public static int JFrameRandomY(int height) {
        int sheight = ScreenDimensions.getHeight();
        int y = random.nextInt(sheight - height);
        return y;
    }
}

