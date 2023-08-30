package Control;

import Model.Database;
import View.UserInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductLogic
{

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserInterface ui = new UserInterface();
        Database db = new Database();

        System.out.println();
        System.out.println("INVENTORY MANAGEMENT SYSTEM:");
        System.out.println("Please select an Option\n" +
                "1.Record New product\n" +
                "2.View all Products\n" +
                "3.Search for a Product\n" +
                "4.Update a Product\n" +
                "5.Delete a Product\n" +
                "6.Add Stock\n" +
                "7.Issue Stock\n" +
                "0.Exit\n\n" +
                "Please select an option above:");

        int count = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            count = scanner.nextInt();
            switch(count)
            {
                case 1:
                    System.out.println("Record new Product:");
                    SaveProduct(ui, db);
                    Utils.printing();
                    break;
                case 2:
                    System.out.println("View all Product:");
                    ReadProduct(db);
                    Utils.printing();
                    break;
                case 3:
                    System.out.println("Search for a Product:");
                    SearchProduct(ui,db);
                    Utils.printing();
                    break;
                case 4:
                    System.out.println("Update a Product:");
                    Update(ui,db);
                    Utils.printing();
                    break;
                case 5:
                    System.out.println("Delete a Product:");
                    delete(ui,db);
                    Utils.printing();
                    break;
                case 6:
                    System.out.println("Add Stock:");
                    AddStock(ui,db);
                    Utils.printing();
                    break;
                case 7:
                    System.out.println("Issue Stock:");
                    IssueStock(ui,db);
                    Utils.printing();
                    break;
                case 0:
                    System.out.println("Logging off......");
                    break;
                default:
                    System.out.println("Wrong Entry");
                    break;
            }
        }while (count>0);
        db.CloseConnection();
    }

    private static void SaveProduct(UserInterface ui, Database db) throws SQLException {
        Product prod = ui.Create();
        System.out.println(prod.getName()+" "+prod.getCategory()+" "+prod.getQuantity());
        String querry = "insert into INV(NAME,CATEGORY,QUANTITY) values('"+prod.getName()+"','"+prod.getCategory()+"','"+prod.getQuantity()+"')";
        if (db.WriteData(querry)==1)
        {
            System.out.println("Record Successfully Inserted!");
            ReadProduct(db);
        }
        else
        {
            System.out.println("Error!");
        }
    }

    private static void ReadProduct(Database db) throws SQLException {
        String querry = "select ID,NAME,CATEGORY,QUANTITY from INV";
        ResultSet rs = db.readData(querry);
        List<String> names = Utils.ConvertResultSetToList(rs);

        for(Object i : names)
            System.out.println(i);
        System.out.println();
    }

    private static void SearchProduct(UserInterface ui, Database db) throws SQLException {
        Product prod = ui.Search();
        String query = "select ID,NAME,CATEGORY,QUANTITY from INV where ID='"+prod.getId()+"'";
        ResultSet rs = db.searchData(query);
        List<String> names = Utils.ConvertResultSetToList(rs);

        if (names.size()!=0)
        {
            for(Object i : names)
                System.out.println(i);
        }
        else
        {
            System.out.println("Item does not exist!");
        }
    }

    public static int ConfirmProductAvailability(UserInterface ui, Database db) throws SQLException {
        Product prod = ui.Search();
        String query = "select ID,NAME,CATEGORY,QUANTITY from INV where ID='"+prod.getId()+"'";
        ResultSet rs = db.searchData(query);
        List<String> names = Utils.Convert(rs);
        int x = 0;
        if(names.size()!=0)
        {
            x = Integer.parseInt((String) names.get(0)) ;
            return x;
        }
        else
        {
            System.out.println("Product doesn't exist");
            return 0;
        }
    }

    public static void Update(UserInterface ui, Database db) throws SQLException
    {
        int returns = ConfirmProductAvailability(ui, db);
        if (returns != 0)
        {
            ReadProduct(db);
            System.out.println();
            Product prod = ui.Update();
            String sql = "update INV set NAME='"+prod.getName() +"',CATEGORY='"+prod.getCategory()+"',QUANTITY='"+prod.getQuantity()+"' where ID='"+returns+"'";
            if (db.WriteData(sql)==1)
            {
                System.out.println("Record Successfully Updated!");
                ReadProduct(db);
            }
            else
            {
                System.out.println("Error!");
            }
        }
        else
        {
            System.out.println();
        }
    }

    public static void delete(UserInterface ui, Database db) throws SQLException
    {
        int returns = ConfirmProductAvailability(ui, db);
        if (returns != 0)
        {
            ReadProduct(db);
            System.out.println();
            String sql = "delete from INV where ID='"+returns+"'";
            if (db.deleteData(sql)==1)
            {
                System.out.println("Record Successfully Deleted!");
                ReadProduct(db);
            }
            else
            {
                System.out.println("Error!");
            }
        }
        else
        {
            System.out.println();
        }
    }

    public static void AddStock(UserInterface ui, Database db) throws SQLException
    {
        int returns = ConfirmProductAvailability(ui, db);
        if (returns != 0)
        {
            System.out.println();
            int AddedQuantity = ui.AddedIssuedProducts();
            String query = "select QUANTITY from INV where ID='"+returns+"'";
            ResultSet resultSet = db.readData(query);
            List<String> list = Utils.Convert(resultSet);
            int InitialQuantity = Integer.parseInt(list.get(0));
            int totalquantity = Utils.add(InitialQuantity,AddedQuantity);
            String sql = "update INV set QUANTITY='"+totalquantity+"' where ID='"+returns+"'";
            if (db.WriteData(sql)==1)
            {
                System.out.println("Stock Successfully Added!");
                ReadProduct(db);
            }
            else
            {
                System.out.println("Error!");
            }
        }
        else
        {
            System.out.println();
        }
    }


    public static void IssueStock(UserInterface ui, Database db) throws SQLException
    {
        int returns = ConfirmProductAvailability(ui, db);
        if (returns != 0)
        {
            System.out.println();
            int IssuedQuantity = ui.AddedIssuedProducts();
            String query = "select QUANTITY from INV where ID='"+returns+"'";
            ResultSet resultSet = db.readData(query);
            List<String> list = Utils.Convert(resultSet);
            int InitialQuantity = Integer.parseInt(list.get(0));
            int totalquantity = Utils.sub(InitialQuantity,IssuedQuantity);
            if (IssuedQuantity<InitialQuantity)
            {
                String sql = "update INV set QUANTITY='"+totalquantity+"' where ID='"+returns+"'";
                if (db.WriteData(sql)==1)
                {
                    System.out.println("Stock Successfully Issued!");
                    ReadProduct(db);
                }
                else
                {
                    System.out.println("Error!");
                }
            }else
            {
                System.out.println("Insufficient Stock!");
            }
        }
        else
        {
            System.out.println();
        }
    }
}
