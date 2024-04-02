package com.example.StationDetails.model;

import jakarta.persistence.*;

@Entity(name = "trainroute")
public class TrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name="stationId",nullable =false)
    private StationDetails stationId;

    @ManyToOne
    @JoinColumn(name="trainId", nullable=false)
    private TrainDetails trainId;

    @Column(name = "IntermediateStations")
    private boolean intermediateStations;

    @Column(name = "RouteNo")
    private int routeNo;

    @Column(name = "StopNumber")
    private int stopNumber;

    @Column(name = "TrainMappingKey")
    private String trainMappingKey;

    @Column(name = "ArrivalTime")
    private String arrivalTime;

    @Column(name = "DepartureTime")
    private String departureTime;

    @Column(name = "HaltMinutes")
    private String haltMinutes;

    @Column(name = "Distance")
    private float distance;

    @Column(name = "HasWifi")
    private boolean hasWifi;

    @Column(name = "Days")
    private int days;

    @Column(name = "DataChanged")
    private boolean dataChanged;

    @Column(name = "ExpectedPlatformNo")
    private String expectedPlatformNo;

    @Column(name = "ArrivalDelay")
    private String arrivalDelay;

    @Column(name = "DepartureDelay")
    private String departureDelay;

    @Column(name = "StopNumberDisplay")
    private float stopNumberDisplay;

    @Column(name = "Sun")
    private boolean sun;

    @Column(name = "Mon")
    private boolean mon;

    @Column(name = "Tue")
    private boolean tue;

    @Column(name = "Wed")
    private boolean wed;

    @Column(name = "Thu")
    private boolean thu;

    @Column(name = "Fri")
    private boolean fri;

    @Column(name = "Sat")
    private boolean sat;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isIntermediateStations() {
        return intermediateStations;
    }

    public void setIntermediateStations(boolean intermediateStations) {
        this.intermediateStations = intermediateStations;
    }

    public int getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(int routeNo) {
        this.routeNo = routeNo;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public String getTrainMappingKey() {
        return trainMappingKey;
    }

    public void setTrainMappingKey(String trainMappingKey) {
        this.trainMappingKey = trainMappingKey;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getHaltMinutes() {
        return haltMinutes;
    }

    public void setHaltMinutes(String haltMinutes) {
        this.haltMinutes = haltMinutes;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isDataChanged() {
        return dataChanged;
    }

    public void setDataChanged(boolean dataChanged) {
        this.dataChanged = dataChanged;
    }

    public String getExpectedPlatformNo() {
        return expectedPlatformNo;
    }

    public void setExpectedPlatformNo(String expectedPlatformNo) {
        this.expectedPlatformNo = expectedPlatformNo;
    }

    public String getArrivalDelay() {
        return arrivalDelay;
    }

    public void setArrivalDelay(String arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public String getDepartureDelay() {
        return departureDelay;
    }

    public void setDepartureDelay(String departureDelay) {
        this.departureDelay = departureDelay;
    }

    public float getStopNumberDisplay() {
        return stopNumberDisplay;
    }

    public void setStopNumberDisplay(float stopNumberDisplay) {
        this.stopNumberDisplay = stopNumberDisplay;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }
    public TrainRoute() {
    }

    public TrainRoute(int id, boolean intermediateStations, int routeNo, int stopNumber, String trainMappingKey, String arrivalTime, String departureTime, String haltMinutes, float distance, boolean hasWifi, int days, boolean dataChanged, String expectedPlatformNo, String arrivalDelay) {
        this.id = id;
        this.intermediateStations = intermediateStations;
        this.routeNo = routeNo;
        this.stopNumber = stopNumber;
        this.trainMappingKey = trainMappingKey;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.haltMinutes = haltMinutes;
        this.distance = distance;
        this.hasWifi = hasWifi;
        this.days = days;
        this.dataChanged = dataChanged;
        this.expectedPlatformNo = expectedPlatformNo;
        this.arrivalDelay = arrivalDelay;
    }

    @Override
    public String toString() {
        return "TrainRoute{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", trainId=" + trainId +
                ", intermediateStations=" + intermediateStations +
                ", routeNo=" + routeNo +
                ", stopNumber=" + stopNumber +
                ", trainMappingKey='" + trainMappingKey + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", haltMinutes='" + haltMinutes + '\'' +
                ", distance=" + distance +
                ", hasWifi=" + hasWifi +
                ", days=" + days +
                ", dataChanged=" + dataChanged +
                ", expectedPlatformNo='" + expectedPlatformNo + '\'' +
                ", arrivalDelay='" + arrivalDelay + '\'' +
                '}';
    }
}
