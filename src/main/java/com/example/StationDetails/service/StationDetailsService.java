package com.example.StationDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StationDetails.repository.StationDetailsRepository;
import com.example.StationDetails.repository.TrainRouteRepository;
import com.example.StationDetails.model.JunctionCount;
import com.example.StationDetails.model.StationDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class StationDetailsService {
    @Autowired 
    private StationDetailsRepository stationDetailsRepository;
    private TrainRouteRepository trainRouteRepository;


    
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
        List<Integer> list = new ArrayList<>();
        list.add(2);
        return list;
    }
    public List<JunctionCount> intermittentJunction (String from,String to,Boolean flag){
        List<StationDetails> stations = intermittentStations(from,to);
        Map<Integer, List<JunctionCount>> treeMap = new TreeMap<>(Collections.reverseOrder());
        List<Object []> fromObj =null;
        List<Object []> toObj =null;
        if(flag){
            fromObj=trainRouteRepository.findTrainDetailsList(aroundStation(from));
            toObj=trainRouteRepository.findTrainDetailsList(aroundStation(to));
        }
        else{
            fromObj =trainRouteRepository.findTrainDetails(from);
            toObj =trainRouteRepository.findTrainDetails(to);
        }
        Map<Integer,Integer> fromMap = objToMap(fromObj);
        Map<Integer,Integer> toMap = objToMap(toObj);
        System.out.println("station  - "+stations.size());
        for(StationDetails sd : stations){
            String station = sd.getStationCode();
            Integer fromCount=0;
            Integer toCount =0;
            List<Object []> midObj =trainRouteRepository.findTrainDetails(station);
            Map<Integer,Integer> midMap =objToMap(midObj);
            for(Entry<Integer, Integer> map : midMap.entrySet()){
                if(fromMap.containsKey(map.getKey()) && fromMap.get(map.getKey())<map.getValue() )
                        fromCount++;
                if(toMap.containsKey(map.getKey()) && map.getValue()>toMap.get(map.getKey()) )
                        toCount++;
            }
            if(fromCount<=0 || toCount <=0)
                continue;
            int min = Math.min(fromCount,toCount);
            JunctionCount j = new JunctionCount(sd,fromCount,toCount);
            if(!treeMap.containsKey((min)))
                treeMap.put(min, new ArrayList<>());
            treeMap.get(min).add(j);
        }
        List<JunctionCount> jun = new ArrayList<>();
        for( List<JunctionCount> map : treeMap.values())
            jun.addAll( map);
        return jun;
    }
    public Map<Integer,Integer> objToMap(List<Object []> object){
        Map<Integer,Integer> map = new HashMap<>();
        for(Object [] obj : object)
            map.put((Integer) obj[0],(Integer) obj[2]);
        return map;
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
            double diffLat = diff(minDistance/2);
            fromLatitude+=diffLat;
            toLatitude-=diffLat;
        }
        distanceInKms = distance(fromLatitude, toLatitude, fromLongitude, toLongitude, 0.0, 0.0);
        latdistanceInKms = distance(fromLatitude, toLatitude, 0.0, 0.0, 0.0, 0.0);
        londistanceInKms = distance(0.0, 0.0, fromLongitude, toLongitude, 0.0, 0.0);
        minDistance =distanceInKms/2.5;
        System.out.println("Distance : "+distanceInKms +" lat Dis : "+latdistanceInKms+" lon Dis : "+londistanceInKms +"  min dis : "+minDistance);
        System.out.println(" from - "+fromLatitude+"  -  "+fromLongitude);
        System.out.println(" to - "+toLatitude+"  -  "+toLongitude);

        Double minLatitude = Math.min(fromLatitude,toLatitude);
        Double maxLatitude = Math.max(fromLatitude,toLatitude);
        Double minLongitude = Math.min(fromLongitude,toLongitude);
        Double maxLongitude = Math.max(fromLongitude,toLongitude);
        return stationDetailsRepository.findByLatitudeBetweenAndLongitudeBetweenAndIsMajorStop(minLatitude-0.2, maxLatitude+0.2, minLongitude-.2, maxLongitude+0.2,true);
    }
    public List<String> aroundStation(String code){
        List<StationDetails> fromStation = stationDetailsRepository.findByStationCode(code);
        Double fromLatitude=fromStation.get(0).getLatitude();
        Double fromLongitude=fromStation.get(0).getLongitude();
        List<String> stationsAround = new ArrayList<>();
        List<StationDetails> stationDetails = stationDetailsRepository.findByLatitudeBetweenAndLongitudeBetweenAndIsIntermediateStations(fromLatitude - 0.4, fromLatitude + 0.4, fromLongitude - 0.4, fromLongitude + 0.4, false);
        for(StationDetails s : stationDetails)
            stationsAround.add(s.getStationCode());
        return stationsAround;
    }
    public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {
        final int R = 6371; 

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

    public Object add(String from, String to) {
        return stationDetailsRepository.callJnBetween(from, to) ;
    }

}
