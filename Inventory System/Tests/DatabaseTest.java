package Tests;

import Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db = new Database();

    DatabaseTest() throws SQLException, ClassNotFoundException {
    }

    @org.junit.jupiter.api.Test
    void readData() throws SQLException {
        String sql = "select NAME from INV where ID=1";
        String name = null;
        ResultSet rs = db.readData(sql);
        while (rs.next())
            name = rs.getString("NAME");
        assertEquals("Files",name);
    }

    @org.junit.jupiter.api.Test
    void writeData() throws SQLException {
        String sql = "insert into INV(NAME,CATEGORY,QUANTITY)values('Cakex','Food',30)";
        assertEquals(1,db.WriteData(sql));
    }

    @org.junit.jupiter.api.Test
    void searchData() throws SQLException {
        String sql = "select NAME from INV where ID=1";
        String name = null;
        ResultSet rs = db.readData(sql);
        while (rs.next())
            name = rs.getString("NAME");
        assertEquals("Files",name);
    }

    @org.junit.jupiter.api.Test
    void deleteData() throws SQLException {
        String sql = "delete from INV where NAME='Cakex'";
        assertEquals(1,db.deleteData(sql));
    }

    @org.junit.jupiter.api.Test
    void closeConnection() {
    }
}