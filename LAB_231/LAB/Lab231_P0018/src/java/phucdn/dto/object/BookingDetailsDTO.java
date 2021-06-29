/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class BookingDetailsDTO implements Serializable{
    private String bookingDeID;
    private String bookingID;
    private String itemID;
    private String itemName;
    private String imgUrl;
    private int quantity;
    private double price;

    public BookingDetailsDTO() {
    }

    public BookingDetailsDTO(String bookingDeID, String bookingID, String itemID, String itemName, String imgUrl, int quantity, double price) {
        this.bookingDeID = bookingDeID;
        this.bookingID = bookingID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBookingDeID() {
        return bookingDeID;
    }

    public void setBookingDeID(String bookingDeID) {
        this.bookingDeID = bookingDeID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
