package busmanagement.model;

import busmanagement.core.Vehicle;

public class Maintenance {
    private String maintenanceId;
    private Vehicle vehicle;
    private String maintenanceDate;
    private String description;

    public Maintenance() {
    }

    public Maintenance(String maintenanceId, Vehicle vehicle, String maintenanceDate, String description) {
        this.maintenanceId = maintenanceId;
        this.vehicle = vehicle;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void scheduleMaintenance() {
        System.out.println("Maintenance scheduled successfully for vehicle: " + vehicle.getVehicleName());
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", vehicle=" + vehicle.getVehicleName() +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}