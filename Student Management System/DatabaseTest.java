import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db = new Database();

    DatabaseTest() throws SQLException, ClassNotFoundException {
    }

    @Test
    void readData() throws SQLException {
        String sql = "select NAME from studentdetails where ADMNO=100";
        String name = null;
        ResultSet rs = db.readData(sql);
        while (rs.next())
            name = rs.getString("NAME");
        assertEquals("Frankline Onyonka Momanyi",name);
    }

    @Test
    void saveData() throws SQLException {
        String sql = "insert into studentdetails(ADMNO,NAME,COURSE,PHONE,MAIL)values(?,?,?,?,?)";
        String admno = "1100";
        String names = "Jesse Jason";
        String courses = "Economics";
        String phones = "741526398";
        String mails = "test@gmail.com";
        assertEquals(1,db.saveData(sql,admno,names,courses,phones,mails));
    }

    @Test
    void updateData() throws SQLException {
        String sql = "update studentdetails set ADMNO=?,NAME=?,COURSE=?,PHONE=?,MAIL=? where ADMNO=?";
        String admno = "1100";
        String names = "Jesse Jason";
        String courses = "Economics";
        String phones = "741526398";
        String mails = "test@gmail.com";
        assertEquals(1,db.updateData(sql,admno,names,courses,phones,mails));
    }

    @Test
    void searchData() throws SQLException {
        String sql = "select NAME from studentdetails where ADMNO=100";
        String name = null;
        ResultSet rs = db.readData(sql);
        while (rs.next())
            name = rs.getString("NAME");
        assertEquals("Frankline Onyonka Momanyi",name);
    }

    @Test
    void deleteData() throws SQLException {
        String sql = "delete from studentdetails where ADMNO=?";
        String admno = "1100";
        assertEquals(1,db.deleteData(sql,admno));
    }
}