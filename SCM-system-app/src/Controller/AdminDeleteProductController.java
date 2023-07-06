
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
public class AdminDeleteProductController {
    
    private AdminDashboard view;
    private AdminDeleteProductDatabase database;
    
    public AdminDeleteProductController(AdminDashboard view){
        this.view = view;
        this.database = new AdminDeleteProductDatabase();
        view.addDeleteProdListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            
            if (e.getSource() == view.getBtnDeleteProd()){
                int selectedRow = view.getProductTable().getSelectedRow();
                
                if (selectedRow != 1 ){
                    int pid = (int) view.getProductTable().getValueAt(selectedRow, 0);
                    deleteProduct(pid);
                }else {
                    showMessage("Please select a row.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public void deleteProduct(int pid){
        if (database.checkProduct(pid)) {
            if (database.deleteProduct(pid)) {
                showMessage("Product deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessage("Failed to delete Product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessage("Product does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
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
