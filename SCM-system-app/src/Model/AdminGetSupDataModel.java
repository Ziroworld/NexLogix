
package Model;

import Database.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminGetSupDataModel {
    @SuppressWarnings("CallToPrintStackTrace")
    public List<AdminSendSupDataModel> getSupData() {
        List<AdminSendSupDataModel> supList = new ArrayList <>(); // creatin a arraylist
        
        try (Connection conn = getConnection.dbConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM supplier")) {
            
            while(rs.next()){
                String username = rs.getString("username");
                String companyName = rs.getString("company_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");

                AdminSendSupDataModel supplier = new AdminSendSupDataModel(username, companyName, email, phone, password);
                supList.add(supplier);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return supList;
    }
}
