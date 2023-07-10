
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
/**
 *
 * @author rohan-manandhar
 */
public class AdminDeleteSupController {
    private final AdminDashboard view;
    private final AdminDeleteSupDatabase database;
    private boolean result;
    public boolean testdata;
    
    public AdminDeleteSupController (AdminDashboard view){
        this.view = view;
        view.addDeleteSupListener(new ButtonListener());
        this.database = new AdminDeleteSupDatabase();
    }
    
    class ButtonListener implements ActionListener 
    {
        @Override 
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == view.getBtnDeleteSup()) {
                int selectedRow = view.getSupTable().getSelectedRow();

                if (selectedRow != -1) {
                    String username = (String) view.getSupTable().getValueAt(selectedRow, 0);
                    deleteSupplier(username);
                } else {
                    showMessage("Please select a row.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private void deleteSupplier(String username) {
        result = false;
        if (database.checkSupplier(username)) {
            if (database.deleteSupplier(username)) {
                result = true;
                showMessage("Supplier deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessage("Failed to delete supplier.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessage("Supplier does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
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
