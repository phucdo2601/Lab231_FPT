/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class ItemDTO implements Serializable{
    private String itemID;
    private String itemName;
    private String author;
    private String cateID;
    private int quantity;
    private String imgUrl;
    private double price;
    private Timestamp dateOfCreate;
    private String description;
    private String status;

    public ItemDTO() {
    }

    public ItemDTO(String itemID, String itemName, String author, String cateID, int quantity, String imgUrl, double price, Timestamp dateOfCreate, String description, String status) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.author = author;
        this.cateID = cateID;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
        this.price = price;
        this.dateOfCreate = dateOfCreate;
        this.description = description;
        this.status = status;
    }

    public ItemDTO(String itemID, String itemName, String imgUrl, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.imgUrl = imgUrl;
        this.price = price;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Timestamp dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "itemID=" + itemID + ", itemName=" + itemName + ", author=" + author + ", cateID=" + cateID + ", quantity=" + quantity + ", imgUrl=" + imgUrl + ", price=" + price + ", dateOfCreate=" + dateOfCreate + ", description=" + description + ", status=" + status + '}';
    }
}
