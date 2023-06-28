
package Database;
import Model.*;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class SupGetOwnInfoDatabase {
    
    public List<SupOwnDataModel> getSupplierData(String username) {
        List<SupOwnDataModel> supplierList = new ArrayList<>();
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM supplier WHERE username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String companyName = rs.getString("company_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String password = rs.getString("password");
                    SupOwnDataModel supplier = new SupOwnDataModel(username, companyName, email, phone, password);
                    supplierList.add(supplier);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierList;
    }
}
