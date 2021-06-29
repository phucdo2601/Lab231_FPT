/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class SupRolde {
    String supCode, supName;

    public SupRolde() {
    }

    public SupRolde(String supCode, String supName) {
        this.supCode = supCode;
        this.supName = supName;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    @Override
    public String toString() {
        return "SupRolde{" + "supCode=" + supCode + ", supName=" + supName + '}';
    }
    
}
