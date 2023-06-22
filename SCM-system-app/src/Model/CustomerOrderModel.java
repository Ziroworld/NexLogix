
package Model;
import java.sql.*;
import Database.*;

public class CustomerOrderModel {
    String cusername;
    int pid;
    String susername;
    
    public CustomerOrderModel(String cusername, int pid, String susername){
        this.cusername = cusername;
        this.pid = pid;
        this.susername = susername;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean insertOrder(String cUsername, int pid, String sUsername) {
        // Return true if the insertion is successful, false otherwise
        
        boolean success = false;
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `order` (customer_username, product_id, supplier_username) VALUES (?, ?, ?)")) {
            stmt.setString(1, cUsername);
            stmt.setInt(2, pid);
            stmt.setString(3, sUsername);
            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
