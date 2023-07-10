
package scm.system.app;

import View.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author rohan-manandhar
 */
public class SCMSystemApp extends JWindow  {

    /**
     * @param args the command line arguments
     */
    private JLabel imageLabel;

    public SCMSystemApp() {
        // Set the size and position of the splash screen
        int width = 800;
        int height = 500;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setBounds(x, y, width, height);

        // Set the splash screen as non-resizable
//        setResizable(false);

        // Set the type of the splash screen window to utility
        setType(Window.Type.UTILITY);

        // Create and add the image label to the splash screen
        ImageIcon imageIcon = new ImageIcon("/home/rohan-manandhar/NetBeansProjects/NexLogix/src/View/imagePack/intro.png"); 
        imageLabel = new JLabel(imageIcon);
        getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Set a timer to close the splash screen after 7 seconds
        Timer timer = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSplashScreen();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void closeSplashScreen() {
        // Dispose the splash screen and open the login window
        dispose();
        Loginwin loginWindow = new Loginwin();
        loginWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SCMSystemApp splashScreen = new SCMSystemApp();
        splashScreen.setVisible(true);
    }
    
}
