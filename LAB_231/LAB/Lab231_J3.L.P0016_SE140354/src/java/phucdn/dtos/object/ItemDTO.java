/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;


/**
 *
 * @author ASUS
 */
public class ItemDTO implements Serializable{
    private String itemID;
    private String itemName;
    private String cateID;
    private String color;
    private int quantity;
    private String status;
    private Date dateOfPost;
    private String imgUrl;
    private Date dateOfPickUp;
    private Date dateOfEnd;

    public ItemDTO() {
    }

    public ItemDTO(String itemID, String itemName, String cateID, String color, int quantity, String status, Date dateOfPost, String imgUrl) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cateID = cateID;
        this.color = color;
        this.quantity = quantity;
        this.status = status;
        this.dateOfPost = dateOfPost;
        this.imgUrl = imgUrl;
    }

    public ItemDTO(String itemID, String itemName, String cateID, String color, int quantity, String status, Date dateOfPost) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cateID = cateID;
        this.color = color;
        this.quantity = quantity;
        this.status = status;
        this.dateOfPost = dateOfPost;
    }

    public ItemDTO(String itemID, String itemName, String imgUrl) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.imgUrl = imgUrl;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
