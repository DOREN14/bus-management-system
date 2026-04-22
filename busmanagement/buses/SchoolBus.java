package busmanagement.buses;

import busmanagement.core.BusManager;

public class SchoolBus extends BusManager {
    private String schoolName;

    public SchoolBus() {
    }

    public SchoolBus(String vehicleId, String vehicleName, int capacity, String fuelType,
            String currentLocation, String status, String driverName,
            String busNumber, String routeAssigned, String schoolName) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber,
                routeAssigned);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 20;
    }

    @Override
    public void startVehicle() {
        setStatus("School Bus Running");
        System.out.println(getVehicleName() + " started safely for student transport.");
    }

    @Override
    public void generateVehicleReport() {
        System.out.println("SchoolBus Report");
        System.out.println("Bus Number: " + getBusNumber());
        System.out.println("School Name: " + schoolName);
        System.out.println("Current Location: " + getCurrentLocation());
    }

    @Override
    public String toString() {
        return "SchoolBus{" +
                "schoolName='" + schoolName + '\'' +
                ", " + super.toString() +
                '}';
    }
}