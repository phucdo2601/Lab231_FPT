/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2;

import data.*;
import java.util.Scanner;

/**
 *
 * @author toann
 */
public class MainUser {

    /**
     * @param args the command line arguments
     */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author ASUS
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String data = "employee.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addMenu("Add Information Account");
        menu.addMenu("Search Account");
        menu.addMenu("Update the account");
        menu.addMenu("DELETE THE ACCOUNT");
        menu.addMenu("Print The List of Account");
        menu.addMenu("Sava to file");
        menu.addMenu("Quit");
        int userChoice = 0;
        boolean changed = false;
        Account account = new Account();
        account.AddFromFile("employee.txt");
        do {
            System.out.println("Account Manager");
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    account.addUser();
                    changed = true;
                    break;
                case 2:
                    account.searchUser();
                    break;
                case 3:
                    account.update();
                    changed = true;
                    break;
                case 4:
                    account.deleteUser();
                    changed = true;
                    break;
                case 5:
                    account.print();
                    break;
                case 6:
                    account.saveToFile(data);
                    changed = false;
                    break;
                default:
                    if (changed) {
                        System.out.print("Save Changed Y/N?");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {// trả về giá trị TRue nếu nhập y 
                            account.saveToFile(data);/// HÀM  Ở THUư viện Emlist 
                            System.out.println("The file was changed!");
                        }
                        if (response.startsWith("N")) {
                            System.out.println("The file wasn't changed!");
                        }
                    }
                    if (userChoice == 7) {
                        String ecryption;
                        System.out.println("Encrytion password: SHA256");
                        ecryption = Check.getString("Input an ecrytpion password for closing: ",
                                "^[SHA]{3}\\d{1,3}",
                                "The password not valid!", "The password must have one Capitsl alphabet and one speacial keyword!");
                        if (ecryption.equals("SHA256")) {
                            System.out.println("Good Bye!");
                        }
                        
                    }
            }
        } while (userChoice > 0 || userChoice < 7);
    }

}
