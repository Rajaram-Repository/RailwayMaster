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
}
