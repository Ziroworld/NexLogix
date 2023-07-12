
package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import Database.*;
import java.awt.event.ActionListener;

public class CustomerOrderController {
    private final customerDashboard view;
    private CustomerOrderModel model;
    private boolean result;
    public boolean testdata;

    public CustomerOrderController(customerDashboard view) {
        this.view = view;
        view.addOrderButtonListener(new OrderButtonListener());
    }
    
    
    class OrderButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            result = false;
            if (e.getSource() == view.getBtnAddOrder()) {
                model = view.getOrder();
                String cUsername = model.getCusername();
                int pid = model.getPid();
                String sUsername = model.getSusername();
                // checking pid if string is converted to int or not
                System.out.println(pid);
                
                //Perform validation checks
                if (validateOrderData(cUsername, pid, sUsername)) {
                    // Check if PID and supplier exist in their respective tables
                    if (validateProduct(pid) && validateSupplier(sUsername)) {
                        // Insert the order data into the "order" table
                        if (model.insertOrder(cUsername, pid, sUsername)) {
                            result = true;
                            view.showMessage("Order added successfully.");
                            // Clear the input fields
                            view.orderclearFields();
                        } else {
                            view.showMessage("Failed to add order.");
                        }
                    } else {
                        view.showMessage("Invalid PID or supplier.");
                    }
                } else {
                    view.showMessage("Invalid order data.");
                }
            }
        }
    }
    
    public boolean testdata(){
        return result;
    }
    
    // empty field validation
    private boolean validateOrderData(String cUsername, int pid, String sUsername) {
        return !cUsername.isEmpty() && pid > 0 && !sUsername.isEmpty();
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    private boolean validateProduct(int pid) {
        // Return true if valid, false otherwise
        boolean productExists = false;
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE pid = ?")) {
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            productExists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productExists;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private boolean validateSupplier(String sUsername) {
        // Return true if valid, false otherwise
        
        boolean supplierExists = false;
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM supplier WHERE username = ?")) {
            stmt.setString(1, sUsername);
            ResultSet rs = stmt.executeQuery();
            supplierExists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierExists;
    }
}
