
package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupUpdateProductDatabase {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean updateProduct(int pid, String productName, Double productPrice) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("UPDATE product SET product_name = ?, product_price = ? WHERE pid = ?")) {
            stmt.setString(1, productName);
            stmt.setDouble(2, productPrice);
            stmt.setInt(3, pid);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean isProductExist(int pid) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE pid = ?")) {
            stmt.setInt(1, pid);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
