package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        jdbcDemo obj = new jdbcDemo();
//        obj.establishJdbcConnection();


        dbUtil db = new dbUtil();
        ResultSet rs = db.readData("select * from USERS");
        while(rs.next())
            System.out.println(rs.getString("fname")+" "+rs.getString("lname"));
        db.closeConnection();

    }
}
