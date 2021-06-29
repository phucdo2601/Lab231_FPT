/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class ProductManager extends Vector<Product>{
    Scanner sc = new Scanner(System.in);
    CategoryManager catManager;
    private static String quetion;

    public ProductManager(CategoryManager catManager) {
        super();
        this.catManager = catManager;
    }
    
    
    public void AddFromFile(String fName){
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println("The file is not Exist\n");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(details, ", ");
                String idProduct = stk.nextToken().toUpperCase();
                String nameProduct = stk.nextToken().toUpperCase();
                String date = stk.nextToken().toUpperCase();
                String nationality = stk.nextToken().toUpperCase();
                double price = Double.parseDouble(stk.nextToken());
                int quantity = Integer.parseInt(stk.nextToken());
                String idCategory = stk.nextToken().toUpperCase();
                String nameCategory = stk.nextToken().toUpperCase();
                Category cat = null;
                Product product = new Product(idProduct, nameProduct, date, nationality, price, quantity, cat);
                this.add(product);
                bf.close();
                fr.close();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName){
        if (this.isEmpty()) {
            System.out.println("Emmpty List!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Product x : this) {
                pw.println(x.getIdProduct()+", "+x.getNameProduct()+", "+x.getDate()+", "+x.getNationality()+", "+x.getPrice()+", "+x.getQuantity());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public int searchIdCategory(String aCode){
        for (int i = 0; i < this.size(); i++) {
            if (catManager.get(i).getIdCategory().equals(aCode)) {
                return i; 
            }
        }
        return -1;
    }
    
    public int searchIdProduct(String aCode){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getIdProduct().equals(aCode)) {
                return i;
            }
        }
        return  -1;
    }
    
    public int searchNameProduct(String aName){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getNameProduct().equals(aName)) {
                return i;
            }
        }
        return -1;
    }
    
    
    
    public void addProduct() {
        String idProduct, nameProduct, date, nationality;
        double price;
        int quantity;
        String categoryId;
        
        int catPos = -1, IdProductPos, nameProductPos;
        boolean valid = true;
        System.out.println("Enter New Student details: ");
        do{
        do {
            System.out.println("Input the ID Product: ");
            idProduct = sc.nextLine().trim();
            IdProductPos = searchIdProduct(idProduct);
            valid = idProduct.matches("(.*)\\w{5,}");
            if (IdProductPos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (IdProductPos >= 0 || (!valid));
        
        do {
            System.out.println("Input the Name Product: ");
            nameProduct = sc.nextLine().trim();
            nameProductPos = searchNameProduct(nameProduct);
            valid = nameProduct.matches("[A-Za-z_\\s]+");
            if (nameProductPos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (nameProductPos >= 0 || (!valid));

        nationality = Check.getString("Input a last name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
        date = Check.getDate("Input the date of product: ", "\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}", "The date not valid!", "The date not have alphabet!");
        price = Check.checkPrice("Input the price of product: ", 0, 100000000, "The price not valid!", "The price not have alphabet!");
        quantity = Check.checkNumber("Input the quantity of product(1-999): ", 0, 1000, "The quantity not valid!", "The input just have number(from 1-999)");
        do{
        categoryId = Check.getCode("Input the code of category: ", "^[A-Za-z]{3}\\d{1,6}", "The category id not valid!", "The category not have a special key word!");
        catPos = searchIdCategory(date);
            if (catPos < 0) {
                System.out.println("The code of category does not exist!");
            }
        }while(catPos <0);
        Product pr = new Product(idProduct, nameProduct, date, nationality, price, quantity, catManager.get(catPos));
        this.add(pr);
        System.out.println("Account was added!");
        quetion = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (quetion.equalsIgnoreCase("n") || quetion.equalsIgnoreCase("0")) {
                break;
            }
        } while (quetion.equalsIgnoreCase("1") || quetion.equalsIgnoreCase("y"));
    }
}
