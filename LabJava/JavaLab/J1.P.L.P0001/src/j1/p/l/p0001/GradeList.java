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
public class GradeList extends ArrayList<Grade> {

    private static String quetion;
    Scanner sc = new Scanner(System.in);
    studentList stdList;
    SubjectList subList;

    public GradeList(studentList stdList, SubjectList sublList) {
        super();
        this.stdList = stdList;
        this.subList = sublList;
    }

    public int searchStudent(String stdId) {
        for (int i = 0; i < this.size(); i++) {
            if (stdList.get(i).getStdId().equals(stdId)) {
                return i;
            }
        }
        return -1;
    }

    public int searchSubject(String subId) {
        for (int i = 0; i < this.size(); i++) {
            if (subList.get(i).getSubID().equals(subId)) {
                return i;
            }
        }
        return -1;
    }

    public int search(String stdId, String subId) {
        for (int i = 0; i < stdList.size() && i < subList.size(); i++) {
            if (subList.get(i).getSubID().equals(subId) || stdList.get(i).getStdId().equals(stdId)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewGrade() {
        String stdID = null, subID;

        int stdPos = -1, subPos = -1, gradePos = -1;
        boolean valid = true;
        do {
            do {
                do {
                    System.out.println("Input the Student's ID: ");
                    stdID = sc.nextLine().trim().toUpperCase();
                    stdPos = stdList.search(stdID);
                    valid = stdID.matches("(.*)\\w{2}\\d+");
                    if (!valid) {
                        System.out.println("The Student ID not valid");
                    }
                } while (!valid || stdPos < 0);

                do {
                    System.out.println("Input the Subject's ID: ");
                    subID = sc.nextLine().trim().toUpperCase();
                    valid = subID.matches("(.*)\\w{2}\\d+");
                    subPos = subList.search(subID);
                } while (!valid || subPos < 0);
                gradePos = this.search(stdID, subID);
                if (gradePos < 0) {
                    System.out.println(gradePos);
                    System.out.println("This graph existed!");
                } else {
                    System.out.println("This graph does not existed!");
                }
            } while (gradePos < 0);
            double lab = 0, test = 0, FE = 0;
            lab = Check.checkNumber("Input the lab grade: ", -1, 11, "The grade not valid!", "  The grade just have a number!");
            test = Check.checkNumber("Input the test grade: ", -1, 11, "The grade not valid!", "  The grade just have a number!");
            FE = Check.checkNumber("Input the FE grade: ", -1, 11, "The grade not valid!", "  The grade just have a number!");
//        do {            
//            try {
//                System.out.print("Input the Lab Grade: ");
//                lab = Double.parseDouble(sc.nextLine());
//                valid = true;
//            } catch (Exception e) {
//                valid = false;
//                System.out.println("The lab Grade is not valid!");
//            }
//        } while (!valid);
//        
//        do {            
//            try {
//                System.out.print("Input the Lab Grade: ");
//                test = Double.parseDouble(sc.nextLine());
//                valid = true;
//            } catch (Exception e) {
//                valid = false;
//                System.out.println("The test Grade is not valid!");
//            }
//        } while (!valid);
//        
//        do {            
//            try {
//                System.out.print("Input the Lab Grade: ");
//                FE = Double.parseDouble(sc.nextLine());
//                valid = true;
//            } catch (Exception e) {
//                valid = false;
//                System.out.println("The FE Grade is not valid!");
//            }
//        } while (!valid);
            Grade t = new Grade(stdList.get(stdPos), subList.get(subPos), lab, test, FE);
            this.add(t);

            stdList.get(stdPos).canDelete = false;
            subList.get(subPos).canDelete = false;
            System.out.println("A new grade have been added!");

            quetion = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (quetion.equalsIgnoreCase("n") || quetion.equalsIgnoreCase("0")) {
                break;
            }
        } while (quetion.equalsIgnoreCase("1") || quetion.equalsIgnoreCase("y"));
    }

    public void printStudentReport() {
        String stdID;
        boolean valid = true;
        do {
            do {
                System.out.println("Input the Student's ID: ");
                stdID = sc.nextLine().trim().toUpperCase();
                valid = stdID.matches("(.*)\\w{2}\\d+");
                if (!valid) {
                    System.out.println("The id have 2 first character and 6 number!");
                }
            } while (!valid);
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
                    if (stdID.equals(g.std.stdId)) {
                        System.out.print(count);
                        System.out.print("\t\t");
                        System.out.print(g.sub.subID);
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
            quetion = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (quetion.equalsIgnoreCase("n") || quetion.equalsIgnoreCase("0")) {
                break;
            }
        } while (quetion.equalsIgnoreCase("1") || quetion.equalsIgnoreCase("y"));
    }

    public void printSubject() {
        String subID;
        boolean valid = true;
        do {
            do {
                System.out.println("Input the Subject's ID: ");
                subID = sc.nextLine().trim().toUpperCase();
                valid = subID.matches("(.*)\\w{2}\\d+");
                if (!valid) {
                    System.out.println("The id have 2 first character and 6 number!");
                }
            } while (!valid);
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
                        System.out.print(g.std.stdId);
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
            quetion = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (quetion.equalsIgnoreCase("n") || quetion.equalsIgnoreCase("0")) {
                break;
            }
        } while (quetion.equalsIgnoreCase("1") || quetion.equalsIgnoreCase("y"));
    }
}
