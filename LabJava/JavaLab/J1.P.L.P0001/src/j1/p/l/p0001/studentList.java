/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.p.l.p0001;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class studentList extends ArrayList<Student> {

    Scanner sc = new Scanner(System.in);
    private static String question;

    public studentList() {
        super();
    }

    int search(String stdId) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStdId().equals(stdId)) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent() {
//        if (this.size() == 0) {
//            System.out.println("Emty List!");
//
//        }
        String stdId, firstName, lastName, gender, email, phone;
        String DOB;
        int pos;
        boolean valid = true;
        System.out.println("Enter New Student details: ");
        do {
            do {
                System.out.println("Input the Student's ID: ");
                stdId = sc.nextLine().trim().toUpperCase();
                pos = search(stdId);
                valid = stdId.matches("(.*)\\w{2}\\d+");
                if (pos >= 0) {
                    System.out.println("The id is duplicated!");
                }
                if (!valid) {
                    System.out.println("The id have 2 first character and 6 number!");
                }
            } while (pos >= 0 || (!valid));

            firstName = Check.getString("Input a firs name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
            lastName = Check.getString("Input a last name: ", "[A-Za-z_\\s]+", "The Student not valid!", "The student name just have an alphabet!");
            gender = Check.getString("Input the student's gender: ", "[A-Za-z_\\s]+", "The gender not valid!", "The gender doesn't have a speacial key work!");//chua xong 
            DOB = Check.getDate("Input date of birthday: ", "\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}", "The day is not valid!", "Inputted just have a nnumber and / or -");
            email = Check.getString("Input the Student's email: ", "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,}(\\.[a-zA-Z]+)+$", "The email not valid!", "The email follow by form EMIAL Google");
            phone = Check.getString("Input the student's phone number: ", "\\d{8,10}", "The phone number not valid!", "The phone number just have number!");
            this.add(new Student(stdId, firstName, lastName, gender, DOB, email, phone));
            System.out.println("Student was added!");
            question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

    public void upDateStudent() {
        String stdId;
        String DOB = null;
        do {
            System.out.println("Enter the code of promoted student: ");
            stdId = sc.nextLine().toUpperCase();
            int pos = search(stdId);
            boolean valid = true;

            if (pos < 0) {
                System.out.println("This code does not exist.");
            } else {
                String newFirstName, newLastName = null, newGender, newEmail, newPhone, newDOB;
                String oldFirstName = this.get(pos).getFirstName();
                String oldLastName = this.get(pos).getLastName();
                String oldGender = this.get(pos).getGender();
                String oldDOB = this.get(pos).getDOB();
                String oldEmail = this.get(pos).getEmail();
                String oldPhone = this.get(pos).getPhone();

                System.out.println("The old First Name " + oldFirstName + ", Input the new first name: ");
                newFirstName = sc.nextLine().toUpperCase();
                valid = newFirstName.matches("^[A-Za-z_\\s]{3,40}$");
                if (newFirstName.isEmpty()|| valid) {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new first name: " + oldFirstName);
                }
                else {
                    System.out.println("The first name is not valid");
                    do {
                        System.out.println("Please input name again: ");
                        newFirstName = sc.nextLine().toUpperCase();
                        valid = newFirstName.matches("^[A-Za-z_\\s]{3,40}$");
                    } while (!valid);

                }
//                if (valid = newFirstName.matches("^[A-Za-z_\\s]{3,40}$")) {
//                    do {
//                        valid = newFirstName.matches("^[A-Za-z_\\s]{3,40}$");
//                    } while (!valid);
//                    this.get(pos).setFirstName(newFirstName);
//                }

//            do {
//                System.out.println("The old Last Name " + oldLastName + ", Input the new Last name: ");
//                newLastName = sc.nextLine().toUpperCase();
//                valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$");
//                if (!valid) {
//                    System.out.println("The Last name is not valid");
//                }
//                if (newLastName == "") {
//                    System.out.println("Gia tri da duoc bo qua");
//                    System.out.println("The new last name: " +oldLastName);
//                } else {
//                    this.get(pos).setLastName(newLastName);
//                }
//            } while (!valid);
                System.out.println("The old Last Name " + oldLastName + ", Input the new last name: ");
                newLastName = sc.nextLine().toUpperCase();
                valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$");
                if (newLastName == "") {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new last name: " + oldLastName);
                }
                if (!valid) {
                    System.out.println("The last name is not valid");
                }
                if (valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$")) {
                    do {
                        valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$");
                    } while (!valid);
                    this.get(pos).setLastName(newLastName);
                }

//            do {
//                System.out.println("The old gender " + oldGender + ", Input the new gender: ");
//                newGender = sc.nextLine().toUpperCase();
//                valid = newGender.matches("^[A-Za-z_\\s]{1,40}$");
//                if (!valid) {
//                    System.out.println("The gender is not valid");
//                }
//                if (newGender == "") {
//                    System.out.println("Gia tri da duoc bo qua");
//                    System.out.println("The new gender: "+oldGender);
//                } else {
//                    this.get(pos).setGender(newGender);
//                }
//            } while (!valid);
                System.out.println("The old Gender " + oldGender + ", Input the new GENDER: ");
                newGender = sc.nextLine().toUpperCase();
                valid = newGender.matches("^[A-Za-z_\\s]{3,40}$");
                if (newGender == "") {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new gender: " + oldGender);
                }
                if (!valid) {
                    System.out.println("The gender is not valid");
                }
                if (valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$")) {
                    do {
                        valid = newLastName.matches("^[A-Za-z_\\s]{3,40}$");
                    } while (!valid);
                    this.get(pos).setGender(newGender);
                }

                System.out.println("The old DOB " + oldDOB + ", Input the new DOB: ");
                newDOB = sc.nextLine().toUpperCase();
                valid = newDOB.matches("\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}");
                if (newDOB == "") {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new DOB: " + oldDOB);
                }
                if (!valid) {
                    System.out.println("The DOB is not valid");
                }
                if (valid = newDOB.matches("\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}")) {
                    do {
                        this.get(pos).setDOB(newDOB);
                    } while (!valid);
                }

//            do {
//                System.out.println("The old DOB " + oldDOB + ", Input the new DOB: ");
//                newDOB = sc.nextLine().toUpperCase();
//                valid = newDOB.matches("\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}");
//                if (!valid) {
//                    System.out.println("The DOB is not valid");
//                }
//                if (newDOB == "") {
//                    System.out.println("Gia tri da duoc bo qua");
//                    System.out.println("The new DOB: "+oldDOB);
//                } else {
//                    this.get(pos).setDOB(newDOB);
//                }
//            } while (!valid);
//            do {
//                System.out.println("The old Email " + oldEmail + ", Input the new Email: ");
//                newEmail = sc.nextLine().toUpperCase();
//                valid = newEmail.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,}(\\.[a-zA-Z]+)+$");
//                if (!valid) {
//                    System.out.println("The Email is not valid");
//                }
//                if (newEmail == "") {
//                    System.out.println("Gia tri da duoc bo qua");
//                    System.out.println("The new email: "+oldEmail);
//                } else {
//                    this.get(pos).setEmail(newEmail);
//                }
//            } while (!valid);
                System.out.println("The old DOB " + oldEmail + ", Input the new Email: ");
                newEmail = sc.nextLine().toUpperCase();
                valid = newEmail.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,}(\\.[a-zA-Z]+)+$");
                if (newEmail == "") {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new Email: " + oldEmail);
                }
                if (!valid) {
                    System.out.println("The Email is not valid");
                }
                if (valid = newDOB.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,}(\\.[a-zA-Z]+)+$")) {
                    do {
                        this.get(pos).setDOB(newDOB);
                    } while (!valid);
                }

//            do {
//                System.out.println("The old Phone " + oldPhone + ", Input the new Phone: ");
//                newPhone = sc.nextLine().toUpperCase();
//                valid = newPhone.matches("\\d{8,10}");
//                if (!valid) {
//                    System.out.println("The phone is not valid");
//                }
//                if (newEmail == "") {
//                    System.out.println("Gia tri da duoc bo qua");
//                    System.out.println("The new phone: "+oldPhone);
//                } else {
//                    this.get(pos).setPhone(newPhone);
//                }
//            } while (!valid);
                System.out.println("The old Phone " + oldPhone + ", Input the new Phone: ");
                newPhone = sc.nextLine().toUpperCase();
                valid = newPhone.matches("\\d{8,10}");
                if (newPhone == "") {
                    System.out.println("Gia tri da duoc bo qua");
                    System.out.println("The new Phone: " + oldPhone);
                }
                if (!valid) {
                    System.out.println("The Phone is not valid");
                }
                if (valid = newDOB.matches("\\d{8,10}")) {
                    do {
                        this.get(pos).setPhone(newPhone);
                    } while (!valid);
                }

                System.out.println("The employee " + stdId + " has been updated.");
            }
            question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

    public void deleteStudent() {
        if (this.size() == 0) {
            System.out.println("Emty List!");
        }
        String code;
        do {
            System.out.println("Enter the code of removed employee: ");
            code = sc.nextLine().toUpperCase();
            int pos = search(code);
            if (pos < 0) {
                System.out.println("This code does not exist.");
            } else if (this.get(pos).canDelete == false) {
                System.out.println("Student can not be removed!");
            } else {
                this.remove(pos);
                System.out.println("The employee " + code + " has been removed.");
            }
            question = Check.getQuestion("Do you continue to add Grade(Y/N or y/n or 0/1)", "The input not valid", "The input just have 'Y/N or y/n or 0/1' ");
            if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

//    void addStudentTest() {
//
//    }
}
