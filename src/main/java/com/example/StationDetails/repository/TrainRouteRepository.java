package com.example.StationDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StationDetails.model.TrainRoute;


public interface TrainRouteRepository extends JpaRepository <TrainRoute,Integer> {
    
}
