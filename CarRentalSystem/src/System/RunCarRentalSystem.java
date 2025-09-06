package src.System;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunCarRentalSystem {

    public static void main(String[] args) {
        src.System.CarRentalSystem carRentalSystem = new CarRentalSystem();


        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("----------------------------"); 
                System.out.println("Welcome to Car Rental System");
                System.out.println("----------------------------");
                System.out.println("1. Rent a car");
                System.out.println("2. Return a car");
                System.out.println("3. Check available cars");
                System.out.println("4. List reservations");
                System.out.println("5. Exit");
                System.out.print("- ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        carRentalSystem.rentCar();
                        break;
                    case 2:
                        carRentalSystem.returnCar();
                        break;
                    case 3:
                        carRentalSystem.availableCars();
                        break;
                    case 4:
                        carRentalSystem.listReservations();
                        break;
                    case 5:
                        System.out.println("Exit Program! Thank you for using the car rental system!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                input.next();
            }
        }
    }
}