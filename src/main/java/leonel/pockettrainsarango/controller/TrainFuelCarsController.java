package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.TrainFuelCar;
import leonel.pockettrainsarango.model.TrainTechnology;
import leonel.pockettrainsarango.model.dto.TrainFuelCarPostDto;
import leonel.pockettrainsarango.repository.TrainFuelCarsRepository;
import leonel.pockettrainsarango.repository.TrainTechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainFuelCars")
public class TrainFuelCarsController {

    @Autowired
    private TrainFuelCarsRepository trainFuelCarsRepository;

    @Autowired
    private TrainTechnologiesRepository trainTechnologiesRepository;

    @GetMapping("")
    public ResponseEntity<?> getTrainFuelCars() {
        List<TrainFuelCar> trainFuelCars = new ArrayList<>();
        trainFuelCarsRepository.findAll().forEach(trainFuelCars::add);
        return new ResponseEntity<>(trainFuelCars, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrainFuelCar(@RequestBody TrainFuelCarPostDto trainFuelCarPostDto) {
        TrainTechnology trainTechnology = trainTechnologiesRepository.findByName(trainFuelCarPostDto.getTrainTechnology());
        TrainFuelCar trainFuelCar = new TrainFuelCar(null, trainTechnology);
        trainFuelCarsRepository.save(trainFuelCar);
        return new ResponseEntity("Ok!", HttpStatus.CREATED);
    }
}
