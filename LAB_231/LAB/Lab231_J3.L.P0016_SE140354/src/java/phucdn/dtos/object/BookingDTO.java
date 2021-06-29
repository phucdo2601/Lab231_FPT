/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class BookingDTO implements Serializable{
   private String userId;
   private String bookingID;
   private Timestamp dateOfBook;
   private Timestamp dateOfConfirm;
   private String status;

    public BookingDTO() {
    }

    public BookingDTO(String userId, String bookingID, Timestamp dateOfBook, Timestamp dateOfConfirm, String status) {
        this.userId = userId;
        this.bookingID = bookingID;
        this.dateOfBook = dateOfBook;
        this.dateOfConfirm = dateOfConfirm;
        this.status = status;
    }

    public BookingDTO(String userId, String bookingID, Timestamp dateOfBook) {
        this.userId = userId;
        this.bookingID = bookingID;
        this.dateOfBook = dateOfBook;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Timestamp getDateOfBook() {
        return dateOfBook;
    }

    public void setDateOfBook(Timestamp dateOfBook) {
        this.dateOfBook = dateOfBook;
    }

    public Timestamp getDateOfConfirm() {
        return dateOfConfirm;
    }

    public void setDateOfConfirm(Timestamp dateOfConfirm) {
        this.dateOfConfirm = dateOfConfirm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
