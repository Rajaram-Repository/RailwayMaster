package com.example.StationDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StationDetails.model.TrainDetails;

public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Integer> {
        List<TrainDetails> findById(int id);

        List<TrainDetails> findByTrainNo(int num);

        @Query(value = "SELECT * " +
                        "FROM railway.trainroute " +
                        "WHERE TrainNo =:num ", nativeQuery = true)
        List<Object[]> findTrainRoute(@Param("num") int num);

        @Query(value = "SELECT * " +
                        "FROM railway.trainroute " +
                        "WHERE TrainNo =:num  and IntermediateStations=:flag", nativeQuery = true)
        List<Object[]> findTrainRouteIntermediateStations(@Param("num") int num, @Param("flag") boolean flag);

}
