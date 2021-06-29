/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Student extends ArrayList{
    public String idStudent;
    public String firstName;
    public String lastName; 
    public String gender;
    public String DOB;
    String email;
    String phoneNumber;
    boolean canDelete = true;
     Student std;

    public Student() {
    }

    public Student(String idStudent, String firstName, String lastName, String gender, String DOB, String email, String phoneNumber) {
        this.idStudent = idStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.DOB = DOB;
        this.email = email;
        this.phoneNumber =  phoneNumber;
    }

    public String getidStudent() {
        return idStudent;
    }

    public void setidStudent(String stdId) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phone) {
        this.phoneNumber =phoneNumber ;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", DOB=" + DOB + ", email=" + email + ", phoneNumber=" + phoneNumber + ", canDelete=" + canDelete + ", std=" + std + '}';
    }


   
}

