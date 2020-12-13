package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.Route;
import leonel.pockettrainsarango.model.TrainEngine;
import leonel.pockettrainsarango.model.TrainLine;
import leonel.pockettrainsarango.model.dto.TrainLinePostDto;
import leonel.pockettrainsarango.model.dto.TrainRouteDto;
import leonel.pockettrainsarango.repository.RoutesRepository;
import leonel.pockettrainsarango.repository.TrainEnginesRepository;
import leonel.pockettrainsarango.repository.TrainLinesRepository;
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
@RequestMapping("/trainLines")
public class TrainLinesController {

    @Autowired
    private TrainLinesRepository trainLinesRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private TrainEnginesRepository trainEnginesRepository;

    @GetMapping("")
    public ResponseEntity<?> getTrainLines() {
        List<TrainLine> routes = new ArrayList<>();
        trainLinesRepository.findAll().forEach(routes::add);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrainLine(@RequestBody TrainLinePostDto trainLinePostDto) {
        List<Route> routes = new ArrayList<>();
        for (TrainRouteDto trainRouteDto: trainLinePostDto.getTrainRoutes()) {
            Route route = routesRepository.findByCityFromAndCityTo(trainRouteDto.getFrom(), trainRouteDto.getTo());
            routes.add(route);
        }

        TrainEngine trainEngine = trainEnginesRepository.findByTrainTechnology(trainLinePostDto.getTrainTechnology());
        TrainLine trainLine = new TrainLine(null,
                trainLinePostDto.getName(),
                Collections.singletonList(trainEngine),
                new ArrayList<>(),
                routes.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        trainLinesRepository.save(trainLine);
        return new ResponseEntity<>("Ok!", HttpStatus.CREATED);
    }
}
