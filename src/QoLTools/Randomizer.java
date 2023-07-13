package QoLTools;

import java.util.Random;

public class Randomizer {
    private static Random random = new Random();
    public static int Randomize(int max, int min) {
        int result = random.nextInt(max - min + 1) + min;
        return result;
    }
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
