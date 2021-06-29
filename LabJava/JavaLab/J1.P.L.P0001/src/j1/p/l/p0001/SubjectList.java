/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.p.l.p0001;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class SubjectList extends ArrayList<Subject>{
    private static String question;
    public SubjectList() {
        super();
    }
    

    private static Scanner sc = new Scanner(System.in);
    
    
    int search(String subId) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getSubID().equals(subId)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addSubject() {
//        if (this.size() == 0) {
//            System.out.println("Emty List!");
//            return;
//        }
        String subId, subName;
        int credit;
        int pos;
        boolean valid = true;
        System.out.println("Enter New Subject details: ");
        do{
        do {
            System.out.println("Input the Subject's ID: ");
            subId = sc.nextLine().trim().toUpperCase();
            pos = search(subId);
            valid = subId.matches("(.*)\\w{2}\\d+");
            if (pos >= 0) {
                System.out.println("The id is duplicated!");
            }
            if (!valid) {
                System.out.println("The id have 2 first character and 6 number!");
            }
        } while (pos >= 0 || (!valid));

        subName = Check.getString("Input a subject name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
        credit = Check.checkNumber("Input a credit: ", 0, 31, "The credit not valid", "The credit just have a number!");
        this.add(new Subject(subId, subName, credit));
        question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }
    
    public void upDate() {
        if (this.size() == 0) {
            System.out.println("Emty List!");
            return;
        }
        String subId, subName;
        int credit;
        System.out.println("Enter the code of promoted employee: ");
        subId = sc.nextLine().toUpperCase().trim();
        int pos = search(subId);
        do{
        if (pos < 0) {
            System.out.println("This code does not exist.");
        } else {
            subName = Check.getString("Input a firs name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
            this.get(pos).setSubName(subName);
            credit = Check.checkNumber("Input a credit: ", 0, 31, "The credit not valid", "The credit just have a number!");           
            this.get(pos).setCredit(credit);
            System.out.println("The employee " + subId+ " has been updated.");
        }
        question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }
    
    public void deleteSubject() {
        if (this.size() == 0) {
            System.out.println("Emty List!");
            return;
        }
        String code;
        do{
        System.out.println("Enter the code of removed employee: ");
        code = sc.nextLine().toUpperCase();
        int pos = search(code);
        if (pos < 0) {
            System.out.println("This code does not exist.");
        }else if (this.get(pos).canDelete == false) {
            System.out.println("Subject can not be removed!");
        }
        else {
            this.remove(pos);
            System.out.println("The employee " + code + " has been removed.");
        }
        question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

//    void addTestSubject() {
//        
//    }
}
