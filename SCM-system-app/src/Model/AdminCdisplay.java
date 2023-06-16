/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Database.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author rohan-manandhar
 */
public class AdminCdisplay {
    public List<AdminCmodel> getCustomerData() {
        List<AdminCmodel> customerList = new ArrayList<>();

        try (Connection conn = getConnection.dbConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customer")) {

            while (rs.next()) {
                String username = rs.getString("username");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");

                AdminCmodel customer = new AdminCmodel(username, fname, lname, email, phone, password);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}
