package com.example.StationDetails.model;

public class TrainFromAndTo {
    TrainDetails trainDetails;

    String fromStation;
    String fromArrivalTime;
    String fromDepartureTime;
    int fromStop;
    float fromDistance;

    String toStation;
    String toArrivalTime;
    String toDepartureTime;
    int toStop;
    float toDistance;

     // Constructor
    public TrainFromAndTo(){

    }
    public TrainFromAndTo(TrainDetails trainDetails, String fromStation, String fromArrivalTime, String fromDepartureTime, int fromStop, float fromDistance, String toStation, String toArrivalTime, String toDepartureTime, int toStop, float toDistance) {
        this.trainDetails = trainDetails;
        this.fromStation = fromStation;
        this.fromArrivalTime = fromArrivalTime;
        this.fromDepartureTime = fromDepartureTime;
        this.fromStop = fromStop;
        this.fromDistance = fromDistance;
        this.toStation = toStation;
        this.toArrivalTime = toArrivalTime;
        this.toDepartureTime = toDepartureTime;
        this.toStop = toStop;
        this.toDistance = toDistance;
    }


    // Getter and setter methods for trainDetails
    public TrainDetails getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(TrainDetails trainDetails) {
        this.trainDetails = trainDetails;
    }

    // Getter and setter methods for fromStation
    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    // Getter and setter methods for fromArrivalTime
    public String getFromArrivalTime() {
        return fromArrivalTime;
    }

    public void setFromArrivalTime(String fromArrivalTime) {
        this.fromArrivalTime = fromArrivalTime;
    }

    // Getter and setter methods for fromDepartureTime
    public String getFromDepartureTime() {
        return fromDepartureTime;
    }

    public void setFromDepartureTime(String fromDepartureTime) {
        this.fromDepartureTime = fromDepartureTime;
    }

    // Getter and setter methods for fromStop
    public int getFromStop() {
        return fromStop;
    }

    public void setFromStop(int fromStop) {
        this.fromStop = fromStop;
    }

    // Getter and setter methods for fromDistance
    public float getFromDistance() {
        return fromDistance;
    }

    public void setFromDistance(float fromDistance) {
        this.fromDistance = fromDistance;
    }

    // Getter and setter methods for toStation
    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    // Getter and setter methods for toArrivalTime
    public String getToArrivalTime() {
        return toArrivalTime;
    }

    public void setToArrivalTime(String toArrivalTime) {
        this.toArrivalTime = toArrivalTime;
    }

    // Getter and setter methods for toDepartureTime
    public String getToDepartureTime() {
        return toDepartureTime;
    }

    public void setToDepartureTime(String toDepartureTime) {
        this.toDepartureTime = toDepartureTime;
    }

    // Getter and setter methods for toStop
    public int getToStop() {
        return toStop;
    }

    public void setToStop(int toStop) {
        this.toStop = toStop;
    }

    // Getter and setter methods for toDistance
    public float getToDistance() {
        return toDistance;
    }

    public void setToDistance(float toDistance) {
        this.toDistance = toDistance;
    }

    // toString method
    @Override
    public String toString() {
        return "TrainDetails{" +
                "trainDetails=" + trainDetails +
                ", fromStation='" + fromStation + '\'' +
                ", fromArrivalTime='" + fromArrivalTime + '\'' +
                ", fromDepartureTime='" + fromDepartureTime + '\'' +
                ", fromStop='" + fromStop + '\'' +
                ", fromDistance='" + fromDistance + '\'' +
                ", toStation='" + toStation + '\'' +
                ", toArrivalTime='" + toArrivalTime + '\'' +
                ", toDepartureTime='" + toDepartureTime + '\'' +
                ", toStop='" + toStop + '\'' +
                ", toDistance='" + toDistance + '\'' +
                '}';
    }
}
