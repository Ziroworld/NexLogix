
package Controller;
import View.*;
import Database.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SupDeleteSelfController {
    private final supplierDashboard view;
    private SupDeleteSelfDatabase database;
    Loginwin initLogin;
    
    public SupDeleteSelfController(supplierDashboard view){
        this.view = view;
        view.addDeleteButtonListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent e){
        
            if (e.getSource() == view.getBtnDeleteProfile()){
                int selectedRow = view.getProfileTable().getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) view.getProfileTable().getValueAt(selectedRow, 0);
                    deleteProfile(username);
                } else {
                    showMessage("Please Select a row.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public void deleteProfile(String username){
        database = new SupDeleteSelfDatabase();
        
        if (database.checkSupplier(username)) {
            if (database.deleteSupplier(username)) {
                showMessage("Profile deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                view.closeDash();
                initLogin = new Loginwin();
                initLogin.setVisible(true);
            } else {
                showMessage("Failed to delete profile.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessage("Supplier does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void showMessage(String message, String title, int messageType) {
        JDialog dialog = new JDialog((Frame) null, title, true);
        JOptionPane optionPane = new JOptionPane(message, messageType);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setBackground(Color.DARK_GRAY);
        dialog.pack();

        // Set the dialog location to the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int dialogWidth = dialog.getWidth();
        int dialogHeight = dialog.getHeight();
        int dialogX = (screenSize.width - dialogWidth) / 2;
        int dialogY = (screenSize.height - dialogHeight) / 2;
        dialog.setLocation(dialogX, dialogY);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }
}
