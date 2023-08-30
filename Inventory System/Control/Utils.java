package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
    public static List<String> ConvertResultSetToList(ResultSet rs) throws SQLException {
        String row = null;
        List<String> name = new ArrayList<>();
        while (rs.next())
        {
            row = rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(2)+" "+rs.getString(4);
            name.add(row);
        }
        return name;
    }

    public static List<String> Convert(ResultSet rs) throws SQLException {
        String row = null;
        List<String> name = new ArrayList<>();
        while (rs.next())
        {
            row = rs.getString(1);
            name.add(row);
        }
        return name;
    }

    public static int add(int a, int b)
    {
        return a+b;
    }

    public static int sub(int a, int b)
    {
        return a-b;
    }

    public static void printing()
    {
        System.out.println("1.Create\n2.Read\n3.Search\n4.Update\n5.Delete\n6.Add Stock\n7.Issue Stock");
    }
}
