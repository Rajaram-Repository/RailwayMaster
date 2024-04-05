package com.example.StationDetails.model;
import com.example.StationDetails.model.StationDetails;
public class JunctionCount {
    StationDetails stationDetails;
    int from ;
    int to;

    public JunctionCount(StationDetails s,int from ,int to){
        this.stationDetails=s;
        this.from=from;
        this.to=to;
    }
    public StationDetails getStationDetails(){
        return stationDetails;
    }
    public int getfrom(){
        return from;
    }
    public int getto(){
        return to;
    }
    @Override
    public String toString() {
        return "Station "+stationDetails.toString()+ " statcode : "+stationDetails.getStationCode() + ":" + from + ":" + to;
    }   
}
