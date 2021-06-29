/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author phucd
 */
public class OrderDTO  implements Serializable{

    private String orderID;
    private String username;
    private String customerName;
    private String addressSending;
    private String phoneNumber;
    private double totalPrice;
    private Timestamp dateOfBooking;
    private Timestamp dateOfFinishing;
    private String payment;
    private boolean waiting;
    private boolean finishing;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String username, String customerName, String addressSending, double totalPrice, Timestamp dateOfBooking, String payment, boolean waiting, boolean finishing) {
        this.orderID = orderID;
        this.username = username;
        this.customerName = customerName;
        this.addressSending = addressSending;
        this.totalPrice = totalPrice;
        this.dateOfBooking = dateOfBooking;
        this.payment = payment;
        this.waiting = waiting;
        this.finishing = finishing;
    }

    public OrderDTO(String orderID, String username, String customerName, String addressSending, double totalPrice, Timestamp dateOfBooking, Timestamp dateOfFinishing, String payment, boolean waiting, boolean finishing) {
        this.orderID = orderID;
        this.username = username;
        this.customerName = customerName;
        this.addressSending = addressSending;
        this.totalPrice = totalPrice;
        this.dateOfBooking = dateOfBooking;
        this.dateOfFinishing = dateOfFinishing;
        this.payment = payment;
        this.waiting = waiting;
        this.finishing = finishing;
    }

    public OrderDTO(String orderID, String username, String customerName, String addressSending, String phoneNumber, double totalPrice, Timestamp dateOfBooking, String payment, boolean waiting, boolean finishing) {
        this.orderID = orderID;
        this.username = username;
        this.customerName = customerName;
        this.addressSending = addressSending;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
        this.dateOfBooking = dateOfBooking;
        this.payment = payment;
        this.waiting = waiting;
        this.finishing = finishing;
    }

    public OrderDTO(String orderID, String username, String customerName, String addressSending, String phoneNumber, double totalPrice, Timestamp dateOfBooking, Timestamp dateOfFinishing, String payment, boolean waiting, boolean finishing) {
        this.orderID = orderID;
        this.username = username;
        this.customerName = customerName;
        this.addressSending = addressSending;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
        this.dateOfBooking = dateOfBooking;
        this.dateOfFinishing = dateOfFinishing;
        this.payment = payment;
        this.waiting = waiting;
        this.finishing = finishing;
    }
    public OrderDTO(String orderID, String username, String customerName, String addressSending, double totalPrice, Timestamp dateOfBooking, Timestamp dateOfFinishing, String payment, boolean finishing) {
        this.orderID = orderID;
        this.username = username;
        this.customerName = customerName;
        this.addressSending = addressSending;
        this.totalPrice = totalPrice;
        this.dateOfBooking = dateOfBooking;
        this.dateOfFinishing = dateOfFinishing;
        this.payment = payment;
        this.finishing = finishing;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddressSending() {
        return addressSending;
    }

    public void setAddressSending(String addressSending) {
        this.addressSending = addressSending;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Timestamp dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Timestamp getDateOfFinishing() {
        return dateOfFinishing;
    }

    public void setDateOfFinishing(Timestamp dateOfFinishing) {
        this.dateOfFinishing = dateOfFinishing;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isFinishing() {
        return finishing;
    }

    public void setFinishing(boolean finishing) {
        this.finishing = finishing;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
