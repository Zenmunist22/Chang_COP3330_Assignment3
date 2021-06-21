package ex44;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

/*
    Pseudocode
    1. Two classes
        - Product will store the product information
        - Products will store a List<Product>
    2. Parse json using gson.fromJson
        - Inserts into Products.list
    3. While loop
        I. Prompt for productName
            -Throw exception when product is not found inside Products.list.name
        II. Print Product Information
        III. Break
 */

public class App {
    private Gson gson;
    private Reader reader;
    private Products res;
    private Scanner sc;

    public static void main(String args[]){
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("exercise44_input.json"));

            // convert JSON string to User object
            Products res = gson.fromJson(reader,Products.class);

            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("What is the product name? ");
                    String productName = sc.nextLine();
                    Product p = findProduct(res, productName);
                    if (p == null) {
                        throw new Exception();
                    }
                    System.out.printf("Name: %s\nPrice: %.2f\nQuantity: %d", p.getName(), p.getPrice(), p.getQuantity());
                    break;

                } catch (Exception e) {
                    System.out.println("Sorry, that product was not found in our inventory.");
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Product findProduct(Products productList, String name){
        for (int i = 0; i < productList.getProducts().size(); i++){
            Product p = productList.getProducts().get(i);
            if (p.getName().equals(name)) return p;
        }
        return null;
    }
}
