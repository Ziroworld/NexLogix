
package Controller;
import Model.*;
import View.*;
import Database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author rohan-manandhar
 */
public class cusUserController {
private final CusRegistration view;
    private cusRegModel model;
    private Connection conn;
    private boolean result;
    public boolean testdata;
    
    public cusUserController(CusRegistration view) {
        this.view = view;
        this.view.addcRegisterListner(new cusRegisterListener());
    }

    class cusRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                result = false;
                model = view.getUser();
                if (validateUserData(model)) {
                    if (checkUser(model)) {
                        showMessage("Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (hasSpaceInUsername(model.getUsername())) {
                            showMessage("Username cannot contain spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (insertUser(model)) {
                                result = true;
                                showMessage("User registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                view.Clearme();
                                view.openLogin();
                            } else {
                                showMessage("Failed to register user.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (Exception e1) {
                showMessage("Invalid user data.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    
    public boolean testdata(){
        return result;
    }
    
    public boolean validateUserData(cusRegModel user) {
        String username = user.getUsername();
        String fname = user.getFname();
        String lname = user.getLname();
        String email = user.getEmail();
        int phone = user.getPhone();
        String password = user.getPassword();
        String cpassword = user.getCpassword();

        if (username.isEmpty() || fname.isEmpty() || lname.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            showMessage("All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Empty fields not allowed
        }

        if (!emailIsValid(email)) {
            showMessage("Invalid email format or already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Invalid email format or duplicate email
        }

        if (password.length() < 8) {
            showMessage("Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Password length should be at least 8 characters
        }

        if (!password.equals(cpassword)) {
            showMessage("Password and confirm password do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Passwords do not match
        }

        return true; // User data is valid
    }

    public boolean checkUser(cusRegModel user) {
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
            closeResources(rs, stmt, conn);
        }

        return false;
    }

    public boolean insertUser(cusRegModel user) {
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
            closeResources(null, stmt, conn);
        }

        return false;
    }

    public boolean emailIsValid(String email) {
        if (email.isEmpty()) {
            return false; // Empty email not allowed
        }

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
            closeResources(rs, stmt, conn);
        }

        return false;
    }

    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
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

    public void showMessage(String message, String title, int messageType) {
        JDialog dialog = new JDialog((Frame) null, title, true);
        JOptionPane optionPane = new JOptionPane(message, messageType);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setBackground(Color.DARK_GRAY);
        dialog.pack();

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
    
    public boolean hasSpaceInUsername(String username) {
        return username.contains(" ");
    }
}

