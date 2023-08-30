import java.sql.*;

public class Database
{
    String DriverName = "com.mysql.cj.jdbc.Driver";
    public final Connection connection;
    private Statement statement;
    String className = "jdbc:mysql://localhost:3306/studentsystem";
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

    public int saveData(String query,String admno,String names, String courses,String phones,String mails) throws SQLException
    {
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, admno);
        pst.setString(2,names);
        pst.setString(3,courses);
        pst.setInt(4, Integer.parseInt(phones));
        pst.setString(5,mails);
        pst.executeUpdate();
        return 1;
    }

    public int updateData(String query,String admno,String names, String courses,String phones,String mails) throws SQLException
    {
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, admno);
        pst.setString(2,names);
        pst.setString(3,courses);
        pst.setInt(4, Integer.parseInt(phones));
        pst.setString(5,mails);
        pst.setString(6,admno);
        pst.executeUpdate();
        return 1;
    }

    public ResultSet searchData(String query,String adm) throws SQLException
    {
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,adm);
        return pst.executeQuery();
    }

    public int deleteData(String query,String del) throws SQLException
    {
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, del);
        pst.executeUpdate();
        return 1;
    }

    public void CloseConnection() throws SQLException
    {
        statement.close();
        connection.close();
    }
}
