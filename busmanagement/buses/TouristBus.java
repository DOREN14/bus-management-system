package busmanagement.buses;

import busmanagement.core.BusManager;

public class TouristBus extends BusManager {
    private String tourGuideName;

    public TouristBus() {
    }

    public TouristBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, String tourGuideName) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.tourGuideName = tourGuideName;
    }

    public String getTourGuideName() {
        return tourGuideName;
    }

    public void setTourGuideName(String tourGuideName) {
        this.tourGuideName = tourGuideName;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 90;
    }

    @Override
    public void assignRoute(String route) {
        setRouteAssigned(route);
        System.out.println("Tourist route assigned with sightseeing stops: " + route);
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("TouristBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("Tour Guide: " + tourGuideName);
        System.out.println("Route Assigned: " + getRouteAssigned());
    }

    @Override
    public String toString() {
        return "TouristBus{" +
                "tourGuideName='" + tourGuideName + '\'' +
                ", " + super.toString() +
                '}';
    }
}