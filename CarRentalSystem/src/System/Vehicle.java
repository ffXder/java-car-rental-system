package System;

public class Vehicle {
    private String vehicleID;
    private String vehicleModel;
    private String vehicleType;
    private boolean isAvailable;
    private double rentalPricePerDay;

    // contructor with parameters
    public Vehicle(String id, String model, String type, double price) {
        this.vehicleID = id;
        this.vehicleModel = model;
        this.vehicleType = type;
        this.rentalPricePerDay = price;
        this.isAvailable = true;
    }

    // getters
    public String getVehicleID() {
        return vehicleID;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean getAvailableVehicle() {
        return isAvailable;
    }

    // setters
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // calculate the rental price
    public double getRentalPrice(int rentalDays) {
        return rentalPricePerDay * rentalDays;
    }
}
