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
public class StudentList extends ArrayList<Student> {
    MyUntil myUntil =new MyUntil();
    Scanner sc = new Scanner(System.in);
    ArrayList list = new ArrayList();

    public StudentList() {
        super();
    }
    

    int search(String idStudent) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getidStudent().equals(idStudent)) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent() {
          String id;
      do{
           id =myUntil.getID("Input your ID Student:  ");
           if(search(id)>=0) System.out.println("this ID'" + id + "'" + " has already!! Please try again.");
        }while(search(id)>=0);
    String firstName=myUntil.getString("Input your Fristname:  " ,"fist name can't null");
    String lastName =myUntil.getString("Input your Last name:  " ,"last name can't null");
    String gender=myUntil.getString("Input your Gender: " ,"gender can't null");
    String DOB=myUntil.getDate("Input your Date of Brith: ");
    String email=myUntil.getMail("Input your Email: ");
    String phoneNumber=myUntil.getPhoneNumber("Ipnut your Phonr Number:");
   Student stu=new Student( id,firstName, lastName, gender, DOB, email, phoneNumber);
   this.add(stu);
   if(id!=null){
       System.out.println("ADD IS SUCESSS ");
   }else{
        System.out.println("ADD IS FAIL");
    }
    }

    public void upDateStudent() {
          String id;
      do{
           id =myUntil.getID("Input your ID Student:  ");
           if(search(id)<0) System.out.println("this ID'" + id + "'" + " This code does not exist.!! Please try again.");
        }while(search(id)<0);
    String firstName=myUntil.getString("Input your Fristname update:  " ,"fist name can't null");
    String lastName =myUntil.getString("Input your Last name update:  " ,"last name can't null");
    String gender=myUntil.getString("Input your Gender update: " ,"gender can't null");
    String DOB=myUntil.getDate("Input your Date of Brith update: ");
    String email=myUntil.getMail("Input your Email update: ");
    String phoneNumber=myUntil.getPhoneNumber("Ipnut your Phonr Number update:");
    this.get(search(id)).setFirstName(firstName);
    this.get(search(id)).setLastName(lastName);
    this.get(search(id)).setGender(gender);
    this.get(search(id)).setEmail(email);
    this.get(search(id)).setDOB(DOB);
    this.get(search(id)).setphoneNumber(phoneNumber);
        System.out.println("Update is Success! ");
    }
    public void deleteStudent() {
         if (this.size()== 0) {
            System.out.println("Emty List!");
        }
        String  idStudent;
        System.out.println("Enter the code of removed student: ");
        idStudent = sc.nextLine();
        int id = search(idStudent);
        if (id < 0) {
            System.out.println("This code does not exist.");
        } else if (this.get(id).canDelete == false) {
            System.out.println("Student can not be removed!");
        } else {
            String dete=myUntil.getChar("Bạn có muốn xóa dữ liêu không(Y/N): ");
            if(dete.equals("Y")){
            this.remove(id);
            System.out.println("The Student " + idStudent + " has been removed.");
        }else{
                System.out.println("Delete canncel");
            }
          


    }
}
}