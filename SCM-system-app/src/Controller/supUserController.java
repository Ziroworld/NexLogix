
package Controller;

import Model.supRegModel;
import View.supRegistration;
import Database.getConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class supUserController {

    private final supRegistration view;
    private supRegModel model;
    private Connection conn;
    private boolean result;
    public boolean testdata;
    
    public supUserController(supRegistration view) {
        this.view = view;
        view.addsRegisterListener(new supRegisterListener());
    }

    class supRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                result = false;
                model = view.getUser();
                if (validateSupplierData(model)) {
                    if (checkSupplier(model)) {
                        showMessage("Supplier already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (hasSpaceInUsername(model.getUsername())) {
                            showMessage("Username cannot contain spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (insertSupplier(model)) {
                                result = true;
                                showMessage("Supplier registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                view.clearme();
                                view.openLogin();
                            } else {
                                showMessage("Failed to register supplier.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (Exception e1) {
                showMessage("Invalid supplier data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean testdata(){
        return result;
    }
    public boolean validateSupplierData(supRegModel supplier) {
        String username = supplier.getUsername();
        String companyName = supplier.getCompanyname();
        String email = supplier.getEmail();
        int phone = supplier.getPhone();
        String password = supplier.getPassword();
        String cpassword = supplier.getCpassword();

        if (username.isEmpty() || companyName.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
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

        return true; // Supplier data is valid
    }

    public boolean checkSupplier(supRegModel supplier) {
        String username = supplier.getUsername();
        conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM supplier WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            return rs.next(); // Returns true if supplier exists, false otherwise
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(rs, stmt, conn);
        }

        return false;
    }

    public boolean insertSupplier(supRegModel supplier) {
        String username = supplier.getUsername();
        String companyName = supplier.getCompanyname();
        String email = supplier.getEmail();
        int phone = supplier.getPhone();
        String password = supplier.getPassword();
        conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "INSERT INTO supplier (username, company_name, email, phone, password) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
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
            String sql = "SELECT * FROM supplier WHERE email = ?";
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
