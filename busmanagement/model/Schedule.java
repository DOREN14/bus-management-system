package busmanagement.model;

import busmanagement.core.BusManager;

public class Schedule {
    private String scheduleId;
    private BusManager bus;
    private String departureTime;
    private String arrivalTime;
    private Route route;

    public Schedule() {
    }

    public Schedule(String scheduleId, BusManager bus, String departureTime, String arrivalTime, Route route) {
        this.scheduleId = scheduleId;
        this.bus = bus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = route;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public BusManager getBus() {
        return bus;
    }

    public void setBus(BusManager bus) {
        this.bus = bus;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", bus=" + bus.getBusNumber() +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", route=" + route +
                '}';
    }
}