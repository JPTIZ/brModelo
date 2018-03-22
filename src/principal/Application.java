/*
 * Application.java
 */

package principal;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

/**
 * The BRModelo application itselt.
 */
public class Application {

    public static MainWindow mainWindow;

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        initLookAndFeel();
        JFrame.setDefaultLookAndFeelDecorated(true);

        java.awt.EventQueue.invokeLater(() -> {
                mainWindow = new MainWindow();
                mainWindow.setVisible(true);
        });
    }

    private static void initLookAndFeel() {
        try {
            setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException |
                 ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException ex) {
            util.Logger.log("ERROR_APP_LOAD_UI", ex.getMessage());
        }
    }
}
