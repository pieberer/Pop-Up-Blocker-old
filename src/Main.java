import javax.swing.SwingUtilities;
import QoLTools.ExceptionHandler;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Menu obj = new Menu();
                obj.GUI(obj);
            } catch (Exception e) {
                ExceptionHandler.handleException(e);
            }
        });
    }
}
// COME ON DUDE