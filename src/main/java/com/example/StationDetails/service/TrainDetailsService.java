package com.example.StationDetails.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StationDetails.model.TrainDetails;
import com.example.StationDetails.model.TrainFromAndTo;
import com.example.StationDetails.repository.TrainDetailsRepository;
import com.example.StationDetails.repository.TrainRouteRepository;

@Service
public class TrainDetailsService {
    @Autowired
    private TrainRouteRepository trainRouteRepository;
    @Autowired
    private TrainDetailsRepository trainDetailsRepository;

    public List<TrainFromAndTo> findTrains(String from, String to) {
        List<Object[]> fromTrains = trainRouteRepository.findTrainStopDetail(from);
        List<Object[]> toTrains = trainRouteRepository.findTrainStopDetail(to);
        Map<Integer, Object[]> toTrainMap = new HashMap<>();

        for (Object[] obj : toTrains)
            toTrainMap.put((Integer) obj[4], obj);

        List<TrainFromAndTo> output = new ArrayList<>();
        for (Object[] list : fromTrains) {
            Integer TrainNo = (Integer) list[4];
            if (toTrainMap.containsKey(TrainNo)) {
                Object[] toObj = toTrainMap.get(TrainNo);
                Integer fromStopNumber = (Integer) list[7];
                Integer toStopNumber = (Integer) toObj[7];
                if (fromStopNumber < toStopNumber) {
                    List<TrainDetails> tr = trainDetailsRepository.findByTrainNo(TrainNo);

                    String fromArrivalTime = list[9].toString();
                    String fromDepartureTime = list[10].toString();
                    float fromDistance = (float) list[12];

                    String toArrivalTime = toObj[9].toString();
                    String toDepartureTime = toObj[10].toString();
                    float toDistance = (float) toObj[12];

                    TrainFromAndTo train = new TrainFromAndTo(tr.get(0), from, fromArrivalTime, fromDepartureTime,
                            fromStopNumber, fromDistance, to, toArrivalTime, toDepartureTime, toStopNumber, toDistance);
                    output.add(train);
                }
            }
        }

        return output;
    }

    public List<TrainDetails> trainId(int id) {
        return trainDetailsRepository.findByTrainNo(id);
    }

    public List<TrainDetails> trainNo(int no) {
        return trainDetailsRepository.findByTrainNo(no);
    }

    public List<TrainDetails> trainAll() {
        return trainDetailsRepository.findAll();
    }

    public List<Object[]> trainNoRoute(int no) {
        return trainDetailsRepository.findTrainRoute(no);
    }

    public List<Object[]> trainNoRouteIntermediateStations(int no, boolean flag) {
        return trainDetailsRepository.findTrainRouteIntermediateStations(no, flag);
    }
}
