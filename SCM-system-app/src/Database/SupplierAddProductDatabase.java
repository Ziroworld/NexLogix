
package Database;

import Model.SupplierAddProductModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SupplierAddProductDatabase {
    Connection Conn;
    
    public boolean validateSupplier(String supplierName) throws SQLException {
        Conn = getConnection.dbConnect();
        String sql = "SELECT * FROM supplier WHERE username = ?";
        try (PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setString(1, supplierName);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if the supplier exists, false otherwise
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void insertProductData(SupplierAddProductModel product) throws SQLException {
        Conn = getConnection.dbConnect();
        String sql = "INSERT INTO product (product_name, product_price, supplier_username) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductname());
            pstmt.setDouble(2, product.getProductprice());
            pstmt.setString(3, product.getSuppliername());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
