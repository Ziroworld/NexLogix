
package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupDeleteProductController {
    private final supplierDashboard View;
    private SupDeleteProductModel model;
    
    public SupDeleteProductController(supplierDashboard View){
        this.View = View;
        this.View.addButtonListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
//            checksdata();
            System.out.println("done boi");
            if (e.getSource() == View.getBtnDeleteProduct()) {
                System.out.println("button clicked");
                int selectedRow = View.getProductTable().getSelectedRow();
                System.out.println(selectedRow);
                if (selectedRow != -1) {
                    int pid = (int) View.getProductTable().getValueAt(selectedRow, 0);
                    deleteProduct(pid);
                } else {
                    View.displayErrorMessage("Please select a row to delete.");
                }
            }
        }
    }
    
    // ximply checking the value
    public void checksdata(){
        System.out.println("checking data");
    }
    
    // Main deletion func for deleting product
    public void deleteProduct(int pid) {
        model = new SupDeleteProductModel();
        System.out.println("Deleting product with PID: " + pid);
        if (model.checkProductExist(pid)) {
            System.out.println("Product found. Deleting...");
            if (model.deleteProduct(pid)) {
                System.out.println("Product deleted successfully.");
                View.displaySuccessMessage("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete product.");
                View.displayErrorMessage("Failed to delete product.");
            }
        } else {
            System.out.println("Product not found.");
            View.displayErrorMessage("Product not found.");
        }
    }
}
