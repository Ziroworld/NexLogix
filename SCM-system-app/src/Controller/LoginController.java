
package Controller;
import Model.*;
import View.*;
import java.sql.*;
import java.awt.event.*;
import Database.*;
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
            try
            {
                Model = View.getUser();
                if(checkUser(Model))
                {
                    View.setMessage("Login Sucessfully");
//                    adminDashboard a1 = new adminDashboard();
                    
                    // default to admin until fither validaiate
                    
//                    a1.setVisible(true);
                    View.killlogin();
                    
                }
                else
                {
                    View.setMessage("Invalid Username or password.");
                }
            }
            catch (Exception e1)
            {
                System.out.println(e1.getMessage());
            }
        }
        public boolean checkUser (loginModel user) throws Exception
        {
            conn = getConnection.dbConnect();
            String username = user.getUsername();
            String password = user.getPassword();
//            String userType = "";
            
//            System.out.println(username + " and " + password);
            String sql1 = "SELECT * FROM customer WHERE username = ? AND password = ?";
            String sql2 = "SELECT * FROM supplier WHERE username = ? AND password = ?";
            String sql3 = "SELECT * FROM admin WHERE username = ? AND password = ?";
            try 
               (PreparedStatement stmt1 = conn.prepareStatement(sql1);
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                PreparedStatement stmt3 = conn.prepareStatement(sql3)) 
            {
                
                stmt1.setString(1, username);
                stmt1.setString(2, password);
                ResultSet rs1 = stmt1.executeQuery();

                stmt2.setString(1, username);
                stmt2.setString(2, password);
                ResultSet rs2 = stmt2.executeQuery();

                stmt3.setString(1, username);
                stmt3.setString(2, password);
                ResultSet rs3 = stmt3.executeQuery();
                
                // validation of data with return string var for diffrent dashboard frame
                
                //
                if (rs1.next() || rs2.next() || rs3.next()) {
                    return true;
                }
               
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           } finally {
               // Closing the resources (rs, stmt, conn) here if not closed already
           }
            return false;
        }

    }
    
}
