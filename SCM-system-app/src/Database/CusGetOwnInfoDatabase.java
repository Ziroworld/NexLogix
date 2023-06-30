
package Database;

import Model.CusOwnDataModel;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class CusGetOwnInfoDatabase {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public List<CusOwnDataModel> getCustomerData(String id){
        List<CusOwnDataModel> CustomerList = new ArrayList<>();
        
        try(Connection conn = getConnection.dbConnect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE username = ?")) {
            
            stmt.setString(1, id);
            
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    String username = rs.getString("username");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String password = rs.getString("password");
                    
                    CusOwnDataModel customer = new CusOwnDataModel(username, fname, lname, email, phone, password);
                    CustomerList.add(customer);
                }
            }
        } catch(SQLException e1){
            e1.printStackTrace();
        }
        
        return CustomerList;
    }
}
