/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class DiscountDTO implements Serializable{
    private String disID;
    private String disName;
    private int rateDis;
    private boolean isUsing;
    private boolean isAddAcc;
    private Date dateOfCreate;
    private String userID;

    public DiscountDTO() {
    }

    public DiscountDTO(String disID, String disName, int rateDis, boolean isUsing, boolean isAddAcc, Date dateOfCreate, String userID) {
        this.disID = disID;
        this.disName = disName;
        this.rateDis = rateDis;
        this.isUsing = isUsing;
        this.isAddAcc = isAddAcc;
        this.dateOfCreate = dateOfCreate;
        this.userID = userID;
    }

    public String getDisID() {
        return disID;
    }

    public void setDisID(String disID) {
        this.disID = disID;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public int getRateDis() {
        return rateDis;
    }

    public void setRateDis(int rateDis) {
        this.rateDis = rateDis;
    }

    public boolean isIsUsing() {
        return isUsing;
    }

    public void setIsUsing(boolean isUsing) {
        this.isUsing = isUsing;
    }

    public boolean isIsAddAcc() {
        return isAddAcc;
    }

    public void setIsAddAcc(boolean isAddAcc) {
        this.isAddAcc = isAddAcc;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "DiscountDTO{" + "disID=" + disID + ", disName=" + disName + ", rateDis=" + rateDis + ", isUsing=" + isUsing + ", isAddAcc=" + isAddAcc + ", dateOfCreate=" + dateOfCreate + ", userID=" + userID + '}';
    }

    
}
