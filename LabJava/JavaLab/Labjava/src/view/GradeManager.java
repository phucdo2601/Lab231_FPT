/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controll.GradeList;
import controll.SubjectList;
import controll.StudentList;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ThanhLiemPro
 */
public class GradeManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        StudentList stdList = new StudentList();
        SubjectList subList = new SubjectList();
        GradeList gradeList = new GradeList(stdList, subList);
        menu.add("Add new Student");
        menu.add("Update Student");
        menu.add("Delete Student");
        menu.add("Add new Subject");
        menu.add("Update Subject");
        menu.add("Delete Subject");
        menu.add("Enter Grade");
        menu.add("Display Student Graph Report");
        menu.add("Display Subject Graph report");
        menu.add("Quit");
        int choice ;

        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    stdList.addStudent();
                    break;

                case 2: 
                    stdList.upDateStudent();
                    break;

                case 3: 
                    stdList.deleteStudent();
                    break;

                case 4: 
                    subList.addSubject();
                    break;

                case 5: 
                    subList.upDateSuject();
                    break;

                case 6: subList.deleteSubject();
                    break;

                case 7:
                    gradeList.addNewGrade();
                    break;

                case 8: 
                    gradeList.printStudentReport();
                    break;

                case 9: 
                    gradeList.printSubjectReport();
                    break;
                case 10:
                    System.out.println("The system is exit !");
                    break;
                    
                    default:System.out.println("Mời nhập lại1(1-10)");
                    break;
            }
            

        } while (choice != 10);

    }
}
