
package Database;
import java.sql.*;
import Model.*;

public class CusUpdateSelfDatabase {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean updateCustomer(CusUpdateSelfModel model) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("UPDATE customer SET fname = ?, lname = ?, email = ?, phone = ?, password = ? WHERE username = ?")) {
            stmt.setString(1, model.getTxtfname());
            stmt.setString(2, model.getTxtlname());
            stmt.setString(3, model.getTxtemail());
            stmt.setString(4, model.getTxtphone());
            stmt.setString(5, model.getTxtpassword());
            stmt.setString(6, model.getTxtusername());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean isEmailOrPhoneExist(String email, String phone) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE email = ? OR phone = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, phone);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
