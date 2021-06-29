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
public class PaymentDTO implements Serializable{
    private String bookingID;
    private double subTotal;
    private double shipping;
    private double tax;
    private double total;

    public PaymentDTO() {
    }

    public PaymentDTO(String bookingID, String subTotal, String shipping, String tax, String total) {
        this.bookingID = bookingID;
        this.subTotal = Float.parseFloat(subTotal);
        this.shipping = Float.parseFloat(shipping);
        this.tax = Float.parseFloat(tax);
        this.total = Float.parseFloat(total);
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public String getSubTotal() {
        return String.format("%.2f", subTotal);
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getShipping() {
        return String.format("%.2f", shipping);
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public String getTax() {
        return String.format("%.2f", tax);
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return String.format("%.2f", total);
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
