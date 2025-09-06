package src.System;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Vehicle> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rents = new ArrayList<>();
    AccessDatabase access = new AccessDatabase();

    public void initializeCars() {
        cars.add(new Vehicle("A00", "Toyota Camry", "Sedan", 1999.0));
        cars.add(new Vehicle("B01", "Toyota Hiace", "Van", 3499.0));
        cars.add(new Vehicle("C03", "Mitsubishi Montero", "SUV", 3499.0));
        cars.add(new Vehicle("D04", "Mitsubishi Xpander", "MPV", 2699.0));
    }

    public void rentCar() {
        Scanner in = new Scanner(System.in);
        System.out.println("==== Rent a Car ====");

        // Input customer details
        System.out.print("Enter your Name: ");
        String customerName = in.nextLine();
        System.out.print("Enter your Phone Number: ");
        String phoneNumber = in.nextLine();

        // Show available cars
        availableCars();

        // Input rental details
        System.out.print("Enter vehicle ID to rent: ");
        String vehicleID = in.nextLine();
        System.out.print("Enter the days you want to rent: ");
        int daysToRent = in.nextInt();
        in.nextLine();

        // Rent car
        Vehicle selectedVehicle = findAvailableCar(vehicleID);
        if (selectedVehicle == null) {
            System.out.println("Vehicle ID not found or the car is not available!");
            return;
        }
        if (daysToRent <= 7) {
            System.out.println("Are you sure want to continue(Y/N)? ");
            String promptConfirm = in.nextLine();

            if (promptConfirm.equalsIgnoreCase("y")) {
                Customer customer = new Customer(String.valueOf(customers.size() + 1), customerName, phoneNumber, daysToRent);
                customers.add(customer);
                selectedVehicle.setAvailable(false);
                Rental rental = new Rental(String.valueOf(rents.size() + 1), selectedVehicle, customer, daysToRent);
                rents.add(rental);

                double totalRentPrice = selectedVehicle.getRentalPrice(daysToRent);

                System.out.println("You have successfully reserved!");
                System.out.println("==== Rental Information ====");
                System.out.println("Customer ID: " + customer.getCustomerID() + ", Name: " + customer.getName());
                System.out.println("Vehicle ID: " + selectedVehicle.getVehicleID() + ", Model: " + selectedVehicle.getVehicleModel() + ", " + selectedVehicle.getVehicleType());
                System.out.println("Rental Price: Php: " + totalRentPrice);
            } else {
                System.out.println("Reservation cancelled! Thank you for using our system!");
            }
        } else {
            System.out.println("The limit for renting a car is only 7 days!");
        }
    }

    public void returnCar() {
        Scanner in = new Scanner(System.in);
        System.out.println("==== Returning a Car ====");

        System.out.print("Enter your Customer ID: ");
        String customerID = in.nextLine();

        Rental rental = findRentedCar(customerID);
        if (rental == null) {
            System.out.println("Customer ID not found!");
            return;
        }

        Vehicle rentedVehicle = rental.getVehicle();
        rentedVehicle.setAvailable(true);
        rents.remove(rental);

        System.out.println("Car returned successfully!");
    }

    public void availableCars() {
//        System.out.println("==== Available Cars ====");
//        System.out.println("| ID | Model | Type | Rental Price |");
//
//        for (Vehicle car : cars) {
//            if (car.getAvailableVehicle()) {
//                System.out.println("| " + car.getVehicleID() + " | " + car.getVehicleModel() + " | " + car.getVehicleType() + " | " + car.getRentalPrice(1) + " |");
//            }
//        }
        access.ShowVehicle();
    }

    public void listReservations() {
        System.out.println("==== List of Reservations ====");
        System.out.println("| Rental ID | Customer Name | Vehicle Model | Rental Days |");

        for (Rental rental : rents) {
            Customer customer = rental.getCustomer();
            Vehicle vehicle = rental.getVehicle();

            System.out.println("| " + rental.getRentalID() + " | " + customer.getName() + " | " + vehicle.getVehicleModel() + " | " + rental.getDays() + " |");
        }
    }

    public Vehicle findAvailableCar(String vehicleID) {
        for (Vehicle car : cars) {
            if (car.getVehicleID().equalsIgnoreCase(vehicleID) && car.getAvailableVehicle()) {
                return car;
            }
        }
        return null;
    }

    public Rental findRentedCar(String customerID) {
        for (Rental rental : rents) {
            if (rental.getCustomer().getCustomerID().equalsIgnoreCase(customerID)) {
                return rental;
            }
        }
        return null;
    }
}
