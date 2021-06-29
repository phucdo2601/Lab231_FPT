/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class BookingDetailsDTO implements Serializable{
    private String bookingDetailsID;
    private String bookingID;
    private String itemID;
    private String itemName;
    private int quantity;
    private String imgUrl;
    private Date dateOfBegin;
    private Date dateOfEnd;

    public BookingDetailsDTO() {
    }

    public BookingDetailsDTO(String bookingDetailsID, String bookingID, String itemID, String itemName, int quantity, String imgUrl,Date dateOfBegin, Date dateOfEnd) {
        this.bookingDetailsID = bookingDetailsID;
        this.bookingID = bookingID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
    }

    public BookingDetailsDTO(String bookingDetailsID) {
        this.bookingDetailsID = bookingDetailsID;
    }

    public String getBookingDetailsID() {
        return bookingDetailsID;
    }

    public void setBookingDetailsID(String bookingDetailsID) {
        this.bookingDetailsID = bookingDetailsID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfBegin() {
        return dateOfBegin;
    }

    public void setDateOfBegin(Date dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
