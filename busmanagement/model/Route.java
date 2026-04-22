package busmanagement.model;

public class Route {
    private String routeId;
    private String startLocation;
    private String destination;
    private double distance;
    private String estimatedTime;

    public Route() {
    }

    public Route(String routeId, String startLocation, String destination, double distance, String estimatedTime) {
        this.routeId = routeId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", estimatedTime='" + estimatedTime + '\'' +
                '}';
    }
}
