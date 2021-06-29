package phucdn.dto.object;

import java.io.Serializable;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String fulllname;
    private String phone;
    private String email;
    private String address;
    private String roleID;
    private String status;
    private Date dateOfCreate;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fulllname, String phone, String email, String address, String roleID, String status, Date dateOfCreate) {
        this.userID = userID;
        this.password = password;
        this.fulllname = fulllname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.roleID = roleID;
        this.status = status;
        this.dateOfCreate = dateOfCreate;
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

    public String getFulllname() {
        return fulllname;
    }

    public void setFulllname(String fulllname) {
        this.fulllname = fulllname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", password=" + password + ", fulllname=" + fulllname + ", phone=" + phone + ", email=" + email + ", address=" + address + ", roleID=" + roleID + ", status=" + status + ", dateOfCreate=" + dateOfCreate + '}';
    }
    
}
