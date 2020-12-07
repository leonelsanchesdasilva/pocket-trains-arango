package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.City;
import leonel.pockettrainsarango.model.dto.CityPostDto;
import leonel.pockettrainsarango.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CitiesRepository citiesRepository;

    @GetMapping("")
    public ResponseEntity<?> getCities() {
        List<City> cities = new ArrayList<>();
        citiesRepository.findAll().forEach(cities::add);
        return new ResponseEntity(cities, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getOneCity(@PathVariable String name) {
        City city = citiesRepository.findByName(name);
        return new ResponseEntity(city, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addCity(@RequestBody CityPostDto cityPostDto) {
        City city = new City(cityPostDto.getName());
        citiesRepository.save(city);
        return new ResponseEntity("Ok!", HttpStatus.CREATED);
    }
}
