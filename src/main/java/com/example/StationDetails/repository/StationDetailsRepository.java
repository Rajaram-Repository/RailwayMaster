package com.example.StationDetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    // @Query("SELECT t.trainId FROM trainroute t WHERE t.stationId = ?1 OR t.stationId = ?2")
    // List<Integer> findTrainIdsByStationsAndDayOfWeek(int stationId1, int stationId2);

    // @Query("SELECT tr.trainId.id " +
    // "FROM TrainRoute tr " +
    // // "INNER JOIN tr.trainId t " + // Assuming 'trainId' is the attribute name for TrainDetails in TrainRoute
    // "WHERE tr.stationId.id IN (:stationId1, :stationId2) " // Assuming 'id' is the primary key attribute in StationDetails
    // // "AND t.wednesday = true " + // Assuming 'wednesday' is a boolean attribute in TrainDetails
    // // "GROUP BY tr.trainId.id " +
    // // "HAVING COUNT(DISTINCT tr.stationId) = 2 " +
    // // "AND MAX(CASE WHEN tr.stationId.id = :stationId1 THEN tr.stopNumber END) < " +
    // // "    MAX(CASE WHEN tr.stationId.id = :stationId2 THEN tr.stopNumber END)")
    // )
    // List<Integer> findTrainIdsByStationsAndDayOfWeek(int stationId1, int stationId2);
}
