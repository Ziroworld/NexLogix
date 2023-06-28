
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class CusUpdateSelfController {
    customerDashboard view;
    CusUpdateSelfModel model;
    CusUpdateSelfDatabase database;

    public CusUpdateSelfController(customerDashboard view){
        this.view = view;
        view.AddUpdateButtonListener(new ButtonListener());
        database = new CusUpdateSelfDatabase();
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                model = view.getCdata();
                String username = model.getTxtusername();
                System.out.println(username);
                
                if (updateCustomer()) {
                    view.ClearMeData();
                    JOptionPane.showMessageDialog(null, "Customer data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update customer data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(HeadlessException e1)
            {
                e1.getMessage();
            }
        }
    }
    
    public boolean updateCustomer() {

        // Validate input fields
        if (model.getTxtusername().isEmpty() || model.getTxtfname().isEmpty() ||
                model.getTxtlname().isEmpty() || model.getTxtemail().isEmpty() ||
                model.getTxtphone().isEmpty() || model.getTxtpassword().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isPhoneValid(model.getTxtphone())) {
            JOptionPane.showMessageDialog(null, "Phone number must be at least 9 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email or phone already exist
        if (database.isEmailOrPhoneExist(model.getTxtemail(), model.getTxtphone())) {
            JOptionPane.showMessageDialog(null, "Email or phone number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Update customer data in the database
        if (database.updateCustomer(model)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPhoneValid(String phone) {
        return phone.length() >= 9;
    }
}
