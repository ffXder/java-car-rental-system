package src.System;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerNumber;
    private int daysToRent;

    // constructor with parameters
    public Customer(String customerID, String name, String number, int days) {
        this.customerId = customerID;
        this.customerName = name;
        this.customerNumber = number;
        this.daysToRent = days;
    }

    // Getters
    public String getCustomerID() {
        return customerId;
    }

    public String getName() {
        return customerName;
    }

    public String getNumber() {
        return customerNumber;
    }

    public int daysToRent() {
        return daysToRent;
    }

}
