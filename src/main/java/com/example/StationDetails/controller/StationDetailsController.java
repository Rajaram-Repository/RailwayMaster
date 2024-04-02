package com.example.StationDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StationDetails.model.StationDetails;
import com.example.StationDetails.service.StationDetailsService;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/stations")
public class StationDetailsController {
    @Autowired
    StationDetailsService stationDetailsService;

    @GetMapping
    public ResponseEntity<List<StationDetails>> getAllStations(){
        List<StationDetails> stations = stationDetailsService.getAllStations();
        return new ResponseEntity<>(stations,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<StationDetails>> getStationById(@PathVariable int id) {
        List<StationDetails> station = stationDetailsService.getStationById(id);
        System.out.println(station.size());
        return new ResponseEntity<>(station,HttpStatus.OK);
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<List<StationDetails>> getStationByCode(@PathVariable String code){
        List<StationDetails> station = stationDetailsService.getStaionByCode(code);
        System.out.println(station.size());
        return new ResponseEntity<>(station,HttpStatus.OK);
    }

    @SuppressWarnings("null")
    @GetMapping("/conditions")
    public ResponseEntity<List<StationDetails>> getStation(
        @RequestParam(required = false) Boolean isIntermediate, 
        @RequestParam(required = false) Boolean isJunction, 
        @RequestParam(required = false) Boolean isCentral) {
        List<StationDetails> stations = stationDetailsService.getStationCondition(isIntermediate, isJunction, isCentral);
        System.out.println(stations.size());
        return new ResponseEntity<>(stations,HttpStatus.OK);
    }
    @GetMapping("/trains")
    public ResponseEntity<List<Integer>> getTrains(@RequestParam("from") int from,@RequestParam("to") int to) {
        List<Integer> list = stationDetailsService.findTrainIDs(from,to);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}