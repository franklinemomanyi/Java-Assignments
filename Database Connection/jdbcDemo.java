package jdbc;

import java.sql.*;

public class jdbcDemo
{
    public void establishJdbcConnection() throws SQLException, ClassNotFoundException {
        //Register the jdbc Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create a connection with the local database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mkaro","root","onyonka97");
        //Execute a Query
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from USERS");

        while (resultSet.next())
            System.out.println(resultSet.getString("fname")+" "+resultSet.getString("lname"));
        statement.close();
        connection.close();
        
    }

}
