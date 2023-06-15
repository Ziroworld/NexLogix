/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
/**
 *
 * @author rohan-manandhar
 */
public class getConnection {
    public static Connection dbConnect(){
        try {
            String cUrl="jdbc:mysql://localhost:3306/SCMdatabase";
            String uName="root";
            String cPassword="iknow";
            return DriverManager.getConnection(cUrl, uName, cPassword);
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","iknow");
//            System.out.println("Connected to database.");
//            return conn;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
