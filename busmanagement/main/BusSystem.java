package busmanagement.main;
import java.util.Scanner;

import busmanagement.core.BusManager;
import busmanagement.validator.InputValidator;

import busmanagement.model.Passenger;
import busmanagement.model.Route;
import busmanagement.model.Ticket;
import busmanagement.model.Booking;
import busmanagement.model.Payment;
import busmanagement.factory.BusFactory;
import busmanagement.validator.ReportGenerator;

public class BusSystem {

    static Scanner input = new Scanner(System.in);

    static BusManager bus = null;
    static Passenger passenger = null;
    static Route route = null;
    static Ticket ticket = null;
    static Booking booking = null;
    static Payment payment = null;

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    createBus();
                    break;
                case 2:
                    createPassenger();
                    break;
                case 3:
                    createRoute();
                    break;
                case 4:
                    createTicket();
                    break;
                case 5:
                    createBooking();
                    break;
                case 6:
                    processPayment();
                    break;
                case 7:
                    trackBus();
                    break;
                case 8:
                    showSystemSummary();
                    break;
                case 9:
                    generateReports();
                    break;
                case 0:
                    System.out.println("Exiting system... Thank you.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0 and 9.");
            }

        } while (choice != 0);

        input.close();
    }

    public static void displayMenu() {
        
        System.out.println("        ADVANCED BUS MANAGEMENT SYSTEM");
        System.out.println("=================================================");
        System.out.println("1. Create Bus");
        System.out.println("2. Create Passenger");
        System.out.println("3. Create Route");
        System.out.println("4. Create Ticket");
        System.out.println("5. Create Booking");
        System.out.println("6. Process Payment");
        System.out.println("7. Track Bus");
        System.out.println("8. Show System Summary");
        System.out.println("9. Generate Reports");
        System.out.println("0. Exit");
        System.out.println("=================================================");
    }

    public static void createBus() {
        try {
            System.out.print("Enter bus type (city, express, luxury, school, tourist, electric): ");
            String busType = input.nextLine();
            InputValidator.validateString(busType, "Bus type");

            System.out.print("Enter vehicle ID (example BS101): ");
            String vehicleId = input.nextLine();
            InputValidator.validateId(vehicleId, "Vehicle ID");

            System.out.print("Enter vehicle name: ");
            String vehicleName = input.nextLine();
            InputValidator.validateString(vehicleName, "Vehicle name");

            int capacity = readInt("Enter capacity: ");
            InputValidator.validatePositiveInt(capacity, "Capacity");

            System.out.print("Enter fuel type: ");
            String fuelType = input.nextLine();
            InputValidator.validateString(fuelType, "Fuel type");

            System.out.print("Enter current location: ");
            String currentLocation = input.nextLine();
            InputValidator.validateString(currentLocation, "Current location");

            System.out.print("Enter status: ");
            String status = input.nextLine();
            InputValidator.validateString(status, "Status");

            System.out.print("Enter driver name: ");
            String driverName = input.nextLine();
            InputValidator.validateString(driverName, "Driver name");

            System.out.print("Enter bus number: ");
            String busNumber = input.nextLine();
            InputValidator.validateString(busNumber, "Bus number");

            System.out.print("Enter assigned route: ");
            String routeAssigned = input.nextLine();
            InputValidator.validateString(routeAssigned, "Route assigned");

            bus = BusFactory.createBus(
                    busType,
                    vehicleId,
                    vehicleName,
                    capacity,
                    fuelType,
                    currentLocation,
                    status,
                    driverName,
                    busNumber,
                    routeAssigned);

            System.out.println("Bus created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createPassenger() {
        try {
            System.out.print("Enter passenger ID (example PS101): ");
            String passengerId = input.nextLine();
            InputValidator.validateId(passengerId, "Passenger ID");

            System.out.print("Enter passenger name: ");
            String passengerName = input.nextLine();
            InputValidator.validateString(passengerName, "Passenger name");

            System.out.print("Enter phone number (10 digits): ");
            String phoneNumber = input.nextLine();
            InputValidator.validatePhone(phoneNumber);

            System.out.print("Enter email: ");
            String email = input.nextLine();
            InputValidator.validateEmail(email);

            passenger = new Passenger(passengerId, passengerName, phoneNumber, email);
            System.out.println("Passenger created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createRoute() {
        try {
            System.out.print("Enter route ID (example RT101): ");
            String routeId = input.nextLine();
            InputValidator.validateId(routeId, "Route ID");

            System.out.print("Enter start location: ");
            String startLocation = input.nextLine();
            InputValidator.validateString(startLocation, "Start location");

            System.out.print("Enter destination: ");
            String destination = input.nextLine();
            InputValidator.validateString(destination, "Destination");

            double distance = readDouble("Enter distance in km: ");
            InputValidator.validatePositiveDouble(distance, "Distance");

            System.out.print("Enter estimated travel time: ");
            String estimatedTime = input.nextLine();
            InputValidator.validateString(estimatedTime, "Estimated time");

            route = new Route(routeId, startLocation, destination, distance, estimatedTime);
            System.out.println("Route created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createTicket() {
        try {
            if (bus == null) {
                System.out.println("You must create a bus first.");
                return;
            }

            if (passenger == null) {
                System.out.println("You must create a passenger first.");
                return;
            }

            if (route == null) {
                System.out.println("You must create a route first.");
                return;
            }

            System.out.print("Enter ticket ID (example TK101): ");
            String ticketId = input.nextLine();
            InputValidator.validateId(ticketId, "Ticket ID");

            int seatNumber = readInt("Enter seat number: ");
            InputValidator.validatePositiveInt(seatNumber, "Seat number");

            if (seatNumber > bus.getCapacity()) {
                throw new IllegalArgumentException("Seat number cannot be greater than bus capacity.");
            }

            if (!bus.bookSeat(1)) {
                throw new IllegalArgumentException("Overbooking is not allowed. No more available seats.");
            }

            ticket = new Ticket(ticketId, passenger, bus, seatNumber, 0.0);
            ticket.calculateTicketPrice(route.getDistance());

            System.out.println("Ticket created successfully.");
            System.out.println("Ticket price: " + ticket.getPrice());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createBooking() {
        try {
            if (passenger == null) {
                System.out.println("You must create a passenger first.");
                return;
            }

            if (ticket == null) {
                System.out.println("You must create a ticket first.");
                return;
            }

            System.out.print("Enter booking ID (example BK101): ");
            String bookingId = input.nextLine();
            InputValidator.validateId(bookingId, "Booking ID");

            System.out.print("Enter booking date: ");
            String bookingDate = input.nextLine();
            InputValidator.validateString(bookingDate, "Booking date");

            booking = new Booking(bookingId, passenger, ticket, bookingDate, "Pending");
            booking.confirmBooking();

            System.out.println("Booking created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void processPayment() {
        try {
            if (ticket == null) {
                System.out.println("You must create a ticket first.");
                return;
            }

            System.out.print("Enter payment ID (example PY101): ");
            String paymentId = input.nextLine();
            InputValidator.validateId(paymentId, "Payment ID");

            System.out.print("Enter payment method: ");
            String paymentMethod = input.nextLine();
            InputValidator.validateString(paymentMethod, "Payment method");

            payment = new Payment(paymentId, ticket.getPrice(), paymentMethod, "Pending");
            payment.processPayment();

            System.out.println("Payment processed successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void trackBus() {
        if (bus == null) {
            System.out.println("You must create a bus first.");
            return;
        }

        if (route == null) {
            System.out.println("You must create a route first.");
            return;
        }

        bus.startVehicle();
        bus.trackLocation();
        bus.assignRoute(route.getStartLocation() + " to " + route.getDestination());
        bus.updateLocation(route.getDestination());
        bus.updateStatus("On Trip");
        bus.performMaintenanceCheck();
        bus.generateVehicleReport();
    }

    public static void showSystemSummary() {
        System.out.println("\n================ SYSTEM SUMMARY ================");

        if (bus != null) {
            System.out.println(bus);
        } else {
            System.out.println("Bus: Not created");
        }

        if (passenger != null) {
            System.out.println(passenger);
        } else {
            System.out.println("Passenger: Not created");
        }

        if (route != null) {
            System.out.println(route);
        } else {
            System.out.println("Route: Not created");
        }

        if (ticket != null) {
            System.out.println(ticket);
        } else {
            System.out.println("Ticket: Not created");
        }

        if (booking != null) {
            System.out.println(booking);
        } else {
            System.out.println("Booking: Not created");
        }

        if (payment != null) {
            System.out.println(payment);
        } else {
            System.out.println("Payment: Not created");
        }
    }

    public static void generateReports() {
        System.out.println("\n================ REPORTS ================");

        if (booking != null) {
            ReportGenerator.generateDailyBookingsReport(booking);
        } else {
            System.out.println("Daily booking report cannot be generated. Booking not created.");
        }

        if (payment != null) {
            ReportGenerator.generateRevenueReport(payment);
        } else {
            System.out.println("Revenue report cannot be generated. Payment not created.");
        }

        if (bus != null) {
            ReportGenerator.generateBusUsageReport(bus);
        } else {
            System.out.println("Bus usage report cannot be generated. Bus not created.");
        }

        if (passenger != null) {
            ReportGenerator.generatePassengerStatistics(passenger);
        } else {
            System.out.println("Passenger statistics report cannot be generated. Passenger not created.");
        }
    }

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid decimal number.");
            }
        }
    }
}