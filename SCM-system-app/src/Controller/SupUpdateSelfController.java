
package Controller;
import View.*;
import Model.*;
import Database.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class SupUpdateSelfController {
    supplierDashboard view;
    SupUpdateSelfModel model;
    SupUpdateSelfDatabse database;
    
    
    public SupUpdateSelfController(supplierDashboard view){
        this.view = view;
        view.addUpdateListener(new ButtonListener());
        database = new SupUpdateSelfDatabse();
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        @SuppressWarnings("CallToPrintStackTrace")
        public void actionPerformed (ActionEvent e)
        {
            try {
                model = view.getSdata();
                String username = model.getUsername();
                System.out.println(username);

                // Retrieve the existing supplier data
                List<SupOwnDataModel> existingData = database.getSupplierData(username);

                if (updateSupplier(existingData)) {
                    view.clearField();
                    JOptionPane.showMessageDialog(null, "Supplier data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update supplier data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException e1) {
                e1.printStackTrace();
            }
        }
    }
    public boolean updateSupplier(List<SupOwnDataModel> existingData) {
        // Validate input fields
        if (model.getUsername().isEmpty() || model.getCompanyname().isEmpty() ||
                model.getEmail().isEmpty() || model.getPhone().isEmpty() ||
                model.getPassword().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isPhoneValid(model.getPhone())) {
            JOptionPane.showMessageDialog(null, "Phone number must be at least 9 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if the email, phone, or company name already exist (excluding the existing values)
        for (SupOwnDataModel data : existingData) {
            if (!model.getEmail().equals(data.getEmail()) && model.getEmail().equals(data.getCompanyname())) {
                JOptionPane.showMessageDialog(null, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!model.getPhone().equals(data.getPhone()) && model.getPhone().equals(data.getPhone())) {
                JOptionPane.showMessageDialog(null, "Phone number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!model.getCompanyname().equals(data.getCompanyname()) && model.getCompanyname().equals(data.getCompanyname())) {
                JOptionPane.showMessageDialog(null, "Company name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Update supplier data in the database
        if (database.updateSupplier(model)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPhoneValid(String phone) {
        return phone.length() >= 9;
    }
    
}
