package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numbers of products: ");
        int numberOfProducts = sc.nextInt();

        for (int i=1; i<=numberOfProducts; i++){
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i): ");
            char productType = sc.next().charAt(0);

            if (productType == 'c'){

                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();

                list.add(new Product(name, price));
            }

            if (productType == 'u'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(sc.next(), formatter);

                list.add(new UsedProduct(name, price, date));
            }

            if (productType == 'i'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                list.add(new ImportedProduct(name, price, customsFee));
            }
        }
        sc.close();

        System.out.println("PRICE TAG:");

        list.forEach(product ->
                System.out.println(product.priceTag()));
    }
}