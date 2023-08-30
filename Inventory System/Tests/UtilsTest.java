package Tests;

import Control.Utils;
import Model.Database;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void convertResultSetToList() throws SQLException, ClassNotFoundException {
        Database db = new Database();
        String query = "select ID,NAME,CATEGORY,QUANTITY from INV where ID=1";
        ResultSet resultSet = db.searchData(query);
        List<String> actual = Utils.ConvertResultSetToList(resultSet);
        List<String> expected = new ArrayList<String>();
        expected.add("1 Stationery Files 70");
        assertEquals(expected, actual);
    }

    @Test
    void convert() throws SQLException, ClassNotFoundException {
        Database db = new Database();
        String query = "select ID from INV where ID=1";
        ResultSet resultSet = db.searchData(query);
        List<String> actual = Utils.Convert(resultSet);
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        int a=5,b=5;
        assertEquals(10,Utils.add(a,b));
    }

    @Test
    void sub() {
        int a=10,b=5;
        assertEquals(5,Utils.sub(a,b));
    }
}