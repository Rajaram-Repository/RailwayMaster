package com.example.StationDetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.StationDetails.model.StationDetails;
import com.example.StationDetails.model.TrainRoute;
import com.example.StationDetails.model.TrainDetails;
import java.util.List;


@Repository
public interface StationDetailsRepository extends JpaRepository <StationDetails,Integer> {
    List<StationDetails> findById(int id);
    List<StationDetails> findByStationCode(String code);
    List<StationDetails> findByIsIntermediateStations(boolean isIntermediate);
    List<StationDetails> findByIsJunction(boolean isJunction);
    List<StationDetails> findByIsCentral(boolean isCentral);
    List<StationDetails> findByIsIntermediateStationsAndIsJunction(boolean isIntermediate,boolean isJunction);
    List<StationDetails> findByIsJunctionAndIsCentral(boolean isJunction,boolean isCentral);
    List<StationDetails> findByIsIntermediateStationsAndIsCentral(boolean isIntermediate,boolean isCentral);
    List<StationDetails> findByIsIntermediateStationsAndIsJunctionAndIsCentral(boolean intermediate,boolean junction,boolean central);
    List<StationDetails> findByIsMajorStop(boolean b);
    List<StationDetails> findByLatitudeBetweenAndLongitudeBetweenAndIsMajorStop(Double minLat, Double maxLat, Double minLon, Double maxLon,Boolean t);
    List<StationDetails> findByLatitudeBetweenAndLongitudeBetweenAndIsIntermediateStations(Double minLat, Double maxLat, Double minLon, Double maxLon,Boolean t);
    List<String> findStationCodeByLatitudeBetweenAndLongitudeBetweenAndIsIntermediateStations(Double minLat, Double maxLat, Double minLon, Double maxLon,Boolean t);
    @Query(value = "SELECT JnBetween(?1, ?2)", nativeQuery = true)
    Object callJnBetween(String fromStation, String toStation);
    
}
