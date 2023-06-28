/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import Database.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author rohan-manandhar
 */
public class cusUserController {
    
    private final CusRegistration View;
    private cusRegModel Model;
    Connection conn;
    
    public cusUserController(CusRegistration View)
    {
        this.View = View;
        View.addcRegisterListner(new cusRegisterListener());
    }
    
    class cusRegisterListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                Model = View.getUser();
                if (validateUserData(Model)) {
                    if (checkUser(Model)) {
                        View.setMessage("Username already exists.");
                    } else {
                        if (insertUser(Model)) {
                            View.setMessage("User registered successfully.");
                            
                        } else {
                            View.setMessage("Failed to register user.");
                        }
                    }
                } else {
                    View.setMessage("Invalid user data.");
                }
            } catch (Exception e1) {
                View.setMessage("Invalid user data.");
            }
            
        }
    }
    
    public boolean validateUserData(cusRegModel user) {
        // Perform validation checks on user data
        String username = user.getUsername();
        String fname = user.getFname();
        String lname = user.getLname();
        String email = user.getEmail();
        int phone = user.getPhone();
        String password = user.getPassword();
        String cpassword = user.getCpassword();
        
        if (username.isEmpty() || fname.isEmpty() || lname.isEmpty() || 
            email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            View.setMessage("Some Field are missing");
            return false; // Empty fields not allowed
        }
        
        if (!emailIsValid(email)) {
            View.setMessage("Invalid email, Duplication found !!");
            return false; // Invalid email format
        }
        
        if (!password.equals(cpassword)) {
            View.setMessage("Password and confirm-Password doesnot match !!!");
            return false; // Passwords do not match
        }
        
        return true; // User data is valid
    }
    
    
    public boolean checkUser(cusRegModel user) throws Exception
    {
        String username = user.getUsername();
        conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM customer WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            return rs.next(); // Returns true if user exists, false otherwise
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }
    
    // inserting the data
    public boolean insertUser(cusRegModel user) throws Exception {
        String username = user.getUsername();
        String fname = user.getFname();
        String lname = user.getLname();
        String email = user.getEmail();
        int phone = user.getPhone();
        String password = user.getPassword();
        conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "INSERT INTO customer (username, fname, lname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setString(4, email);
            stmt.setInt(5, phone);
            stmt.setString(6, password);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }
    
    
    public boolean emailIsValid(String email) {
        // Implement email validation logic
        if (email.isEmpty()) {
            return false; // Empty email not allowed
        }

        // Check if the email format is valid using a regular expression
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            return false; // Invalid email format
        }

        conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM customer WHERE email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            return !rs.next(); // Returns true if email does not exist, false otherwise
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return false; // Placeholder - assumes all emails are valid
    }
}

