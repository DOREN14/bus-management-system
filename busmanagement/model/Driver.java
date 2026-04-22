package busmanagement.model;

public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private int experience;

    public Driver() {
    }

    public Driver(String driverId, String name, String licenseNumber, int experience) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experience = experience;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", experience=" + experience +
                '}';
    }
}