/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author eric
 */
public class Order {
    private int orderID;
    private int userID;
    private String email;
    private String phone;
    private LocalDate orderPlaced;
    private double totalPrice;
    private double includedGST;
    private String shippingAddress;
    private String billingAddress;

    public Order(int orderID, int userID, String email, String phone, LocalDate orderPlaced, double totalPrice, double includedGST, String shippingAddress, String billingAddress) {
        this.orderID = orderID;
        this.userID = userID;
        this.email = email;
        this.phone = phone;
        this.orderPlaced = orderPlaced;
        this.totalPrice = totalPrice;
        this.includedGST = includedGST;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(LocalDate orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getIncludedGST() {
        return includedGST;
    }

    public void setIncludedGST(double includedGST) {
        this.includedGST = includedGST;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }


    
}
