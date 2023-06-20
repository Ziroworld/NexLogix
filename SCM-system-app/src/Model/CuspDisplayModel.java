
package Model;
import Database.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CuspDisplayModel {
    public List<CusProductViewModel> getProductData()
    {
        // creating a arraylist
       List <CusProductViewModel> productList = new ArrayList<>();
       
       try (Connection conn = getConnection.dbConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM product")) {

            while (rs.next()) {
                int pid = rs.getInt("PID");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String supplierUsername = rs.getString("supplier_username");

                CusProductViewModel product = new CusProductViewModel(pid, productName, productPrice, supplierUsername);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return productList;
    }
}
