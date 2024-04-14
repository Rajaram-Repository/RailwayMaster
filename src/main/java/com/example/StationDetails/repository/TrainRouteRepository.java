package com.example.StationDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StationDetails.model.TrainRoute;


public interface TrainRouteRepository extends JpaRepository <TrainRoute,Integer> {
        @Query(value =  "SELECT COUNT(*) " +
            "FROM ( " +
            "    SELECT DISTINCT TrainNo " +
            "    FROM railway.trainroute " +
            "    WHERE StationCode IN (:fromStation, :toStation)  " +
            "    GROUP BY TrainNo " +
            "    HAVING COUNT(StationCode) > 1 " +
            "       AND MAX(CASE WHEN StationCode = :fromStation THEN StopNumber END) < " +
            "           MAX(CASE WHEN StationCode = :toStation THEN StopNumber END)" +
            ") AS subquery", nativeQuery = true)
        int countTrainNo(@Param("fromStation") String fromStation, @Param("toStation") String toStation);

        @Query(value =  "SELECT COUNT(*) " +
            "FROM ( " +
            "    SELECT DISTINCT TrainNo " +
            "    FROM railway.trainroute " +
            "    WHERE StationCode IN (:fromStation) AND StationCode=:toStation  " +
            "    GROUP BY TrainNo " +
            "    HAVING COUNT(StationCode) > 1 " +
            "       AND MAX(CASE WHEN StationCode IN (:fromStation) THEN StopNumber END) < " +
            "           MAX(CASE WHEN StationCode = :toStation THEN StopNumber END)" +
            ") AS subquery", nativeQuery = true)
        int countTrainNoFromAll(@Param("fromStation") List<String> fromStation, @Param("toStation") String toStation);
        @Query(value =  "SELECT COUNT(*) " +
            "FROM ( " +
            "    SELECT DISTINCT TrainNo " +
            "    FROM railway.trainroute " +
            "    WHERE StationCode =:fromStation AND StationCode IN (:toStation)  " +
            "    GROUP BY TrainNo " +
            "    HAVING COUNT(DISTINCT StationCode) > 1 " +
            "       AND MAX(CASE WHEN StationCode = :fromStation THEN StopNumber END) < " +
            "           MAX(CASE WHEN StationCode IN (:toStation) THEN StopNumber END)" +
            ") AS subquery", nativeQuery = true)
        int countTrainNoToAll(@Param("fromStation") String fromStation, @Param("toStation") List<String> toStation);

        @Query(value = "SELECT TrainNo, StationCode, StopNumber " +
            "FROM railway.trainroute " +
            "WHERE StationCode =:Station AND StopNumber IS NOT NULL", nativeQuery = true)
        List<Object[]> findTrainDetails(@Param("Station") String Station);
        @Query(value = "SELECT TrainNo, StationCode, StopNumber " +
            "FROM railway.trainroute " +
            "WHERE StationCode IN (:Station) AND StopNumber IS NOT NULL", nativeQuery = true)
        List<Object[]> findTrainDetailsList(@Param("Station") List<String> Station);    
        @Query(value = "SELECT * " +
            "FROM railway.trainroute " +
            "WHERE StationCode =:Station AND StopNumber IS NOT NULL", nativeQuery = true)
        List<Object[]> findTrainStopDetail(@Param("Station") String Station); 
}
