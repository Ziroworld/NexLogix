
package Controller;
import Model.*;
import View.*;
import java.sql.*;
import java.awt.event.*;
import Database.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author rohan-manandhar
 */
public class LoginController {
    loginModel Model;
    Loginwin View;
    Connection conn;
    
    public LoginController(Loginwin View)
    {
        this.View = View;
        View.addLoginListner(new LoginListener());
    }
    
    class LoginListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                Model = View.getUser();
                    String username = Model.getUsername();
                    String userType = checkUser(Model);

                    switch (userType) {
                        case "admin":
                            openAdminDashboard(username);
                            break;
                        case "customer":
                            openCustomerDashboard(username);
                            break;
                        case "supplier":
                            openSupplierDashboard(username);
                            break;
                        default:
                            View.clearme();
                            View.setMessage("Invalid username or password. ");
                            break;
                }
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
        
    public String checkUser(loginModel user) throws Exception {
        conn = getConnection.dbConnect();
        String username = user.getUsername();
        String password = user.getPassword();

        String sql1 = "SELECT * FROM customer WHERE username = ? AND password = ?";
        String sql2 = "SELECT * FROM supplier WHERE username = ? AND password = ?";
        String sql3 = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (PreparedStatement stmt1 = conn.prepareStatement(sql1);
             PreparedStatement stmt2 = conn.prepareStatement(sql2);
             PreparedStatement stmt3 = conn.prepareStatement(sql3)) {

            stmt1.setString(1, username);
            stmt1.setString(2, password);
            ResultSet rs1 = stmt1.executeQuery();

            stmt2.setString(1, username);
            stmt2.setString(2, password);
            ResultSet rs2 = stmt2.executeQuery();

            stmt3.setString(1, username);
            stmt3.setString(2, password);
            ResultSet rs3 = stmt3.executeQuery();

              if (rs1.next()) {
                return "customer";
            } else if (rs2.next()) {
                return "supplier";
            } else if (rs3.next()) {
                return "admin";
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("done");
        }

        return "";
    }
    
    public void openAdminDashboard(String username) {
        showMessage("Login successful as admin.", "Success", JOptionPane.INFORMATION_MESSAGE);
        View.killlogin();
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setUsername(username);
        adminDashboard.setVisible(true);
    }
    
    public void openCustomerDashboard(String username) {
        showMessage("Login successful as customer.", "Success", JOptionPane.INFORMATION_MESSAGE);
        View.killlogin();
        customerDashboard customerDashboard = new customerDashboard();
        customerDashboard.setUsername(username);
        customerDashboard.setVisible(true);
    }
    
    public void openSupplierDashboard(String username) {
        showMessage("Login successful as supplier.", "Success", JOptionPane.INFORMATION_MESSAGE);
        View.killlogin();
        supplierDashboard supplierDashboard = new supplierDashboard();
        supplierDashboard.setUsername(username);
        supplierDashboard.setVisible(true);

    }
    
    public void showMessage(String message, String title, int messageType) {
        JDialog dialog = new JDialog((Frame) null, title, true);
        JOptionPane optionPane = new JOptionPane(message, messageType);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setBackground(Color.DARK_GRAY);
        dialog.pack();

        // Set the dialog location to the center of the screen
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
    }   

}
