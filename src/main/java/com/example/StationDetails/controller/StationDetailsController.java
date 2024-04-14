package com.example.StationDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StationDetails.model.JunctionCount;
import com.example.StationDetails.model.StationDetails;
import com.example.StationDetails.service.StationDetailsService;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/stations")
public class StationDetailsController {
    @Autowired
    StationDetailsService stationDetailsService;

    @GetMapping("/all")
    public ResponseEntity<List<StationDetails>> getAllStations() {
        List<StationDetails> stations = stationDetailsService.getAllStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<StationDetails>> getStationById(@PathVariable int id) {
        List<StationDetails> station = stationDetailsService.getStationById(id);
        System.out.println(station.size());
        return new ResponseEntity<>(station, HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<List<StationDetails>> getStationByCode(@PathVariable String code) {
        List<StationDetails> station = stationDetailsService.getStaionByCode(code);
        System.out.println(station.size());
        return new ResponseEntity<>(station, HttpStatus.OK);
    }

    @SuppressWarnings("null")
    @GetMapping("/conditions")
    public ResponseEntity<List<StationDetails>> getStation(
            @RequestParam(required = false) Boolean isIntermediate,
            @RequestParam(required = false) Boolean isJunction,
            @RequestParam(required = false) Boolean isCentral) {
        List<StationDetails> stations = stationDetailsService.getStationCondition(isIntermediate, isJunction,
                isCentral);
        System.out.println(stations.size());
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    @GetMapping("/intermittent")
    public ResponseEntity<List<StationDetails>> getStations(@RequestParam("from") String from,
            @RequestParam("to") String to) {
        System.out.println(from + "  " + to);
        List<StationDetails> list = stationDetailsService.intermittentStations(from, to);
        System.out.println(list.size());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/intermittentJunction")
    public ResponseEntity<List<JunctionCount>> intermittentJunction(@RequestParam("from") String from,
            @RequestParam("to") String to, @RequestParam("around") Boolean flag) {
        long startTime = System.nanoTime();
        List<JunctionCount> list = stationDetailsService.intermittentJunction(from, to, flag);
        long endTime = System.nanoTime();
        long elapsedTimeMicro = (endTime - startTime) / 1000;
        System.out.println("Method execution time: " + elapsedTimeMicro + " microseconds");

        System.out.println(list.size());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/add")
    public Object add(@RequestParam("from") String from, @RequestParam("to") String to) {
        return stationDetailsService.add(from, to);
    }
}