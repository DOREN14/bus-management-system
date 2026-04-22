package busmanagement.core;

public interface Bookable {
    boolean bookSeat(int seats);

    boolean cancelBooking(int seats);

    double calculateFare(double distance);
}