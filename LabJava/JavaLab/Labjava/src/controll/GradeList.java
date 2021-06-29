/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.util.ArrayList;
import java.util.Scanner;
import model.MyUntil;

/**
 *
 * @author ThanhLiemPro
 */
public class GradeList extends ArrayList<Grade> {

    Scanner sc = new Scanner(System.in);
    MyUntil myUntil = new MyUntil();
    StudentList stdList;
    SubjectList subList;

    public GradeList(StudentList stdList, SubjectList sublList) {
        super();
        this.stdList = stdList;
        this.subList = sublList;
    }

    public int searchStudent(String idStudent) {
//        for (int i = 0; i < stdList.size(); i++) {
//            if (stdList.get(i).getidStudent().equals(idStudent)) {
//                return i;
//            }
//        }
        for (int i = 0; i < this.size(); i++) {
            if (stdList.get(i).getidStudent().equals(idStudent)) {
                return i;
            }
        }
        return -1;
    }

    public int searchSubject(String subId) {
//        for (int i = 0; i < subList.size(); i++) {
//            if (subList.get(i).getSubID().equals(subId)) {
//                return i;
//            }
//        }
        for (int i = 0; i < this.size(); i++) {
            if (subList.get(i).getSubID().equals(subId)) {
                return i;
            }
        }
        return -1;
    }

    public int search(String idStudent, String subId) {
        for (int i = 0; i < stdList.size() && i < subList.size(); i++) {
            if (subList.get(i).getSubID().equals(subId) || stdList.get(i).getidStudent().equals(idStudent)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewGrade() {
        String stdID;
        String subID;
        int stdPos = -1;
        int subPos = -1;
        int gradePos = -1;
        boolean valid = true;
        do {
            do {
                stdID = myUntil.getID("Input your ID Student: ");
                stdPos = stdList.search(stdID);
            } while (stdPos < 0);

            do {

                subID = myUntil.getString("Input the code Subject:  ", "The code Subject not null");
                subPos = subList.search(subID);
            } while (subPos < 0);
            gradePos = this.search(stdID, subID);
            if (gradePos < 0) {
                System.out.println("This grade existed!");
            }
        } while (gradePos < 0);
        double lab, test, FE;
        lab = myUntil.getGrade("Input score student Lab:  ");
        test = myUntil.getGrade("Input core student Test: ");
        FE = myUntil.getGrade("Input core student FE: ");
        Grade gd = new Grade(stdList.get(stdPos), subList.get(subPos), lab, test, FE);
        this.add(gd);
        stdList.get(stdPos).canDelete = false;
        subList.get(subPos).canDelete = false;
        System.out.println("A new grade have been added!");
    }

    public void printStudentReport() {
        String stdID = myUntil.getID("Input the code Student: ");
        int gradePos = searchStudent(stdID);
        if (gradePos < 0) {
            System.out.println("No report can be supported!");
        } else {
            System.out.println("Student ID: " + stdID);
            Student st = this.get(gradePos).std;
            System.out.println("Student name: " + st.lastName + " " + st.firstName);
            System.out.println("No Subject Average Status");
            int count = 1;
            for (Grade g : this) {
                if (stdID.equals(g.std.idStudent)) {
                    System.out.print(count);
                    System.out.print("\t\t");
                    System.out.print(g.sub.subName);
                    System.out.print("\t\t");
                    double avg = g.average();
                    System.out.print("\t\t");
                    System.out.print(avg);
                    System.out.print("\t\t");
                    System.out.print(avg >= 5 ? "Pass\n" : "Fail\n");
                    count++;
                }
            }
        }
    }

    public void printSubjectReport() {
        String subID = myUntil.getIDsub("Input the code Subject: ");
        int gradePos = searchSubject(subID);
        if (gradePos < 0) {
            System.out.println(gradePos);
            System.out.println("No report can be supported!");
        } else {
            System.out.println("Subject ID: " + subID);
            Subject sub = this.get(gradePos).sub;
            System.out.println("Subject name: " + sub.subName);
            System.out.println("No Subject Average Status");
            int count = 1;
            for (Grade g : this) {
                if (subID.equals(g.sub.subID)) {
                    System.out.print(count);
                    System.out.print("\t\t");
                    System.out.print(g.std.idStudent);
                    System.out.print("\t\t");
                    System.out.print(g.std.lastName + " " + g.std.firstName);
                    System.out.print("\t\t");
                    double avg = g.average();
                    System.out.print(avg);
                    System.out.print("\t\t");
                    System.out.print(avg >= 5 ? "Pass\n" : "Fail\n");
                    count++;
                }
            }
        }
    }
}
