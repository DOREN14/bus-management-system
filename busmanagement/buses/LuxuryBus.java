package busmanagement.buses;

import busmanagement.core.BusManager;

public class LuxuryBus extends BusManager {
    private boolean recliningSeats;

    public LuxuryBus() {
    }

    public LuxuryBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, boolean recliningSeats) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.recliningSeats = recliningSeats;
    }

    public boolean isRecliningSeats() {
        return recliningSeats;
    }

    public void setRecliningSeats(boolean recliningSeats) {
        this.recliningSeats = recliningSeats;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 100;
    }

    @Override
    public void performMaintenanceCheck() {
        System.out.println("LuxuryBus maintenance check: comfort systems, lighting, and premium seats checked.");
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("LuxuryBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("Reclining Seats: " + recliningSeats);
        System.out.println("Status: " + getStatus());
    }

    @Override
    public String toString() {
        return "LuxuryBus{" +
                "recliningSeats=" + recliningSeats +
                ", " + super.toString() +
                '}';
    }
}