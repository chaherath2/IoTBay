/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author eric
 */
public class OrderLine {
    private Device product;
    private int quantity;

    public OrderLine(Device product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Device getProduct() {
        return product;
    }

    public void setProduct(Device product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(product.getPrice() * quantity));
    }
}
