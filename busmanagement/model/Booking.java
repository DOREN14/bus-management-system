package busmanagement.model;

public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;
    private String bookingDate;
    private String status;

    public Booking() {
    }

    public Booking(String bookingId, Passenger passenger, Ticket ticket, String bookingDate, String status) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.ticket = ticket;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void confirmBooking() {
        this.status = "Confirmed";
        System.out.println("Booking confirmed successfully.");
    }

    public void cancelBooking() {
        this.status = "Cancelled";
        System.out.println("Booking cancelled successfully.");
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", passenger=" + passenger +
                ", ticket=" + ticket +
                ", bookingDate='" + bookingDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
