package com.example.StationDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StationDetails.model.TrainDetails;
import com.example.StationDetails.model.TrainFromAndTo;
import com.example.StationDetails.service.TrainDetailsService;

@RestController
@RequestMapping("/trains")
public class TrainDetailsController {

    @Autowired
    TrainDetailsService trainDetailsService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<TrainDetails>> getTrainsById(@PathVariable int id) {
        List<TrainDetails> list = trainDetailsService.trainNo(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TrainDetails>> getTrains() {
        List<TrainDetails> list = trainDetailsService.trainAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/between")
    public ResponseEntity<List<TrainFromAndTo>> getTrains(@RequestParam("from") String from,
            @RequestParam("to") String to) {
        List<TrainFromAndTo> list = trainDetailsService.findTrains(from, to);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public void TrainController(TrainDetailsService trainDetailsService) {
        this.trainDetailsService = trainDetailsService;
    }

    @GetMapping("/number/{no}")
    public ResponseEntity<List<TrainDetails>> getTrainsByNumber(@PathVariable int no) {
        List<TrainDetails> list = trainDetailsService.trainNo(no);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/route/number/{no}")
    public ResponseEntity<List<Object[]>> getTrainsByRoute(@PathVariable int no) {
        List<Object[]> list = trainDetailsService.trainNoRoute(no);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/route/number/{no}/{flag}")
    public ResponseEntity<List<Object[]>> getTrainsByRoute(@PathVariable int no, @PathVariable boolean flag) {
        List<Object[]> list = trainDetailsService.trainNoRouteIntermediateStations(no, flag);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
