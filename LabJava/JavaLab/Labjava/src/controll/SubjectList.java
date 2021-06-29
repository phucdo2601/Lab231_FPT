/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;
import model.MyUntil;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ThanhLiemPro
 */
public class SubjectList extends ArrayList<Subject>{
        MyUntil myUntil =new MyUntil();
        Scanner sc= new Scanner(System.in);

    public SubjectList() {
        super();
    }
        
      int search(String subId) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getSubID().equals(subId)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addSubject() {
          String id;
      do{
           id =myUntil.getString("Input your Code Subject :  ","The Code Subject is not null ");
           if(search(id)>=0) System.out.println("this Code'" + id + "'" + " has already!! Please try again.");
        }while(search(id)>=0);
      String subName=myUntil.getString("Input the Name Subject", "The Name Subject is not null !!");
      int credit=myUntil.getIntNumber("Input credit:  ");
      Subject tsu=new Subject(id, subName, credit);
   this.add(tsu);
   if(id!=null){
       System.out.println("ADD IS SUCESSS ");
   }else{
        System.out.println("ADD IS FAIL");
      
    }
    }
    
    public void upDateSuject() {
            String id;
      do{
           id =myUntil.getString("Input your Code Subject:  ","The ID Subject is not null");
           if(search(id)<0) System.out.println("This '" + id + "'" + "ID Subject does not exist.!! Please try again.");
        }while(search(id)<0);
      String subName=myUntil.getString("Input name Subject: ", "The ID Subject is not null");
     int credit=myUntil.getIntNumber("Input credit of Subject");
    this.get(search(id)).setSubName(subName);
    this.get(search(id)).setCredit(credit);
        System.out.println("Update is Success! ");
    }
              
    
    public void deleteSubject() {
 if (this.size()== 0) {
            System.out.println("Emty List!");
        }
        String  idSubject;
        System.out.println("Enter the code of removed Subject: ");
        idSubject = sc.nextLine();
        int id = search(idSubject);
        if (id < 0) {
            System.out.println("This code Subject does not exist.");
        } else if (this.get(id).canDelete == false) {
            System.out.println("Subject can not be removed!");
        } else {
             String dete=myUntil.getChar("Bạn có muốn xóa dữ liêu không(Y/N): ");
            if(dete.equals("Y")){
            this.remove(id);
            System.out.println("The Student Subject " + id + " has been removed.");
        }else{
                System.out.println("Delete canncel");
            }
    }
}
}