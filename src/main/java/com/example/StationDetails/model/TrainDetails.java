package com.example.StationDetails.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "traindetails")
public class TrainDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TrainRoute> t_train;

    @Column(name = "TrainName")
    private String trainName;

    @Column(name = "TrainNo")
    private int trainNo;

    @Column(name = "TrainNumberString")
    private String trainNumberString;

    @Column(name = "CoachPosition")
    private String coachPosition;

    @Column(name = "Classes")
    private String classes;

    @Column(name = "SourceStation")
    private String sourceStation;

    @Column(name = "Destination")
    private String destination;

    @Column(name = "SourceCode")
    private String sourceCode;

    @Column(name = "DestinationCode")
    private String destinationCode;

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

    @Column(name = "TrainType")
    private String trainType;

    @Column(name = "IsUnreserved")
    private boolean isUnreserved;

    @Column(name = "Rating")
    private float rating;

    @Column(name = "FoodRating")
    private float foodRating;

    @Column(name = "PunctualityRating")
    private float punctualityRating;

    @Column(name = "CleanlinessRating")
    private float cleanlinessRating;

    @Column(name = "RatingCount")
    private int ratingCount;

    @Column(name = "TotalDuration")
    private String totalDuration;

    @Column(name = "FromCity")
    private String fromCity;

    @Column(name = "ToCity")
    private String toCity;

    @Column(name = "Pantry")
    private boolean pantry;

    @Column(name = "ErrorMsg")
    private String errorMsg;

    // Constructors, getters, and setters
    // Constructor
    public TrainDetails() {
        // Default constructor
    }
    public TrainDetails(int id, Set<TrainRoute> t_train, String trainName, int trainNo, String trainNumberString,
                 String coachPosition, String classes, String sourceStation, String destination, String sourceCode,
                 String destinationCode, boolean sun, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri,
                 boolean sat, String trainType, boolean isUnreserved, float rating, float foodRating,
                 float punctualityRating, float cleanlinessRating, int ratingCount, String totalDuration, String fromCity,
                 String toCity, boolean pantry, String errorMsg) {
        this.id = id;
        this.t_train = t_train;
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.trainNumberString = trainNumberString;
        this.coachPosition = coachPosition;
        this.classes = classes;
        this.sourceStation = sourceStation;
        this.destination = destination;
        this.sourceCode = sourceCode;
        this.destinationCode = destinationCode;
        this.sun = sun;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.trainType = trainType;
        this.isUnreserved = isUnreserved;
        this.rating = rating;
        this.foodRating = foodRating;
        this.punctualityRating = punctualityRating;
        this.cleanlinessRating = cleanlinessRating;
        this.ratingCount = ratingCount;
        this.totalDuration = totalDuration;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.pantry = pantry;
        this.errorMsg = errorMsg;
    }
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<TrainRoute> getT_train() {
        return t_train;
    }

    public void setT_train(Set<TrainRoute> t_train) {
        this.t_train = t_train;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainNumberString() {
        return trainNumberString;
    }

    public void setTrainNumberString(String trainNumberString) {
        this.trainNumberString = trainNumberString;
    }

    public String getCoachPosition() {
        return coachPosition;
    }

    public void setCoachPosition(String coachPosition) {
        this.coachPosition = coachPosition;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
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

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public boolean isUnreserved() {
        return isUnreserved;
    }

    public void setUnreserved(boolean unreserved) {
        isUnreserved = unreserved;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public float getPunctualityRating() {
        return punctualityRating;
    }

    public void setPunctualityRating(float punctualityRating) {
        this.punctualityRating = punctualityRating;
    }

    public float getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(float cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public boolean isPantry() {
        return pantry;
    }

    public void setPantry(boolean pantry) {
        this.pantry = pantry;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainName='" + trainName + '\'' +
                ", trainNo=" + trainNo +
                ", trainNumberString='" + trainNumberString + '\'' +
                ", coachPosition='" + coachPosition + '\'' +
                ", classes='" + classes + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destination='" + destination + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", destinationCode='" + destinationCode + '\'' +
                ", sun=" + sun +
                ", mon=" + mon +
                ", tue=" + tue +
                ", wed=" + wed +
                ", thu=" + thu +
                ", fri=" + fri +
                ", sat=" + sat +
                ", trainType='" + trainType + '\'' +
                ", isUnreserved=" + isUnreserved +
                ", rating=" + rating +
                ", foodRating=" + foodRating +
                ", punctualityRating=" + punctualityRating +
                ", cleanlinessRating=" + cleanlinessRating +
                ", ratingCount=" + ratingCount +
                ", totalDuration='" + totalDuration + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", pantry=" + pantry +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
