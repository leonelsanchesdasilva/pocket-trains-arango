package leonel.pockettrainsarango.controller;

import leonel.pockettrainsarango.model.City;
import leonel.pockettrainsarango.model.Route;
import leonel.pockettrainsarango.model.dto.RoutePostDto;
import leonel.pockettrainsarango.repository.CitiesRepository;
import leonel.pockettrainsarango.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @GetMapping("")
    public ResponseEntity<?> getRoutes() {
        List<Route> routes = new ArrayList<>();
        routesRepository.findAll().forEach(routes::add);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addRoute(@RequestBody RoutePostDto routePostDto) {
        City cityFrom = citiesRepository.findByName(routePostDto.getFrom());
        City cityTo = citiesRepository.findByName(routePostDto.getTo());
        Route route = new Route(null, cityFrom, cityTo, routePostDto.getDistance());
        routesRepository.save(route);
        return new ResponseEntity<>("Ok!", HttpStatus.CREATED);
    }
}
