package busmanagement.buses;

import busmanagement.core.BusManager;


public class ElectricBus extends BusManager {
    private double batteryCapacity;

    public ElectricBus() {
    }

    public ElectricBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, double batteryCapacity) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.08;
    }

    @Override
    public void performMaintenanceCheck() {
        System.out.println("ElectricBus maintenance check: battery, charging system, and motor checked.");
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("ElectricBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Status: " + getStatus());
    }

    @Override
    public String toString() {
        return "ElectricBus{" +
                "batteryCapacity=" + batteryCapacity +
                ", " + super.toString() +
                '}';
    }
}