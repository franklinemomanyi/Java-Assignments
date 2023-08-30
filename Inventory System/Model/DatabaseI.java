package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseI<Product>
{
    public ResultSet readData(String query) throws SQLException;
    public int WriteData(String query) throws SQLException;
    public ResultSet searchData(String query) throws SQLException;
    public int deleteData(String query) throws SQLException;
    public void CloseConnection() throws SQLException;

}
