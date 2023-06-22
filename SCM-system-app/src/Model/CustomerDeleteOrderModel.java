
package Model;
import Database.*;
import java.sql.*;

public class CustomerDeleteOrderModel {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public Boolean checkOrder(int orderid){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM `order` WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderid);
            rs = stmt.executeQuery();
            return rs.next(); // Returns true if order exists, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return false;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean deleteOrder(int orderId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "DELETE FROM `order` WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if rows are affected, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }

        return false;
    }

    
    @SuppressWarnings("CallToPrintStackTrace")
    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
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
            e.printStackTrace();
        }
    }
}
