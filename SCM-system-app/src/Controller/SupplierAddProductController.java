
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
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SupplierAddProductController {
    
    private supplierDashboard View;
    private SupplierAddProductModel Model;
    private SupplierAddProductDatabase database;
    Connection Conn;
    
    public SupplierAddProductController(supplierDashboard View)
    {
        this.View = View;
        View.addProductListener(new supplierProductListener());
        this.database = new SupplierAddProductDatabase();
    }
    
    class supplierProductListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                Model = View.getProduct();
                if (database.validateSupplier(Model.getSuppliername())) {
                    database.insertProductData(Model);
                    View.clearAddField();
                    showMessage("Product added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    showMessage("Invalid supplier name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (SQLException e1)
            {
                System.out.println(e1.getMessage());
            }
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
