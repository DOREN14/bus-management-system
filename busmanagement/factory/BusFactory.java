package busmanagement.factory;


import busmanagement.core.BusManager;

import busmanagement.buses.CityBus;
import busmanagement.buses.ElectricBus;
import busmanagement.buses.ExpressBus;
import busmanagement.buses.LuxuryBus;
import busmanagement.buses.SchoolBus;
import busmanagement.buses.TouristBus;


public class BusFactory {

    public static BusManager createBus(String busType, String vehicleId, String vehicleName,
            int capacity, String fuelType, String currentLocation,
            String status, String driverName, String busNumber,
            String routeAssigned) {

        switch (busType.toLowerCase()) {
            case "city":
                return new CityBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, true);

            case "express":
                return new ExpressBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, true);

            case "luxury":
                return new LuxuryBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, true);

            case "school":
                return new SchoolBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, "Green Hills School");

            case "tourist":
                return new TouristBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, "John Guide");

            case "electric":
                return new ElectricBus(vehicleId, vehicleName, capacity, fuelType, currentLocation,
                        status, driverName, busNumber, routeAssigned, 500.0);

            default:
                throw new IllegalArgumentException(
                        "Invalid bus type. Allowed types are: city, express, luxury, school, tourist, electric.");
        }
    }
}
