package busmanagement.model;

public abstract class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private int capacity;
    private String fuelType;
    private String currentLocation;
    private String status;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation,
            String status) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.currentLocation = currentLocation;
        this.status = status;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void startVehicle();

    public abstract void stopVehicle();

    public abstract double calculateFuelConsumption(double distance);

    public abstract boolean checkAvailability();

    public abstract void assignRoute(String route);

    public abstract void updateLocation(String location);

    public abstract void performMaintenanceCheck();

    public abstract void generateVehicleReport();

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}