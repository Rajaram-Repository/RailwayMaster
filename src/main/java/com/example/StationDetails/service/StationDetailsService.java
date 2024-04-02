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
    // public StationDetails createStationDetails(StationDetails station){
    //     return stationDetailsRepository.save(station);
    // }
    // public void deleteStationById(int id){
    //     stationDetailsRepository.deleteById(id);
    // }

}
