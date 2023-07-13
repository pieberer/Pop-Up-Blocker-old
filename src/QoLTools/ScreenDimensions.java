package QoLTools;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenDimensions {
    public static int getWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        return width;
    }
    public static int getHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        return height;
    }
}
