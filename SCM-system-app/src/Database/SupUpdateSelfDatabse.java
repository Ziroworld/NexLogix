
package Database;
import java.sql.*;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class SupUpdateSelfDatabse {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean updateSupplier(SupUpdateSelfModel model) {
        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("UPDATE supplier SET company_name = ?, email = ?, phone = ?, password = ? WHERE username = ?")) {
            stmt.setString(1, model.getCompanyname());
            stmt.setString(2, model.getEmail());
            stmt.setString(3, model.getPhone());
            stmt.setString(4, model.getPassword());
            stmt.setString(5, model.getUsername());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
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
