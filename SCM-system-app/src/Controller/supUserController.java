
package Controller;

import Model.*;
import View.*;
import java.awt.event.*;
import java.sql.*;
import Database.*;
/**
 *
 * @author rohan-manandhar
 */
public class supUserController {
    
    supRegistration View;
    supRegModel Model;
    Connection conn;
    
    public supUserController(supRegistration View)
    {
        this.View = View;
        View.addsRegisterListener(new supRegisterListener());
    }
    
    class supRegisterListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent e)
        {
            try {
                Model = View.getUser();
                if (validateSupplierData(Model)) {
                    if (checkSupplier(Model)) {
                        View.setMessage("Supplier already exists.");
                    } else {
                        if (insertSupplier(Model)) {
                            View.setMessage("Supplier registered successfully.");
                        } else {
                            View.setMessage("Failed to register supplier.");
                        }
                    }
                } else {
                    View.setMessage("Invalid supplier data.");
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
    }
    
    
    public boolean validateSupplierData(supRegModel supplier) {
        // Perform validation checks on supplier data
        String username = supplier.getUsername();
        String companyName = supplier.getCompanyname();
        String email = supplier.getEmail();
        int phone = supplier.getPhone();
        String password = supplier.getPassword();
        String cpassword = supplier.getCpassword();
        
        if (username.isEmpty() || companyName.isEmpty() ||
            email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            View.setMessage("Some Field are empty !!");
            return false; // Empty fields not allowed
        }
        
        if (!emailIsValid(email)) {
            View.setMessage("Invalid Email, Duplication found !!");
            return false; // Invalid email format
        }

        if (!password.equals(cpassword)) {
            View.setMessage("Password and ConfirmPassword doesnot match.");
            return false; // Passwords do not match
        }        
        return true; // Supplier data is valid
    }
    
    // checkSupplier
    public boolean checkSupplier(supRegModel supplier) throws Exception 
    {
        conn = getConnection.dbConnect();
        String username = supplier.getUsername();

        String sql = "SELECT * FROM supplier WHERE username = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Returns true if supplier exists, false otherwise
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the resources (stmt, conn) here if not closed already
        }
        
        return false;
    }
    
    // data insertion 
    public boolean insertSupplier(supRegModel supplier) throws Exception {
        conn = getConnection.dbConnect();
        
        String username = supplier.getUsername();
        String companyName = supplier.getCompanyname();
        String email = supplier.getEmail();
        int phone = supplier.getPhone();
        String password = supplier.getPassword();
        
        String sql = "INSERT INTO supplier (username, company_name, email, phone, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, companyName);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setString(5, password);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the resources (stmt, conn) here if not closed already
        }
        
        return false;
    }
    
    // email validiation
    public boolean emailIsValid(String email) 
    {
        // Check if the email format is valid using a regular expression
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            View.setMessage("Invalid Email format !!");
            return false; // Invalid email format
        }

        // Check if the email already exists in the supplier table
        conn = getConnection.dbConnect();
        String sql = "SELECT * FROM supplier WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            return !rs.next(); // Returns true if email does not exist, false otherwise
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the resources (stmt, conn) here if not closed already
        }

        return false;
    }

}
