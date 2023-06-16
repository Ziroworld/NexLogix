
package Controller;
import Database.getConnection;
import View.*;
import Model.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author rohan-manandhar there is a bug in the controller which i will solve later sprint
 */
public class AdminCreateCustomerController {
    AdminDashboard View;
    AdminCreateCustomerModel Model;
    Connection conn;
    
    public AdminCreateCustomerController(AdminDashboard View)
    {
        this.View = View;
        View.addButtonListener(new ButtonListener());
    }
    
    
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                Model = View.getCUser();
                insertUser(Model);
//                if (validateUserData(Model)) {
//                    if (checkUser(Model)) {
//                        View.setMessage("Username already exists.");
//                    } else {
//                        if (insertUser(Model)) {
//                            View.setMessage("User registered successfully.");
//                            
//                        } else {
//                            View.setMessage("Failed to register user.");
//                        }
//                    }
//                } else {
//                    View.setMessage("Invalid user data.");
//                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
            
        }
    }
    
    public boolean validateUserData(AdminCreateCustomerModel user) {
        // Perform validation checks on user data
        String username = user.getUsername();
        String fname = user.getFname();
        String lname = user.getLname();
        String email = user.getEmail();
        int phone = user.getPhone();
        String password = user.getPassword();

        if (username.isEmpty() || fname.isEmpty() || lname.isEmpty() || 
            email.isEmpty() || password.isEmpty()) {
            View.setMessage("Some Field are missing");
            return false; // Empty fields not allowed
        }
        
        return false;
    }
        
    public boolean checkUser(AdminCreateCustomerModel user) throws Exception
       {
           conn = getConnection.dbConnect();
           String username = user.getUsername();

           String sql = "SELECT * FROM customer WHERE username = ?";

           try (PreparedStatement stmt = conn.prepareStatement(sql)) {
               stmt.setString(1, username);
               ResultSet rs = stmt.executeQuery();

               return rs.next(); // Returns true if user exists, false otherwise
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           } finally {
               // Close the resources (stmt, conn) here if not closed already
           }

           return false;
       }
    
    
    public boolean insertUser(AdminCreateCustomerModel user) throws Exception 
    {
        conn = getConnection.dbConnect();
        
        String username = user.getUsername();
        String fname = user.getFname();
        String lname = user.getLname();
        String email = user.getEmail();
        int phone = user.getPhone();
        String password = user.getPassword();
        
        System.out.println(username);
        System.out.println(password);
        
//        String sql = "INSERT INTO customer (username, fname, lname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, username);
//            stmt.setString(2, fname);
//            stmt.setString(3, lname);
//            stmt.setString(4, email);
//            stmt.setInt(5, phone);
//            stmt.setString(6, password);
//
//            int rowsAffected = stmt.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            // Close the resources (stmt, conn) here if not closed already
//        }
//        
        return false;
    }
}
    

