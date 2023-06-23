
package Model;

import Database.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AdminGetProdDataModel {
    @SuppressWarnings("CallToPrintStackTrace")
    public List<AdminSendProdDataModel> getProdData() {
        List<AdminSendProdDataModel> prodList = new ArrayList<>();

        try (Connection conn = getConnection.dbConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM product")) {

            while (rs.next()) {
                int pid = rs.getInt("pid");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String supplierUsername = rs.getString("supplier_username");

                AdminSendProdDataModel product = new AdminSendProdDataModel(pid, productName, productPrice, supplierUsername);
                prodList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodList;
    }
}
