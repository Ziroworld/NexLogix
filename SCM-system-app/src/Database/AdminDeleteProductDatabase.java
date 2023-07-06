
package Database;
import java.sql.*;
/**
 *
 * @author rohan-manandhar
 */
public class AdminDeleteProductDatabase {
    
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean checkProduct(int pid){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM product WHERE pid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pid);
            rs = stmt.executeQuery();
            return rs.next(); // Returns true if product exists, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return false;
    }
    
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean deleteProduct(int pid){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "DELETE FROM product WHERE pid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pid);
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
