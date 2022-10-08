import javax.swing.UIManager;
import resources.ActivityPanel;
import javax.swing.*;

public class MainActivity extends JFrame {
    MainActivity() {
        setTitle("App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusableWindowState(true);
        setAlwaysOnTop(true);
        add(new ActivityPanel());
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("MainActivity.main()");
        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        new MainActivity();
    }
}
