package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Payment {
    String paymentId;
    BigDecimal paymentAmount;
    String cardName;
    String cardNo;
    String CVC;
    String customerID;
    String paymentMethod;
    Date paymentDate;

    public Payment(String paymentId, BigDecimal paymentAmount, String cardName, String cardNo, String CVC, String customerID, String paymentMethod, Date paymentDate) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.CVC = CVC;
        this.customerID = customerID;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}