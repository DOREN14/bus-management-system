package busmanagement.buses;


import busmanagement.core.BusManager;



public class CityBus extends BusManager {
    private boolean wifiAvailable;

    public CityBus() {
    }

    public CityBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, boolean wifiAvailable) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.wifiAvailable = wifiAvailable;
    }

    public boolean isWifiAvailable() {
        return wifiAvailable;
    }

    public void setWifiAvailable(boolean wifiAvailable) {
        this.wifiAvailable = wifiAvailable;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 40;
    }

    @Override
    public void performMaintenanceCheck() {
        System.out.println("CityBus maintenance check: tires, brakes, and passenger doors checked.");
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("CityBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("WiFi Available: " + wifiAvailable);
        System.out.println("Current Location: " + getCurrentLocation());
    }

    @Override
    public String toString() {
        return "CityBus{" +
                "wifiAvailable=" + wifiAvailable +
                ", " + super.toString() +
                '}';
    }
}