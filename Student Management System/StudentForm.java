import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentForm {
    private JPanel Main;
    private JTextField admission;
    private JButton SaveButton;
    private JTextField name;
    private JTextField course;
    private JTextField phone;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("StudentForm");
        frame.setContentPane(new StudentForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JTextField mail;
    private JTextField search;
    private JButton SearchButton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JTextField delete;
    private JTable datatable;
    private JScrollPane table;


    Database db = new Database();
    public StudentForm() throws SQLException, ClassNotFoundException
    {

        tableload();

        SaveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String admno,names,courses,mails,phones;


                admno = admission.getText();
                names = name.getText();
                courses = course.getText();
                phones = phone.getText();
                mails = mail.getText();


                try {
                    String querry = "insert into studentdetails(ADMNO,NAME,COURSE,PHONE,MAIL)values(?,?,?,?,?)";


                    if((db.saveData(querry,admno,names,courses,phones,mails))==1)
                    {
                        JOptionPane.showMessageDialog(null,"Record Added Successfully!");
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Error!");
                    }
                    tableload();
                    fieldClear();

                } catch (SQLException | ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String adm = search.getText();


                try {
                    String querry = "select ADMNO,NAME,COURSE,PHONE,MAIL from studentdetails where ADMNO=?";

                    ResultSet rs = db.searchData(querry,adm);

                    while (rs.next()) {
                        String admisn = rs.getString(1);
                        String names = rs.getString(2);
                        String courses = rs.getString(3);
                        String phones = rs.getString(4);
                        String emails = rs.getString(5);

                        admission.setText(admisn);
                        name.setText(names);
                        course.setText(courses);
                        mail.setText(emails);
                        phone.setText(phones);
                    }

                    search.setText("");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admno,names,courses,mails,phones;

                admno = admission.getText();
                names = name.getText();
                courses = course.getText();
                phones = phone.getText();
                mails = mail.getText();

                try {
                    String querry = "update studentdetails set ADMNO=?,NAME=?,COURSE=?,PHONE=?,MAIL=? where ADMNO=?";

                    if((db.updateData(querry,admno,names,courses,phones,mails))==1)
                    {
                        JOptionPane.showMessageDialog(null,"Record Updated Successfully!");
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Error!");
                    }
                    tableload();
                    fieldClear();

                } catch (SQLException | ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String del = delete.getText();

                try {
                    String querry = "delete from studentdetails where ADMNO=?";

                    if ((db.deleteData(querry,del))==1)
                    {
                        JOptionPane.showMessageDialog(null,"Record Deleted Successfully!");
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Error!");
                    }

                    tableload();
                    fieldClear();


                } catch (SQLException | ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

    }
    public void tableload() throws SQLException, ClassNotFoundException
    {
        Database db = new Database();
        String querry = "select ADMNO,NAME,COURSE,PHONE,MAIL from studentdetails";
        ResultSet rs = db.readData(querry);
        datatable.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void fieldClear()
    {
        admission.setText("");
        name.setText("");
        course.setText("");
        mail.setText("");
        phone.setText("");
        search.setText("");
        delete.setText("");
    }

}
