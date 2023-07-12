
package Controller;
import View.*;
import Model.*;
import Database.*;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AdminCreateSupController {
    private final AdminDashboard view;
    private AdminCreateSupModel model;
    private final AdminCreateSupDatabase database;
    private boolean result;
    public boolean testdata;
    
    public AdminCreateSupController(AdminDashboard view){
        this.view = view;
        view.addCreateSupListener(new ButtonListener());
        database = new AdminCreateSupDatabase();
    }
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                result = false;
                model = view.getSupUSer();
                
                if (validateInput(model)) {
                    if (checkExistingData(model)) {
                        JOptionPane.showMessageDialog(null, "Username, Company Name, Email, or Phone number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (insertSupplierData(model)) {
                            result = true;
                            JOptionPane.showMessageDialog(null, "Supplier created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            view.clearFields2();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to create supplier.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            catch(HeadlessException e1){
                e1.getMessage();
            }
        }
    }
    public boolean testdata(){
        return result;
    }
        private boolean validateInput(AdminCreateSupModel model) {
        String username = model.getUsername();
        String companyname = model.getCompanyname();
        String email = model.getEmail();
        String phone = model.getPhone();
        String password = model.getPassword();
        
        if (username.isEmpty() || companyname.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    // validiating email
    private boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(emailRegex)) {
            view.setMessage("Invalid email format.");
            return false; // Invalid email format
        }

        return true; // Email is valid
    }
    // sending to database
    private boolean checkExistingData(AdminCreateSupModel model) {
        String username = model.getUsername();
        String companyname = model.getCompanyname();
        String email = model.getEmail();
        String phone = model.getPhone();
        
        return database.isDataExist(username, companyname, email, phone);
    }
    
    private boolean insertSupplierData(AdminCreateSupModel model) {
        return database.insertSupplier(model);
    }
}
