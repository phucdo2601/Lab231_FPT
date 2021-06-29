/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class Account extends Vector<User> {

    private static String question;
    Scanner sc = new Scanner(System.in);

    public Account() {
        super();
    }

    public void AddFromFile(String fName) {
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
                String userName = stk.nextToken().toUpperCase();
                String firstName = stk.nextToken().toUpperCase();
                String lastName = stk.nextToken().toUpperCase();
                String password = stk.nextToken();
                String confirm = stk.nextToken();
                String phone = stk.nextToken();
                String email = stk.nextToken();
                //Create an Employee
                User emp = new User(userName, firstName, lastName, password, confirm, phone, email);
                this.add(emp);
            }
            bf.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

//    public static byte [] get
    
    public void saveToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        try {
            String passType ="SHA-256";
            MessageDigest md = MessageDigest.getInstance(passType);
            
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (User x : this) {
                pw.println(x.getUsername() + "," + x.getFirstName().getBytes(StandardCharsets.UTF_8) + "," + x.getLastName() + "," + x.getPassword() + "," + x.getConfirm() + "," + x.getPhone() + "," + x.getEmail());
            }
//            byte[] hash = md.digest(fName.getBytes(StandardCharsets.UTF_8));p
            String response;
            response = Check.getString("SAVING TO FILE Y/N: ", "^[YN]{1}", "The input is not valid!", "The input dont have number!");;
            if (response.startsWith("Y")) {
                pw.close();
                fw.close();
                System.out.println("The file was saved!");
            } else {
                System.out.println("NOT SAVING!");
            }

        } catch (Exception e) {
            System.out.println("The");
        }
    }

    public int searchName(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFirstName().equals(aCode)) {
                return i;
            }
            if (this.get(i).getLastName().equals(aCode)) {
                return i;
            }
        }
        return -1;
    }

    public int searchUserName(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getUsername().equals(aCode)) {
                return i;
            }
        }
        return -1;
    }

    public int searchPass(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPassword().equals(aCode)) {
                return i;
            }
        }
        return -1;
    }

    public int searchAcount(String userNanme, String pass) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getUsername().equals(userNanme) && this.get(i).getPassword().equals(pass)) {
                return i;
            }
        }
        return -1;
    }

    public void addUser() {
        String userName, firstName, lastName, password, email, phone;
        String confirm;
        int pos;
        boolean valid = true;
        System.out.println("Enter New Student details: ");
        do {
            System.out.println("Input the Username Account: ");
            userName = sc.nextLine().trim();
            pos = searchUserName(userName);
            valid = userName.matches("(.*)\\w{5,}");
            if (pos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (pos >= 0 || (!valid));

        firstName = Check.getString("Input a firs name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
        lastName = Check.getString("Input a last name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
        //regex password: "^[0-9A-Za-z]{6-31}"; "^[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*"
        password = Check.getString("Input the password: ", "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", "The password not valid!", "At least 8 chars, Contains at least one digit, Contains at least one lower alpha char and one upper alpha char, Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.");//chua xong 
        do {
            System.out.println("Input the confirm password: ");
            confirm = sc.nextLine().trim();
            valid = confirm.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
            if (confirm.equals(password)) {
                System.out.println("The confirm password is true!");
            }
            if (!valid) {
                System.out.println("The password is not valid");
            }

        } while (!valid);
        email = Check.getString("Input the Student's email: ", "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", "The email not valid!", "The email follow by form xxx@xxx.xxx");
        phone = Check.getString("Input the student's phone number: ", "\\d{8,10}", "The phone number not valid!", "The phone number just have number!");
        this.add(new User(userName, firstName, lastName, password, confirm, phone, email));
        System.out.println("Account was added!");
    }

    public void searchUser() {
        if (this.size() == 0) {
            System.out.println("Emty List!");
        }
        String name;
        System.out.print("Input the searching user of name: ");
        name = sc.nextLine().trim().toUpperCase();
        int pos = searchName(name);
        if (pos < 0) {
            System.out.println("This username does not exist!");
        } else {
            System.out.println("The name of user " + name + " was found!");
            String firstNameSearch = this.get(pos).getFirstName();
            String lastNameSearch = this.get(pos).getLastName();
            String passwordSearch = this.get(pos).getPassword();
            String phoneSearch = this.get(pos).getPhone();
            String emailSearch = this.get(pos).getEmail();
            String userNameSearch = this.get(pos).getUsername();
            System.out.println("\t\t\t\tThe information of " + name + " account: ");
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.print(userNameSearch);
            System.out.print("\t\t");
            System.out.print(firstNameSearch);
            System.out.print("\t\t");
            System.out.print(lastNameSearch);
            System.out.print("\t\t");
            System.out.print(passwordSearch);
            System.out.print("\t\t");
            System.out.print(phoneSearch);
            System.out.print("\t\t");
            System.out.print(emailSearch);
        }
    }

    public void deleteUser() {
        String userName;
        do {
            System.out.println("Enter the username of removed employee: ");
            userName = sc.nextLine().toUpperCase();
            int pos = searchUserName(userName);
            if (pos < 0) {
                System.out.println("This code does not exist.");
            } else {
                String response;
                response = Check.getString("DELETE USER Y/N", "^[YN]{1}", "The input is not valid!", "The input dont have number!");
                if (response.startsWith("Y")) {
                    this.remove(pos);
                    System.out.println("The employee " + userName + " has been removed.");
                } else {
                    System.out.println("The delete not access!");
                }

            }
            question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

    public void update() {
        String userName;
        String password;
        int posUsername;
        int posPass;
        do {
            
            do {
                userName = Check.getString("Input the user name: ", "(.*)\\w{5,}", "The username is not null or not not valid!", "The account not have speacial key word!");
                posUsername = searchUserName(userName);
                if (posUsername < 0) {
                    System.out.println("The account does not existed!");
                }
            } while (posUsername < 0);
            do {
                password = Check.getString("Input the password: ", "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", "The password not valid!", "At least 8 chars, Contains at least one digit, Contains at least one lower alpha char and one upper alpha char, Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.");
                posPass = searchPass(password);
                if (posPass < 0) {
                    System.out.println("The pass is not correct. Please input again!");
                }
            } while (posPass < 0);
            String firstName, lastName, confirm, email, phone;
            boolean valid = true;
            int pos = searchAcount(userName, password);
            String oldFirstname = this.get(pos).getFirstName();
            String oldLastname = this.get(pos).getLastName();
            String oldPassword = this.get(pos).getPassword();
            String oldConfirmPassword = this.get(pos).getConfirm();
            String oldEmail = this.get(pos).getEmail();
            String oldPhone = this.get(pos).getPhone();

            if (pos < 0) {
                System.out.println("This Account does not exist.");
            } else {
                System.out.println("Loggined!");
                firstName = Check.getStringUpdate("Input a firs name: ", "[A-Za-z_\\s]+", "The student name just have an alphabet!");
                if (firstName.isEmpty()) {
                    System.out.println("You moved on to the next set up!");
                    System.out.println("The firstname was set up: " + oldFirstname);
                } else {
                    this.get(pos).setFirstName(firstName);
                    System.out.println("The first name of the account was updated!");
                }

                lastName = Check.getStringUpdate("Input a last name: ", "[A-Za-z_\\s]+", "The student name just have an alphabet!");
                if (lastName.isEmpty()) {
                    System.out.println("You moved on to the next set up!");
                    System.out.println("The lastname was set up: " + oldLastname);
                } else {
                    this.get(pos).setLastName(lastName);
                    System.out.println("The last name of the account was updated!");
                }
                password = Check.getStringUpdate("Input the password: ", "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", "At least 8 chars, Contains at least one digit, Contains at least one lower alpha char and one upper alpha char, Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.");//chua xong
                if (password.isEmpty()) {
                    System.out.println("You moved on to the mext set up!");
                    System.out.println("The password was set up: " + oldPassword);
                } else {
                    this.get(pos).setPassword(password);;
                    System.out.println("The password of the account was updated!");
                }

                confirm = Check.getStringUpdate("Input the confirm password: ",
                        "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
                        "At least 8 chars, Contains at least one digit, Contains at least one lower alpha char and one upper alpha char, Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.");
                if (confirm.isEmpty()) {
                    System.out.println("You moved on to the next set up!");
                    System.out.println("The confirm password was set up: " + oldConfirmPassword);
                } else {
                    this.get(pos).setConfirm(confirm);
                    System.out.println("The confirmm password is correct!");
                }

                email = Check.getStringUpdate("Input the Student's email: ", "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", "The email follow by form xxx@xxx.xxx");
                if (email.isEmpty()) {
                    System.out.println("You moved on to the next set up!");
                    System.out.println("The email was set up: " + oldEmail);
                } else {
                    this.get(pos).setEmail(email);
                    System.out.println("The email of the account was set up!");
                }

                phone = Check.getStringUpdate("Input the student's phone number: ", "\\d{8,10}", "The phone number just have number!");
                if (phone.isEmpty()) {
                    System.out.println("You moved on to the next set up!");
                    System.out.println("The phone was set up: " + oldPhone);
                } else {
                    this.get(pos).setPhone(phone);
                    System.out.println("The phone of the account was set up!");
                }

            }
            question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

    public void print() {
        if (this.size() == 0) {
            System.out.println("Empty List!");
        }
        Collections.sort(this);
        System.out.println("\nAcccount List");
        System.out.println("-------------------------------------");
        for (User x : this) {
            x.print();
        }
    }
}
