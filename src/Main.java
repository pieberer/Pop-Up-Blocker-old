import javax.swing.SwingUtilities;
import QoLTools.ExceptionHandler;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try {
                    Menu obj = new Menu();
                    obj.GUI();
                } catch (Exception e) {
                    ExceptionHandler.handleException(e);
                }
            }
        });
    }
}
