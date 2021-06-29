/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Employee;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author phucd
 */
public class EmployeeDAO {
    ArrayList<Employee> isEmp = new ArrayList<>();
    public int add(Employee e){
        isEmp.add(e);
        return 1;
    }
    
    public int count(){
        return isEmp.size();
    }
    
    public  Employee findID(String idEmp){
        for(Employee emp : isEmp){
            if (emp.getEmpID().equalsIgnoreCase(idEmp)) {
                return emp;
            }
        }
        return null;
    }
    
    public int update(Employee emp){
        for(Employee ee: isEmp){
            if (ee.getEmpID().equalsIgnoreCase(emp.getEmpID())) {
                ee.setEmpID(emp.getEmpID());
                ee.setFullname(emp.getFullname());
                ee.setPhone(emp.getPhone());
                ee.setEmail(emp.getEmail());
                ee.setAddress(emp.getAddress());
                ee.setDOB(emp.getDOB());
                return 1;
            }
        }
        return -1;
    }
    
    public int del(String idEmp){
        Employee e = findID(idEmp);
        if (e != null) {
            isEmp.remove(e);
            return 1;
        }
        return -1;
    }
    
    public Employee getOneEmplopeeAtPosition(int pos){
        return isEmp.get(pos);
    }
    
    public ArrayList<Employee> getAllEmployee(){
        return isEmp;
    }
}
