package com.example.StationDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StationDetails.repository.StationDetailsRepository;
import com.example.StationDetails.model.StationDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationDetailsService {
    @Autowired 
    private StationDetailsRepository stationDetailsRepository;
    public List<StationDetails> getAllStations(){
        return stationDetailsRepository.findAll();
    }

    public List<StationDetails> getStationById(int id){
        return stationDetailsRepository.findById(id);
    }
    public List<StationDetails> getStaionByCode(String code){
        return stationDetailsRepository.findByStationCode(code);
    }
    @SuppressWarnings("null")
    public List<StationDetails> getStationCondition(
         Boolean isIntermediate, 
         Boolean isJunction, 
         Boolean isCentral){
            
        if (isIntermediate != null && isJunction != null && isCentral != null) 
            return stationDetailsRepository.findByIsIntermediateStationsAndIsJunctionAndIsCentral(isIntermediate, isJunction, isCentral);
        else if (isIntermediate != null && isJunction != null) 
            return stationDetailsRepository.findByIsIntermediateStationsAndIsJunction(isIntermediate, isJunction);
        else if (isIntermediate != null && isCentral != null) 
            return stationDetailsRepository.findByIsIntermediateStationsAndIsCentral(isIntermediate, isCentral);
        else if (isJunction != null && isCentral != null) 
            return stationDetailsRepository.findByIsJunctionAndIsCentral(isJunction, isCentral);
        else if (isIntermediate != null) 
            return stationDetailsRepository.findByIsIntermediateStations(isIntermediate);
        else if (isJunction != null) 
            return stationDetailsRepository.findByIsJunction(isJunction);
        else if (isCentral != null) 
            return stationDetailsRepository.findByIsCentral(isCentral);
        
        return stationDetailsRepository.findByIsMajorStop(true);
    }
    public List<Integer> findTrainIDs(int stationId1,int stationId2){
        // List <Integer> list = stationDetailsRepository.findTrainIdsByStationsAndDayOfWeek(stationId1, stationId2);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        return list;
    }
    public List<StationDetails> intermittentStations(String from,String to){
        List<StationDetails> fromStation = stationDetailsRepository.findByStationCode(from);
        List<StationDetails> toStation = stationDetailsRepository.findByStationCode(to);
        System.out.println(fromStation);
        System.out.println(toStation);
        Double fromLatitude=fromStation.get(0).getLatitude();
        Double fromLongitude=fromStation.get(0).getLongitude();
        Double toLatitude=toStation.get(0).getLatitude();
        Double toLongitude=toStation.get(0).getLongitude();
        double distanceInKms = distance(fromLatitude, toLatitude, fromLongitude, toLongitude, 0.0, 0.0);
        double latdistanceInKms = distance(fromLatitude, toLatitude, 0.0, 0.0, 0.0, 0.0);
        double londistanceInKms = distance(0.0, 0.0, fromLongitude, toLongitude, 0.0, 0.0);
        double minDistance =distanceInKms/2.5;

        System.out.println("Distance : "+distanceInKms +" lat Dis : "+latdistanceInKms+" lon Dis : "+londistanceInKms +"  min dis : "+minDistance);
        if(londistanceInKms<minDistance){
            double diffLon = diff(minDistance/2);
            fromLongitude+=diffLon;
            toLongitude-=diffLon;
        }
        if(latdistanceInKms<minDistance){
            double diffLon = diff(minDistance/2);
            fromLatitude+=diffLon;
            toLatitude-=diffLon;
        }
        distanceInKms = distance(fromLatitude, toLatitude, fromLongitude, toLongitude, 0.0, 0.0);
        latdistanceInKms = distance(fromLatitude, toLatitude, 0.0, 0.0, 0.0, 0.0);
        londistanceInKms = distance(0.0, 0.0, fromLongitude, toLongitude, 0.0, 0.0);
        minDistance =distanceInKms/2.5;
        System.out.println("Distance : "+distanceInKms +" lat Dis : "+latdistanceInKms+" lon Dis : "+londistanceInKms +"  min dis : "+minDistance);
        System.out.println(" from - "+fromLatitude+"  -  "+fromLongitude);
        System.out.println(" to - "+toLatitude+"  -  "+toLongitude);
        Double latitudeDiff =Math.abs(fromLatitude-toLatitude);
        Double latitudeDIff =Math.abs(fromLongitude-toLongitude);
        Double minLatitude = Math.min(fromLatitude,toLatitude);
        Double maxLatitude = Math.max(fromLatitude,toLatitude);
        Double minLongitude = Math.min(fromLongitude,toLongitude);
        Double maxLongitude = Math.max(fromLongitude,toLongitude);
        return stationDetailsRepository.findByLatitudeBetweenAndLongitudeBetweenAndIsMajorStop(minLatitude-0.2, maxLatitude+0.2, minLongitude-.2, maxLongitude+0.2,true);
    }
    public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {
        final int R = 6371; // Radius of the Earth in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; 
        double height = el1 - el2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        return Math.sqrt(distance)/1000;
    }
    public static double diff(Double kms){
        double earthRadius = 6371.0;
        double distanceInRadians = kms / earthRadius;
        return Math.toDegrees(distanceInRadians);
    }

}
