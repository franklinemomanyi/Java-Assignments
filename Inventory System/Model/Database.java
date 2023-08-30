package Model;

import Control.Product;

import java.sql.*;

public class Database implements DatabaseI<Product>
{
    String DriverName = "com.mysql.cj.jdbc.Driver";
    public final Connection connection;
    private Statement statement;
    String className = "jdbc:mysql://localhost:3306/inventory";
    String Username = "root";
    String Password = "onyonka97";

    public Database() throws ClassNotFoundException, SQLException
    {
        Class.forName(DriverName);
        connection = DriverManager.getConnection(className,Username,Password);
    }

    public ResultSet readData(String query) throws SQLException
    {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int WriteData(String query) throws SQLException
    {
        statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public ResultSet searchData(String query) throws SQLException
    {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int deleteData(String query) throws SQLException
    {
        statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void CloseConnection() throws SQLException
    {
        statement.close();
        connection.close();
    }
}
