/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.assignment;

import java.sql.Timestamp;

/**
 *
 * @author eric
 */
public class CustomerOrder {
    private int orderID;
    private String customerEmail;
    private String paymentMethod;
    private int deviceID;
    private Timestamp dateOrdered;
    private double totalPrice;
    private double shippingCost;
    private String shippingType;
    private String status;
    private String StreetAddress;
    private String UnitNumber;
    private String City;
    private String State;
    private String PostalCode;
    private String PhoneNumber ;

    public CustomerOrder(int orderID, String customerEmail, String paymentID, int deviceID, Timestamp dateOrdered, double totalPrice,double shippingCost, String shippingType, String status, String UnitNumber, String StreetAddress, String City, String State, String PostalCode, String PhoneNumber) {
        this.orderID = orderID;
        this.customerEmail = customerEmail;
        this.paymentMethod = paymentID;
        this.deviceID = deviceID;
        this.dateOrdered = dateOrdered;
        this.totalPrice = totalPrice;
        this.shippingCost = shippingCost;
        this.shippingType = shippingType;
        this.status = status;
        this.UnitNumber = UnitNumber;
        this.StreetAddress = StreetAddress;
        this.City = City;
        this.State = State;
        this.PostalCode = PostalCode;
        this.PhoneNumber = PhoneNumber;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentID(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public Timestamp getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Timestamp dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnitNumber() {
        return UnitNumber;
    }

    public void setUnitNumber(String UnitNumber) {
        this.UnitNumber = UnitNumber;
    }
    
    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String StreetAddress) {
        this.StreetAddress = StreetAddress;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    
}
