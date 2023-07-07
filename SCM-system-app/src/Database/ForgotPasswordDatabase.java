
package Database;
import Model.*;
import java.sql.*;
public class ForgotPasswordDatabase {
    private Connection conn;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean checkUser(String username) {
        conn = getConnection.dbConnect();
        String sql1 = "SELECT * FROM customer WHERE username = ?";
        String sql2 = "SELECT * FROM supplier WHERE username = ?";
        String sql3 = "SELECT * FROM admin WHERE username = ?";

        try (PreparedStatement stmt1 = conn.prepareStatement(sql1);
             PreparedStatement stmt2 = conn.prepareStatement(sql2);
             PreparedStatement stmt3 = conn.prepareStatement(sql3)) {

            stmt1.setString(1, username);
            ResultSet rs1 = stmt1.executeQuery();

            stmt2.setString(1, username);
            ResultSet rs2 = stmt2.executeQuery();

            stmt3.setString(1, username);
            ResultSet rs3 = stmt3.executeQuery();

            if (rs1.next() || rs2.next() || rs3.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean passwordUpdated(ForgotPasswordModel model) {
        conn = getConnection.dbConnect();
        String username = model.getUsername();
        String newPassword = model.getNewpasswords();

        String sql1 = "UPDATE customer SET password = ? WHERE username = ?";
        String sql2 = "UPDATE supplier SET password = ? WHERE username = ?";
        String sql3 = "UPDATE admin SET password = ? WHERE username = ?";

        try {
            try (PreparedStatement stmt1 = conn.prepareStatement(sql1);
             PreparedStatement stmt2 = conn.prepareStatement(sql2);
             PreparedStatement stmt3 = conn.prepareStatement(sql3)) {

            stmt1.setString(1, newPassword);
            stmt1.setString(2, username);
            int rows1 = stmt1.executeUpdate();

            stmt2.setString(1, newPassword);
            stmt2.setString(2, username);
            int rows2 = stmt2.executeUpdate();

            stmt3.setString(1, newPassword);
            stmt3.setString(2, username);
            int rows3 = stmt3.executeUpdate();

            return (rows1 > 0 || rows2 > 0 || rows3 > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
}

