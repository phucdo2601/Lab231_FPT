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
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private String imgURL;
    private String roleID;
    private String status;
    private String promoStatus;
    private int rankPromo;
    private Date dateOfCreate;
    private Date dateOfAddPromo;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullname, String email, String phone, String imgURL, String roleID, String status, String promoStatus, int rankPromo, Date dateOfCreate, Date dateOfAddPromo) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.imgURL = imgURL;
        this.roleID = roleID;
        this.status = status;
        this.promoStatus = promoStatus;
        this.rankPromo = rankPromo;
        this.dateOfCreate = dateOfCreate;
        this.dateOfAddPromo = dateOfAddPromo;
    }

    public UserDTO(String userID, String password, String fullname, String email, String phone, String imgURL) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.imgURL = imgURL;
    }
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(String promoStatus) {
        this.promoStatus = promoStatus;
    }

    public int getRankPromo() {
        return rankPromo;
    }

    public void setRankPromo(int rankPromo) {
        this.rankPromo = rankPromo;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfAddPromo() {
        return dateOfAddPromo;
    }

    public void setDateOfAddPromo(Date dateOfAddPromo) {
        this.dateOfAddPromo = dateOfAddPromo;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }  
}
