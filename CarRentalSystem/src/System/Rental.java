package src.System;

public class Rental {
    private String rentalID;
    private Vehicle car;
    private int days;
    private Customer client;

    public Rental(String id, Vehicle car, Customer client, int days) {
        this.rentalID = id;
        this.car = car;
        this.days = days;
        this.client = client;
    }

    // getters
    public String getRentalID() {
        return rentalID;
    }

    public Vehicle getVehicle() {
        return car;
    }

    public Customer getCustomer() {
        return client;
    }

    public int getDays() {
        return days;
    }
}
