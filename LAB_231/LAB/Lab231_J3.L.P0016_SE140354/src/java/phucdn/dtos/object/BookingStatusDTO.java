/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.object;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class BookingStatusDTO implements Serializable{
    private String bookStatusID;
    private String bookStatusName;

    public BookingStatusDTO() {
    }

    public BookingStatusDTO(String bookStatusID, String bookStatusName) {
        this.bookStatusID = bookStatusID;
        this.bookStatusName = bookStatusName;
    }

    public String getBookStatusID() {
        return bookStatusID;
    }

    public void setBookStatusID(String bookStatusID) {
        this.bookStatusID = bookStatusID;
    }

    public String getBookStatusName() {
        return bookStatusName;
    }

    public void setBookStatusName(String bookStatusName) {
        this.bookStatusName = bookStatusName;
    }
    
}
