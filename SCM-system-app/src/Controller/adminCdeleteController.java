
package Controller;
import View.*;
import Model.*;
import java.awt.event.*;
import java.sql.*;
import Database.*;
import javax.swing.JOptionPane;

public class adminCdeleteController {
    AdminCdeleteModel Model;
    AdminDashboard View;
    Connection conn;
    

    public adminCdeleteController(AdminDashboard View) {
        this.View = View;
        View.addLoginListner(new DeleteListener());
    }
    class DeleteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Model = View.getUser();
                if(deleteCustomer(Model)){
                    JOptionPane.showMessageDialog(View, "Customer deleted successfully.");
                }else{
                    JOptionPane.showMessageDialog(View, "Invalid ID!!");
                }
            }
            catch(Exception e1)
            {
                System.out.println(e1.getMessage());
            }
        }
        private boolean deleteCustomer(AdminCdeleteModel user) throws Exception {
            String username = user.getDeleteid();
            conn = getConnection.dbConnect();
            String sql = "DELETE FROM customer WHERE username = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                int rowsAffected = pstmt.executeUpdate();

                return rowsAffected > 0;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return false;
        }
    }
}
