package QoLTools;

import java.util.Random;

public class Randomizer {
    private static Random random = new Random();
    public static int randomizeInt(int max, int min) {
        int result = random.nextInt(max - min + 1) + min;
        return result;
    }
}
