/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputbooleandatevalues;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class testCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  stdId, gender,phone, password, confirm, DOB;
//        gender = Check.getString("Input the student's gender: ", "^[T]$", "The gender not valid!", "The gender doesn't have a speacial key work!");
//        Date DOB; gender = Check.getString("Input the student's gender: ", "^[T]$", "The gender not valid!", "The gender doesn't have a speacial key work!");
        DOB = Check.getDate("Input date of birthday: ", "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}", "The day is not valid!", "Inputted just have a nnumber and / or -");
//        stdId = Check.getCode("Input a student id: ", "(.*)\\w{2}\\d(.*)", "Student Id doesn't have valid!", "Student Id not have a speacial keywork and have max 10 number.");
//         password = Check.getString("Input the student's pass word: ", "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", "The phone number not valid!", "The phone number just have number!");
//         confirm = Check.getDate("Input the confirm password: ", password, "The day is not valid!", "Inputted just have a nnumber and / or -");
    }
}
