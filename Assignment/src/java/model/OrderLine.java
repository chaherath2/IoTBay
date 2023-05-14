/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eric
 */
public class OrderLine {
    private int orderID;
    private int orderlineID;
    private int itemQuantity;
    private int productID;
    private String productName;
    private double GST;
    private double price;
    private double totalPrice;

    public OrderLine(int orderID, int orderlineID, int itemQuantity, int productID, String productName, double GST, double price, double totalPrice) {
        this.orderID = orderID;
        this.orderlineID = orderlineID;
        this.itemQuantity = itemQuantity;
        this.productID = productID;
        this.productName = productName;
        this.GST = GST;
        this.price = price;
        this.totalPrice = GST + (price * itemQuantity);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderlineID() {
        return orderlineID;
    }

    public void setOrderlineID(int orderlineID) {
        this.orderlineID = orderlineID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void addItemQuantity(){
        this.itemQuantity++;
        this.totalPrice = this.totalPrice + GST +(price * itemQuantity);
    }
    
    public void removeItemQuantity(){
        this.itemQuantity--;
        this.totalPrice = this.totalPrice - GST +(price * itemQuantity);
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getGST() {
        return GST;
    }

    public void setGST(double GST) {
        this.GST = GST;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = this.GST + (this.price * this.itemQuantity);
    }
}
