package busmanagement.core;


public class BusManager extends Vehicle implements Bookable, Trackable {
    private String driverName;
    private String busNumber;
    private String routeAssigned;
    private int bookedSeats;

    public BusManager() {
    }

    public BusManager(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status);
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeAssigned = routeAssigned;
        this.bookedSeats = 0;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRouteAssigned() {
        return routeAssigned;
    }

    public void setRouteAssigned(String routeAssigned) {
        this.routeAssigned = routeAssigned;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println(getVehicleName() + " has started.");
    }

    @Override
    public void stopVehicle() {
        setStatus("Stopped");
        System.out.println(getVehicleName() + " has stopped.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.2;
    }

    @Override
    public boolean checkAvailability() {
        return bookedSeats < getCapacity();
    }

    @Override
    public void assignRoute(String route) {
        this.routeAssigned = route;
        System.out.println("Route assigned: " + route);
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
        System.out.println("Location updated to: " + location);
    }

    @Override
    public void performMaintenanceCheck() {
        System.out.println("Maintenance check completed for bus " + busNumber);
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("Vehicle Report: " + this.toString());
    }

    @Override
    public boolean bookSeat(int seats) {
        if (bookedSeats + seats <= getCapacity()) {
            bookedSeats += seats;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelBooking(int seats) {
        if (bookedSeats - seats >= 0) {
            bookedSeats -= seats;
            return true;
        }
        return false;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 50;
    }

    @Override
    public void trackLocation() {
        System.out.println("Current bus location: " + getCurrentLocation());
    }

    @Override
    public void updateStatus(String status) {
        setStatus(status);
        System.out.println("Bus status updated to: " + status);
    }

    @Override
    public String toString() {
        return "BusManager{" +
                "vehicle=" + super.toString() +
                ", driverName='" + driverName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", routeAssigned='" + routeAssigned + '\'' +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}

