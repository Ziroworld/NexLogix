
package Database;

import java.sql.*;



public class CusDeleteSelfDatabase {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean checkCustomer(int username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "SELECT * FROM customer WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, username);
            rs = stmt.executeQuery();
            return rs.next(); // Returns true if customer exists, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return false;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean deleteCustomer(int username) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection.dbConnect();
            String sql = "DELETE FROM customer WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, username);
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
