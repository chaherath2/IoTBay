/*
 */
package uts.isd.assignment;

/**
 *
 * @author shawaiz
 */
public class Customer {
    private String name;
    private String email;
    private String password;
    private String dob;
    private String unitNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String postcode;
    private String phoneNumber;

    public Customer(String name, String email, String password, String dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    
    
}
