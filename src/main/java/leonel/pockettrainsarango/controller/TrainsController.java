package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.Route;
import leonel.pockettrainsarango.model.Train;
import leonel.pockettrainsarango.model.TrainEngine;
import leonel.pockettrainsarango.model.TrainLine;
import leonel.pockettrainsarango.model.dto.TrainLinePostDto;
import leonel.pockettrainsarango.model.dto.TrainPostDto;
import leonel.pockettrainsarango.model.dto.TrainRouteDto;
import leonel.pockettrainsarango.repository.RoutesRepository;
import leonel.pockettrainsarango.repository.TrainEnginesRepository;
import leonel.pockettrainsarango.repository.TrainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/trains")
public class TrainsController {

    @Autowired
    private TrainsRepository trainsRepository;

    @Autowired
    private TrainEnginesRepository trainEnginesRepository;

    @GetMapping("")
    public ResponseEntity<?> getTrains() {
        List<Train> routes = new ArrayList<>();
        trainsRepository.findAll().forEach(routes::add);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrain(@RequestBody TrainPostDto trainPostDto) {
        TrainEngine trainEngine = trainEnginesRepository.findByTrainTechnology(trainPostDto.getTrainTechnology());
        Train train = new Train(null,
                trainPostDto.getName(),
                Collections.singletonList(trainEngine),
                new ArrayList<>());
        trainsRepository.save(train);
        return new ResponseEntity<>("Ok!", HttpStatus.CREATED);
    }
}
