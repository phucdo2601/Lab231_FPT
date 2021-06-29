/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject;

import util.MyToys;
import java.util.ArrayList;

/**
 *
 * @author LP D
 */
public class SubjectList extends ArrayList<Subject>{

    private String subjectId;
    private String subjectName;
    private String credit;
    
    public void addSubject() {        
        int compareId;
        String keep;
        do {
            do {
                subjectId = MyToys.getString("Input subject id(ABCXXX): ", 
                    "The format of id is ABCXXX(3 letters and 3 numbers). ", "^[A-Z]{3}\\d{3}$");
                compareId = findIdSubjectV2(subjectId);
                if (compareId >= 0) 
                    System.out.println("This id already exists, input another id! ");
            } while (compareId != -1);
            subjectName = MyToys.getString("Input subject name: ", "The format of first name is a-z & A-Z. ", "[a-z A-Z.#]{1,50}$");
            credit = MyToys.getString("Input credit: ", "Credit must be a positive integer number. ", "\\d{1,}");
            this.add(new Subject(subjectId, subjectName, credit));
            keep = MyToys.getString("Do you want to continue (Y/N): ", 
                            "Choose Y to continue, N to return main screen. ", "^[YyNn]{1}$");
            if (keep.equalsIgnoreCase("N"))                
                break;
        } while (keep.equalsIgnoreCase("Y"));
    }
    
    public void updateSubject() {
        String tmpSubjectId, tmpSubjectName, tmpCredit;
        Subject x = findIdSubject(subjectId);        
        System.out.println("Before the update");        
        System.out.println(x);
        tmpSubjectName = MyToys.getString2("Input subject name: ", "The format of first name is a-z & A-Z. ", "[a-z A-Z]{1,50}$");
        if (tmpSubjectName.isEmpty())
            x.getSubjectName();
        else
            x.setSubjectName(tmpSubjectName);
        tmpCredit = MyToys.getString2("Input credit: ", "Credit must be a positive integer number. ", "\\d{1,}");
        if (tmpCredit.isEmpty())
            x.getCredit();
        else
            x.setCredit(tmpCredit);
        System.out.println("Update successful");
    } 
    
    public void deleteSubject() {
        Subject x = findIdSubject(subjectId);
        System.out.println("Before the delete");        
        System.out.println(x);
        String del = MyToys.getString("Are you sure you want to delete? (Y/N): ", 
                            "Choose Y to delete, N to return main screen. ", "^[YyNn]{1}$");
        if (del.equalsIgnoreCase("Y")) {                
            this.remove(x);
            System.out.println("Deleted successfully");
        }
        else
            System.out.println("Delete failed");
    }
    
    public void updateOrDeleteSubject() {
        String choice;
        subjectId = MyToys.getString("Input subject id(ABCXXX): ", 
                    "The format of id is ABCXXX(3 letters and 3 numbers). ", "^[A-Z]{3}\\d{3}$");
        Subject x = findIdSubject(subjectId);
        if (x == null)                         
            System.out.println("Not found");
        else {            
            choice = MyToys.getString("Do you want to update (U) or delete (D) subject: ", 
                     "update (U) or delete (D), please. ", "^[UuDu]{1}$");
            if (choice.equalsIgnoreCase("U")) {                
                updateSubject();                                            
            }
            if (choice.equalsIgnoreCase("D")) {
                deleteSubject();
            }
        }
    }
    
    public Subject findIdSubject(String id) {
        if (id.isEmpty())
            return null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getSubjectId().equalsIgnoreCase(id))
                return this.get(i);
        }
        return null;        
    }
    
    public int findIdSubjectV2(String id) {
        if (this.isEmpty())
            return -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getSubjectId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
}
