package com.example.StationDetails.model;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "stationdetails")
public class StationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TrainRoute> s_train;

    @Column(name = "StationName")
    private String stationName;

    @Column(name = "StationCode")
    private String stationCode;

    @Column(name = "Latitude")
    private Double latitude;

    @Column(name = "Longitude")
    private Double longitude;

    @Column(name = "isIntermediateStations")
    private boolean isIntermediateStations;

    @Column(name = "isJunction")
    private boolean isJunction;

    @Column(name = "isCentral")
    private boolean isCentral;

    @Column(name = "isMajorStop")
    private boolean isMajorStop;

    @Override
    public String toString(){
        return String.format(id+" - "+stationCode+" - "+ stationName+" - "+latitude+" - "+longitude+" - "+isCentral+" - "+isIntermediateStations+" - "+isJunction+" - "+isMajorStop);
    }
    public StationDetails() {
    }

    public StationDetails(String stationName, String stationCode, Double latitude, Double longitude, boolean isIntermediateStations, boolean isJunction, boolean isCentral, boolean isMajorStop) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isIntermediateStations = isIntermediateStations;
        this.isJunction = isJunction;
        this.isCentral = isCentral;
        this.isMajorStop = isMajorStop;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isIntermediateStations() {
        return isIntermediateStations;
    }

    public void setIntermediateStations(boolean intermediateStations) {
        isIntermediateStations = intermediateStations;
    }

    public boolean isJunction() {
        return isJunction;
    }

    public void setJunction(boolean junction) {
        isJunction = junction;
    }

    public boolean isCentral() {
        return isCentral;
    }

    public void setCentral(boolean central) {
        isCentral = central;
    }

    public boolean isMajorStop() {
        return isMajorStop;
    }

    public void setMajorStop(boolean majorStop) {
        isMajorStop = majorStop;
    }
}

