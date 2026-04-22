package busmanagement.validator;

import busmanagement.model.Booking;
import busmanagement.core.BusManager;
import busmanagement.model.Passenger;
import busmanagement.model.Payment;

public class ReportGenerator {

    public static void generateDailyBookingsReport(Booking booking) {
        System.out.println("\n               DAILY BOOKINGS REPORT           ");
        System.out.println("Booking Details:");
        System.out.println(booking);
    }

    public static void generateRevenueReport(Payment payment) {
        System.out.println("\n          REVENUE REPORT            ");
        System.out.println("Total Revenue Collected: " + payment.getAmount());
        System.out.println("Payment Status: " + payment.getPaymentStatus());
    }

    public static void generateBusUsageReport(BusManager bus) {
        System.out.println("\n             BUS USAGE REPORT           ");
        System.out.println("Bus Number: " + bus.getBusNumber());
        System.out.println("Driver Name: " + bus.getDriverName());
        System.out.println("Route Assigned: " + bus.getRouteAssigned());
        System.out.println("Booked Seats: " + bus.getBookedSeats());
        System.out.println("Capacity: " + bus.getCapacity());
        System.out.println("Current Status: " + bus.getStatus());
    }

    public static void generatePassengerStatistics(Passenger passenger) {
        System.out.println("\n           PASSENGER STATISTICS REPORT             ");
        System.out.println("Passenger ID: " + passenger.getPassengerId());
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Phone Number: " + passenger.getPhoneNumber());
        System.out.println("Email: " + passenger.getEmail());
    }
}