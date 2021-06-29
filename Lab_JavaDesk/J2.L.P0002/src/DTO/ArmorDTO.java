/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ArmorDTO {
    public String ArmorID;
    public String Classification;
    public String Description;
    public String Status;
    Date TimeOfCreate;
    int Denfense;

    public ArmorDTO() {
    }

    public ArmorDTO(String ArmorID, String Classification, String Description, String Status, Date TimeOfCreate, int Denfense) {
        this.ArmorID = ArmorID;
        this.Classification = Classification;
        this.Description = Description;
        this.Status = Status;
        this.TimeOfCreate = TimeOfCreate;
        this.Denfense = Denfense;
    }

    public String getArmorID() {
        return ArmorID;
    }

    public void setArmorID(String ArmorID) {
        this.ArmorID = ArmorID;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTimeOfCreate(Date TimeOfCreate) {
        this.TimeOfCreate = TimeOfCreate;
    }

    public int getDenfense() {
        return Denfense;
    }

    public void setDenfense(int Denfense) {
        this.Denfense = Denfense;
    }

    @Override
    public String toString() {
        return "ArmorDTO{" + "ArmorID=" + ArmorID + ", Classification=" + Classification + ", Description=" + Description + ", Status=" + Status + ", TimeOfCreate=" + TimeOfCreate + ", Denfense=" + Denfense + '}';
    }
    
}
