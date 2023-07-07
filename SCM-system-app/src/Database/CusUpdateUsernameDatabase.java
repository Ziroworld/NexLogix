
package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CusUpdateUsernameDatabase {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean checkUser(String oldusername){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection.dbConnect();
            String query = "SELECT * FROM customer WHERE username = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, oldusername);
            resultSet = statement.executeQuery();

            return resultSet.next(); // Returns true if user exists, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
        return false;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean updateUsername(String oldusername, String newusername, String password ){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection.dbConnect();
            String query = "UPDATE customer SET username = ? WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, newusername);
            statement.setString(2, oldusername);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if update was successful, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, null);
        }
        return false;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    private void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
