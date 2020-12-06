package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.CargoItem;
import leonel.pockettrainsarango.model.City;
import leonel.pockettrainsarango.model.dto.CargoItemPostDto;
import leonel.pockettrainsarango.repository.CargoItemsRepository;
import leonel.pockettrainsarango.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cargoItems")
public class CargoItemsController {

    @Autowired
    private CargoItemsRepository cargoItemsRepository;

    @Autowired
    private CitiesRepository citiesRepository;

    @GetMapping("")
    public ResponseEntity<?> getCargoItems() {
        List<CargoItem> cargoItems = new ArrayList<>();
        cargoItemsRepository.findAll().forEach(cargoItems::add);
        return new ResponseEntity(cargoItems, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addCargoItem(@RequestBody CargoItemPostDto cargoItemPostDto) {
        City currentCity = citiesRepository.findByName(cargoItemPostDto.getCurrentCity());
        City destination = citiesRepository.findByName(cargoItemPostDto.getDestination());
        CargoItem cargoItem = new CargoItem(null, cargoItemPostDto.getDescription(),
                cargoItemPostDto.getSlotSize(), cargoItemPostDto.getValue(), currentCity, destination);
        cargoItemsRepository.save(cargoItem);
        return new ResponseEntity("Ok!", HttpStatus.OK);
    }
}
