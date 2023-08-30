package jdbc;

import java.sql.*;

public class dbUtil
{
    private final Connection connection;
    private Statement statement;
    String className = "jdbc:mysql://localhost:3306/mkaro";
    String Username = "root";
    String Password = "onyonka97";

    public dbUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(className, Username, Password);
    }

    public ResultSet readData(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int writeData(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}
