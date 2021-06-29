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
public class BookingDTO implements Serializable{
    private String bookingID;
    private String userID;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private Date dateOfCreate;
    private String discountID;
    private String paymentMethod;
    private double subTotal;
    private double shipping;
    private double tax;
    private double total;
    private String status;

    public BookingDTO() {
    }

    public BookingDTO(String bookingID, String userID, String fullname, String phone, String email, String address, Date dateOfCreate, String discountID, String paymentMethod, double subTotal, double shipping, double tax, double total, String status) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfCreate = dateOfCreate;
        this.discountID = discountID;
        this.paymentMethod = paymentMethod;
        this.subTotal = subTotal;
        this.shipping = shipping;
        this.tax = tax;
        this.total = total;
        this.status = status;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
