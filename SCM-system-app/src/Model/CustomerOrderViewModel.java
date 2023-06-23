
package Model;

import Database.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderViewModel {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public List<CustomerOrderDataModel> getOrderData(String username) {
        List<CustomerOrderDataModel> orderList = new ArrayList<>();

        try (Connection conn = getConnection.dbConnect();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, customer_username, product_id FROM `order` WHERE customer_username = ?")) {
            stmt.setString(1, username); // Set the username parameter

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int orderId = rs.getInt("id");
                    String customerName = rs.getString("customer_username");
                    int productId = rs.getInt("product_id");

                    CustomerOrderDataModel order = new CustomerOrderDataModel(orderId, customerName, productId);
                    orderList.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
