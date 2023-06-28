
package Model;

import Database.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SupOrderViewModel {
    
    public List<SupOrderDataModel> getOrderData(String checkId) {
        List<SupOrderDataModel> orderList = new ArrayList<>();
        
        try (Connection conn = getConnection.dbConnect();
            PreparedStatement stmt = conn.prepareStatement("SELECT id, customer_username, product_id FROM `order` WHERE supplier_username = ?")) {
            stmt.setString(1, checkId); // Set the username parameter

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int orderId = rs.getInt("id");
                    String customerName = rs.getString("customer_username");
                    int productId = rs.getInt("product_id");

                    SupOrderDataModel order = new SupOrderDataModel(orderId, customerName, productId);
                    orderList.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
