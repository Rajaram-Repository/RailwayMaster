package com.example.StationDetails.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "traindetails")
public class TrainDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TrainRoute> t_train;

    @Column(name = "TrainName")
    private String trainName;

    @Column(name = "TrainNo")
    private Integer trainNo;

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
    private Boolean sun;

    @Column(name = "Mon")
    private Boolean mon;

    @Column(name = "Tue")
    private Boolean tue;

    @Column(name = "Wed")
    private Boolean wed;

    @Column(name = "Thu")
    private Boolean thu;

    @Column(name = "Fri")
    private Boolean fri;

    @Column(name = "Sat")
    private Boolean sat;

    @Column(name = "TraIntegerype")
    private String traIntegerype;

    @Column(name = "IsUnreserved")
    private Boolean isUnreserved;

    @Column(name = "Rating")
    private Float rating;

    @Column(name = "FoodRating")
    private Float foodRating;

    @Column(name = "PunctualityRating")
    private Float punctualityRating;

    @Column(name = "CleanlinessRating")
    private Float cleanlinessRating;

    @Column(name = "RatingCount")
    private Integer ratingCount;

    @Column(name = "TotalDuration")
    private String totalDuration;

    @Column(name = "FromCity")
    private String fromCity;

    @Column(name = "ToCity")
    private String toCity;

    @Column(name = "Pantry")
    private Boolean pantry;

    @Column(name = "ErrorMsg")
    private String errorMsg;

    // Constructors, getters, and setters
    // Constructor
    public TrainDetails() {
        // Default constructor
    }

    public TrainDetails(Integer id, Set<TrainRoute> t_train, String trainName, Integer trainNo,
            String trainNumberString,
            String coachPosition, String classes, String sourceStation, String destination, String sourceCode,
            String destinationCode, Boolean sun, Boolean mon, Boolean tue, Boolean wed, Boolean thu, Boolean fri,
            Boolean sat, String traIntegerype, Boolean isUnreserved, Float rating, Float foodRating,
            Float punctualityRating, Float cleanlinessRating, Integer ratingCount, String totalDuration,
            String fromCity,
            String toCity, Boolean pantry, String errorMsg) {
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
        this.traIntegerype = traIntegerype;
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
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

    public Boolean isSun() {
        return sun;
    }

    public void setSun(Boolean sun) {
        this.sun = sun;
    }

    public Boolean isMon() {
        return mon;
    }

    public void setMon(Boolean mon) {
        this.mon = mon;
    }

    public Boolean isTue() {
        return tue;
    }

    public void setTue(Boolean tue) {
        this.tue = tue;
    }

    public Boolean isWed() {
        return wed;
    }

    public void setWed(Boolean wed) {
        this.wed = wed;
    }

    public Boolean isThu() {
        return thu;
    }

    public void setThu(Boolean thu) {
        this.thu = thu;
    }

    public Boolean isFri() {
        return fri;
    }

    public void setFri(Boolean fri) {
        this.fri = fri;
    }

    public Boolean isSat() {
        return sat;
    }

    public void setSat(Boolean sat) {
        this.sat = sat;
    }

    public String getTraIntegerype() {
        return traIntegerype;
    }

    public void setTraIntegerype(String traIntegerype) {
        this.traIntegerype = traIntegerype;
    }

    public Boolean isUnreserved() {
        return isUnreserved;
    }

    public void setUnreserved(Boolean unreserved) {
        isUnreserved = unreserved;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Float foodRating) {
        this.foodRating = foodRating;
    }

    public Float getPunctualityRating() {
        return punctualityRating;
    }

    public void setPunctualityRating(Float punctualityRating) {
        this.punctualityRating = punctualityRating;
    }

    public Float getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(Float cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
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

    public Boolean isPantry() {
        return pantry;
    }

    public void setPantry(Boolean pantry) {
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
                ", traIntegerype='" + traIntegerype + '\'' +
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
