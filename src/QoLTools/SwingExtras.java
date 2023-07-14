package QoLTools;

import java.util.Random;

import javax.swing.JFrame;

public class SwingExtras {
    public static void frameDisposeAll(JFrame f0, JFrame f1, JFrame f2, JFrame f3, JFrame f4, JFrame f5, JFrame f6, JFrame f7, JFrame f8, JFrame f9) {
        for(int i = 1; i <= 10; i++) {
            if(f0 == null) {} else {f0.dispose();} 
            if(f1 == null) {} else {f1.dispose();}
            if(f2 == null) {} else {f2.dispose();}
            if(f3 == null) {} else {f3.dispose();}
            if(f4 == null) {} else {f4.dispose();}
            if(f5 == null) {} else {f5.dispose();}
            if(f6 == null) {} else {f6.dispose();}
            if(f7 == null) {} else {f7.dispose();}
            if(f8 == null) {} else {f8.dispose();}
            if(f9 == null) {} else {f9.dispose();}
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

