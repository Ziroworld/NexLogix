
package Controller;
import View.*;
import Model.*;
import Database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class SupplierAddProductController {
    
    supplierDashboard View;
    SupplierAddProductModel Model;
    Connection Conn;
    
    public SupplierAddProductController(supplierDashboard View)
    {
        this.View = View;
        View.addProductListener(new supplierProductListener());
        
    }
    
    class supplierProductListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                Model = View.getProduct();
                if (validateSupplier(Model.getSuppliername())) {
                    insertProductData(Model);
                    JOptionPane.showMessageDialog(null, "Product added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid supplier name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (SQLException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
    }
    
    
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
    
    
    // checking if the value came or not
//    public void Checkingdata(SupplierAddProductModel product)
//    {
//        String productname;
//        productname = product.getProductname();
//        System.out.println(productname);
//    }
//    
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
