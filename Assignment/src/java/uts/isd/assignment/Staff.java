/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.assignment;

/**
 *
 * @author eric
 */
public class Staff {
    private int staffID;
    private String staffFirstName;
    private String staffLastName;
    private String staffEmail;
    private String staffPassword;
    
    
    public Staff(int staffID, String staffFirstName, String staffLastName, String staffEmail, String staffUsername, String staffPassword) {
    this.staffID = staffID;
    this.staffFirstName = staffFirstName;
    this.staffLastName = staffLastName;
    this.staffEmail = staffEmail;
    this.staffPassword = staffPassword;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = staffLastName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }


    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
    
    
}
