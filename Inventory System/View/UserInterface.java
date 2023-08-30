package View;

import Control.Product;

import java.util.Scanner;

public class UserInterface
{
    Product product = new Product();
    public Product Create()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name");
        product.setName(scanner.nextLine());
        System.out.println("Please enter the category");
        product.setCategory(scanner.nextLine());
        System.out.println("Please enter the quantity");
        product.setQuantity(scanner.nextInt());
        return product;
    }

    public Product Search()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ProductID(Search/Delete)");
        product.setId(scanner.nextInt());
        return product;
    }

    public Product Update()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the new name");
        product.setName(scanner.nextLine());
        System.out.println("Please enter the new category");
        product.setCategory(scanner.nextLine());
        System.out.println("Please enter the new quantity");
        product.setQuantity(scanner.nextInt());
        return product;
    }

    public int AddedIssuedProducts()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantity of Products Adding/Issuing:");
        return scanner.nextInt();
    }

}
