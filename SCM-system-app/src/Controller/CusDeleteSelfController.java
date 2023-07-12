
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


public class CusDeleteSelfController {
    private final customerDashboard view;
    private CusDeleteSelfDatabase database;
    private boolean result;
    public boolean testdata;
    
    public CusDeleteSelfController(customerDashboard view){
        this.view = view;
        view.AddSelfDeleteListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent e){
            
            if (e.getSource() == view.getDeleteButton()){
                int selectedRow = view.getCusTable().getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) view.getCusTable().getValueAt(selectedRow, 0);
                    deleteProfile(username);
                } else {
                    showMessage("Please Select a row.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    //deleting profile
    public void deleteProfile(String username){
        database = new CusDeleteSelfDatabase();
        result = false;
        if (database.checkCustomer(username)) {
            if (database.deleteCustomer(username)) {
                result = true;
                showMessage("Profile deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Additional actions after deleting the profile
            } else {
                showMessage("Failed to delete profile.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessage("Customer does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean testdata(){
        return result;
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
