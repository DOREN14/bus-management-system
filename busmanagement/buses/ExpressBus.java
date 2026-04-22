package busmanagement.buses;

import busmanagement.core.BusManager;

public class ExpressBus extends BusManager {
    private boolean airConditioning;

    public ExpressBus() {
    }

    public ExpressBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, boolean airConditioning) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.airConditioning = airConditioning;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 70;
    }

    @Override
    public void startVehicle() {
        setStatus("Express Bus Running");
        System.out.println(getVehicleName() + " started for long-distance travel.");
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("ExpressBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("Air Conditioning: " + airConditioning);
        System.out.println("Route Assigned: " + getRouteAssigned());
    }

    @Override
    public String toString() {
        return "ExpressBus{" +
                "airConditioning=" + airConditioning +
                ", " + super.toString() +
                '}';
    }
}
