
package Controller;
import View.*;
import Model.*;
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

public class SupUpdateProductController {
    private final supplierDashboard view;
    private SupUpdateProductModel model;
    private final SupUpdateProductDatabase database;
    private boolean result;
    public boolean testdata;
    
    public SupUpdateProductController(supplierDashboard view){
        this.view = view;
        view.addUpdateButtonListener(new ButtonListener());
        database = new SupUpdateProductDatabase();
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        @SuppressWarnings("CallToPrintStackTrace")
        public void actionPerformed( ActionEvent e ){
            
            try{
                result = false;
                model = view.getProductData();
                int pid = model.getPid();
                System.out.println(pid);
                
                // Check if the product exists in the database
                if (database.isProductExist(pid)) {
                    if (updateProduct()) {
                        result = true;
                        view.clearFields3();
                        showMessage("Product updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        showMessage("Failed to update product.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    showMessage("Product does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    public boolean testdata(){
        return result;
    }
    
    private boolean updateProduct() {
        // Validate input fields
        if (model.getProductname().isEmpty() || model.getProductprice() == null) {
            showMessage("Product name and price are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Update product name and price in the database
        if (database.updateProduct(model.getPid(), model.getProductname(), model.getProductprice())) {
            return true;
        } else {
            return false;
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
