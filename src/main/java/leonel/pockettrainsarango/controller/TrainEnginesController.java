package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.TrainEngine;
import leonel.pockettrainsarango.model.TrainTechnology;
import leonel.pockettrainsarango.model.dto.TrainEnginePostDto;
import leonel.pockettrainsarango.repository.TrainEnginesRepository;
import leonel.pockettrainsarango.repository.TrainTechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainEngines")
public class TrainEnginesController {

    @Autowired
    private TrainEnginesRepository trainEnginesRepository;

    @Autowired
    private TrainTechnologiesRepository trainTechnologiesRepository;

    @GetMapping("")
    public ResponseEntity<?> getTrainEngines() {
        List<TrainEngine> trainEngines = new ArrayList<>();
        trainEnginesRepository.findAll().forEach(trainEngines::add);
        return new ResponseEntity<>(trainEngines, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrainEngine(@RequestBody TrainEnginePostDto trainEnginePostDto) {
        TrainTechnology trainTechnology = trainTechnologiesRepository.findByName(trainEnginePostDto.getTrainTechnology());
        TrainEngine trainEngine = new TrainEngine(null, trainTechnology);
        trainEnginesRepository.save(trainEngine);
        return new ResponseEntity("Ok!", HttpStatus.CREATED);
    }
}
