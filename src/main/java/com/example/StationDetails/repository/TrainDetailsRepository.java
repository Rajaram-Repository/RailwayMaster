package com.example.StationDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StationDetails.model.TrainDetails;

public interface TrainDetailsRepository  extends JpaRepository <TrainDetails,Integer> {
    
}
