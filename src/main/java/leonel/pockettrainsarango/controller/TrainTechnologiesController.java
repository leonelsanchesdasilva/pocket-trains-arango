package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.TrainTechnology;
import leonel.pockettrainsarango.model.dto.TrainTechnologyPostDto;
import leonel.pockettrainsarango.repository.TrainTechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainTechnologies")
public class TrainTechnologiesController {

    @Autowired
    private TrainTechnologiesRepository trainTechnologiesRepository;

    @GetMapping("")
    public ResponseEntity<?> getTrainTechnologies() {
        List<TrainTechnology> trainTechnologies = new ArrayList<>();
        trainTechnologiesRepository.findAll().forEach(trainTechnologies::add);
        return new ResponseEntity<>(trainTechnologies, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrainTechnology(@RequestBody TrainTechnologyPostDto trainTechnologyPostDto) {
        TrainTechnology trainTechnology = new TrainTechnology(null,
                trainTechnologyPostDto.getName(),
                trainTechnologyPostDto.getSpeed(),
                trainTechnologyPostDto.getBaseCapacity(),
                trainTechnologyPostDto.getBaseFuel(),
                trainTechnologyPostDto.getPeerEngines(),
                trainTechnologyPostDto.getFuelCars(),
                trainTechnologyPostDto.getRequiredParts());
        trainTechnologiesRepository.save(trainTechnology);
        return new ResponseEntity<>("Ok!", HttpStatus.CREATED);
    }
}
