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
public class CategoryManager extends Vector<Category> {

    private static Scanner sc = new Scanner(System.in);
    private static boolean checkValid;
    private static String quetion;

    public CategoryManager() {
        super();
    }
    
    public void AddFromFile(String fName){
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println("The file Is not exist\n");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String idCategory = stk.nextToken().toUpperCase();
                String nameCategory = stk.nextToken().toUpperCase();
                Category cat = new Category(idCategory, nameCategory);
                this.add(cat);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Category x : this) {
                pw.println(x.getIdCategory()+", "+x.getNameCategory());
            }
            String response;
            response = Check.getString("SAVING TO FILE Y/N: ", "^[YN]{1}", "The input is not valid!", "The input dont have number!");;
            if (response.startsWith("Y")) {
                pw.close();
                fw.close();
            } else {
                System.out.println("NOT SAVING!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int searchIdCategory(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getIdCategory().equals(aCode)) {
                return i;
            }
        }
        return -1;
    }

    public int searchNameCategory(String aName) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getNameCategory().equals(aName)) {
                return i;
            }
        }
        return -1;
    }

    public void addCategory() {
        String idCategory, nameCategory;
        int pos;
        boolean valid = true;
        System.out.println("Enter the new category details: ");
        do {
            System.out.println("Input the ID Category: ");
            idCategory = sc.nextLine().trim().toUpperCase();
            pos = searchIdCategory(idCategory);
            valid = idCategory.matches("(.*)\\w{5,}");
            if (pos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (pos >= 0 || (!valid));
        do {
            System.out.println("Input the Name Category: ");
            nameCategory = sc.nextLine().trim();
            pos = searchNameCategory(nameCategory);
            valid = nameCategory.matches("[A-Za-z_\\s]+");
            if (pos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (pos >= 0 || (!valid));
        this.add(new Category(idCategory, nameCategory));
    }

    public void updateCategory() {
        if (this.size() == 0) {
            System.out.println("Emty List");
            return;
        }
        String idCategory, nameCategory;
        System.out.println("Enter the Id promoting Category: ");
        idCategory = sc.nextLine().trim().toUpperCase();
        int pos = searchIdCategory(idCategory);
        boolean valid = true;
        if (pos < 0) {
            System.out.println("Category does not exist!");
        } else {
            nameCategory = Check.getString("Enter the name of category: ", "[A-Za-z_\\s]+", "The name not valid!", "The name just have alphabet");
            this.get(pos).setNameCategory(nameCategory);
            System.out.println("The category was updated!");
        }
    }

    public void deleteCategory() {
        if (this.size() == 0) {
            System.out.println("Empty List!");
        }
        String idCategory;
        System.out.print("Enter the ID of removing the category: ");
        idCategory = sc.nextLine().toUpperCase();
        int pos = searchIdCategory(idCategory);
        if (pos < 0) {
            System.out.print("FAIL. The ID NOT VALID OR NOT EXISTED!");
        } else {
            String response;
            while (true) {
                response = Check.getString("DELETE USER Y/N", "^[YN]{1}", "The input is not valid!", "The input dont have number!");
                if (response.equalsIgnoreCase("y")) {
                    this.remove(pos);
                    System.out.println("The employee " + idCategory + " has been removed.");
                    break;
                }
                if (response.equalsIgnoreCase("n")) {
                    System.out.println("The delete not access!");
                }

            }
        }

    }
}