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
public class GradeManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        studentList stdList = new studentList();
        SubjectList subList = new SubjectList();
        GradeList gradeList = new GradeList(stdList, subList);
//        stdList.addStudentTest();
//        subList.addTestSubject();
        
        menu.addMenu("Add new Student");
        menu.addMenu("Update Student");
        menu.addMenu("Delete Student");
        menu.addMenu("Add new Subject");
        menu.addMenu("Update Subject");
        menu.addMenu("Delete Subject");
        menu.addMenu("Enter Graph");
        menu.addMenu("Display Student Graph Report");
        menu.addMenu("Display Subject Graph report");
        menu.addMenu("Quit");
        int choice ;
//        System.out.println("input choice: ");
//        choice = Intger.parseInt(sc.nextLine());
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    stdList.addStudent();
                    break;

                case 2: stdList.upDateStudent();
                    break;

                case 3: stdList.deleteStudent();
                    break;

                case 4: subList.addSubject();
                    break;

                case 5: subList.upDate();
                    break;

                case 6: subList.deleteSubject();
                    break;

                case 7: gradeList.addNewGrade();
                    break;

                case 8: gradeList.printStudentReport();
                    break;

                case 9: gradeList.printSubject();
                    break;
                default:
                    if (choice == 10) {
                        System.out.println("Good Bye!");
                    }
            }

        } while (choice != 10);

    }
}
