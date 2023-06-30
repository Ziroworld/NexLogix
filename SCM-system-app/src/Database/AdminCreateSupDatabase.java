
package Database;
import Model.AdminCreateSupModel;
import java.sql.*;
/**
 *
 * @author rohan-manandhar
 */
public class AdminCreateSupDatabase {
    public boolean isDataExist(String username, String companyname, String email, String phone) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM supplier WHERE username = ? OR company_name = ? OR email = ? OR phone = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, companyname);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertSupplier(AdminCreateSupModel model) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO supplier (username, company_name, email, phone, password) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, model.getUsername());
            stmt.setString(2, model.getCompanyname());
            stmt.setString(3, model.getEmail());
            stmt.setString(4, model.getPhone());
            stmt.setString(5, model.getPassword());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
