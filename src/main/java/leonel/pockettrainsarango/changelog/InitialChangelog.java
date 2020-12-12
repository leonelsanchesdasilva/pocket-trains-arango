package leonel.pockettrainsarango.changelog;

import leonel.pockettrainsarango.model.City;
import leonel.pockettrainsarango.model.Route;
import leonel.pockettrainsarango.model.TrainTechnology;
import leonel.pockettrainsarango.repository.CitiesRepository;
import leonel.pockettrainsarango.repository.RoutesRepository;
import leonel.pockettrainsarango.repository.TrainTechnologiesRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialChangelog {

    private static final Log log = LogFactory.getLog(InitialChangelog.class);

    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private TrainTechnologiesRepository trainTechnologiesRepository;

    @PostConstruct
    public void init() throws Exception {
        List<City> cities = addCities();
        addRoutes(cities);
        addTrainTechnologies();
    }

    private List<City> addCities() {
        if (citiesRepository.count() > 0) {
            log.info("Cities already present. Skipping seed...");
            List<City> cities = new ArrayList<>();
            citiesRepository.findAll().forEach(cities::add);
            return cities;
        }

        log.info("Seeding Cities...");
        List<City> cities = Arrays.asList(
                new City("Lisbon"),
                new City("Madrid"),
                new City("Barcelona"),
                new City("Bordeaux"),
                new City("Paris"),
                new City("London"),
                new City("Dublin"),
                new City("Glasgow"),
                new City("Reykjavik"),
                new City("Amsterdam"),
                new City("Copenhagen"),
                new City("Stockholm"),
                new City("Oslo"),
                new City("Helsinki"),
                new City("Berlin"),
                new City("Munich"),
                new City("Milan"),
                new City("Rome"),
                new City("Budapest"),
                new City("Athens"),
                new City("Minsk"),
                new City("Kiev"),
                new City("Istanbul"),
                new City("St. Petersburg"),
                new City("Moscow"),
                new City("Volgograd"),
                new City("Tehran"),
                new City("Baghdad"),
                new City("Amman"),
                new City("Perm"),
                new City("Urumqi"),
                new City("Casablanca"),
                new City("Algiers"),
                new City("Dakar"),
                new City("New York")
        );

        citiesRepository.saveAll(cities);
        return cities;
    }

    private void addRoutes(List<City> cities) throws Exception {
        if (routesRepository.count() > 0) {
            log.info("Routes already present. Skipping seed...");
            return;
        }

        log.info("Seeding Routes...");

        List<Route> routes = Arrays.asList(
                new Route(null, findCity(cities, "Amsterdam"), findCity(cities, "Berlin"), 408),
                new Route(null, findCity(cities, "Amsterdam"), findCity(cities, "Paris"), 313),
                new Route(null, findCity(cities, "Amsterdam"), findCity(cities, "Munich"), 512),
                new Route(null, findCity(cities, "Amsterdam"), findCity(cities, "Copenhagen"), 491),
                new Route(null, findCity(cities, "Copenhagen"), findCity(cities, "Oslo"), 375),
                new Route(null, findCity(cities, "Copenhagen"), findCity(cities, "Stockholm"), 409),
                new Route(null, findCity(cities, "Helsinki"), findCity(cities, "Stockholm"), 298),
                new Route(null, findCity(cities, "Oslo"), findCity(cities, "Stockholm"), 327),
                new Route(null, findCity(cities, "Paris"), findCity(cities, "London"), 291),
                new Route(null, findCity(cities, "Paris"), findCity(cities, "Munich"), 523),
                new Route(null, findCity(cities, "Paris"), findCity(cities, "Milan"), 529),
                new Route(null, findCity(cities, "Paris"), findCity(cities, "Bordeaux"), 363),
                new Route(null, findCity(cities, "Milan"), findCity(cities, "Bordeaux"), 622),
                new Route(null, findCity(cities, "Milan"), findCity(cities, "Barcelona"), 611),
                new Route(null, findCity(cities, "Milan"), findCity(cities, "Rome"), 358),
                new Route(null, findCity(cities, "Milan"), findCity(cities, "Munich"), 308),
                new Route(null, findCity(cities, "Madrid"), findCity(cities, "Bordeaux"), 430),
                new Route(null, findCity(cities, "Madrid"), findCity(cities, "Lisbon"), 388),
                new Route(null, findCity(cities, "Madrid"), findCity(cities, "Casablanca"), 671),
                new Route(null, findCity(cities, "Madrid"), findCity(cities, "Barcelona"), 391),
                new Route(null, findCity(cities, "Munich"), findCity(cities, "Berlin"), 364),
                new Route(null, findCity(cities, "Munich"), findCity(cities, "Budapest"), 405),
                new Route(null, findCity(cities, "Berlin"), findCity(cities, "Budapest"), 543),
                new Route(null, findCity(cities, "Berlin"), findCity(cities, "Minsk"), 689),
                new Route(null, findCity(cities, "Budapest"), findCity(cities, "Kiev"), 695),
                new Route(null, findCity(cities, "Budapest"), findCity(cities, "Istanbul"), 823),
                new Route(null, findCity(cities, "Budapest"), findCity(cities, "Athens"), 914),
                new Route(null, findCity(cities, "Kiev"), findCity(cities, "Minsk"), 329),
                new Route(null, findCity(cities, "Kiev"), findCity(cities, "Moscow"), 535),
                new Route(null, findCity(cities, "Kiev"), findCity(cities, "Volgograd"), 800),
                new Route(null, findCity(cities, "Kiev"), findCity(cities, "Istanbul"), 806),
                new Route(null, findCity(cities, "Baghdad"), findCity(cities, "Istanbul"), 1348),
                new Route(null, findCity(cities, "Baghdad"), findCity(cities, "Amman"), 554),
                new Route(null, findCity(cities, "Baghdad"), findCity(cities, "Tehran"), 546),
                new Route(null, findCity(cities, "Moscow"), findCity(cities, "St. Petersburg"), 439),
                new Route(null, findCity(cities, "Moscow"), findCity(cities, "Perm"), 894),
                new Route(null, findCity(cities, "Moscow"), findCity(cities, "Volgograd"), 603),
                new Route(null, findCity(cities, "Volgograd"), findCity(cities, "Urumqi"), 2057),
                new Route(null, findCity(cities, "Volgograd"), findCity(cities, "Tehran"), 1227),
                new Route(null, findCity(cities, "Casablanca"), findCity(cities, "Algiers"), 757),
                new Route(null, findCity(cities, "Casablanca"), findCity(cities, "Dakar"), 1790),
                new Route(null, findCity(cities, "London"), findCity(cities, "Dublin"), 370),
                new Route(null, findCity(cities, "London"), findCity(cities, "Glasgow"), 412),
                new Route(null, findCity(cities, "Reykjavik"), findCity(cities, "Glasgow"), 840),
                new Route(null, findCity(cities, "Lisbon"), findCity(cities, "New York"), 3367)
        );

        routesRepository.saveAll(routes);
    }

    private void addTrainTechnologies() {
        if (trainTechnologiesRepository.count() > 0) {
            log.info("Train technologies already present. Skipping seed...");
            return;
        }

        log.info("Seeding Train Technologies...");

        List<TrainTechnology> trainTechnologies = Arrays.asList(
                new TrainTechnology(null, "Cherry Steamer", 55, 8, 230, 1, 1, 3),
                new TrainTechnology(null, "Mallard", 100, 16, 600, 1, 1, 12),
                new TrainTechnology(null, "Dragonbreath", 90, 14, 250, 1, 3, 5),
                new TrainTechnology(null, "Daylight", 87, 18, 700, 1, 1, 12),
                new TrainTechnology(null, "National Express", 100, 8, 300, 2, 1, 6),
                new TrainTechnology(null, "Dekotora", 67, 20, 1000, 1, 1, 13),
                new TrainTechnology(null, "Century Limited", 92, 18, 700, 1, 1, 13),
                new TrainTechnology(null, "Global Express", 95, 8, 330, 2, 1, 6),
                new TrainTechnology(null, "Vanilla Steamer", 52, 8, 260, 1, 1, 3),
                new TrainTechnology(null, "Bullet", 126, 16, 600, 1, 2, 14),
                new TrainTechnology(null, "Regional Express", 105, 8, 315, 2, 1, 7),
                new TrainTechnology(null, "Rio Grande Standard", 87, 12, 600, 3, 2, 10),
                new TrainTechnology(null, "Gila Standard", 95, 12, 540, 3, 2, 10),
                new TrainTechnology(null, "San Juan Standard", 80, 12, 660, 3, 2, 10),
                new TrainTechnology(null, "Terabyte Zephyr", 112, 14, 400, 1, 2, 9),
                new TrainTechnology(null, "Petabyte Zephyr", 123, 14, 360, 1, 2, 9),
                new TrainTechnology(null, "Exabyte Zephyr", 101, 14, 440, 1, 2, 9),
                new TrainTechnology(null, "Zettabyte Zephyr", 118, 14, 420, 1, 2, 10),
                new TrainTechnology(null, "Metro Express", 110, 12, 540, 2, 1, 6),
                new TrainTechnology(null, "Bluebell Steamer", 50, 8, 500, 1, 1, 3),
                new TrainTechnology(null, "Emerald Steamer", 47, 8, 540, 1, 1, 3),
                new TrainTechnology(null, "Pumpkin Steamer", 105, 13, 700, 1, 1, 3),
                new TrainTechnology(null, "Pecos Standard", 91, 12, 1260, 3, 2, 10)
        );

        trainTechnologiesRepository.saveAll(trainTechnologies);
    }

    private City findCity(List<City> cities, String cityName) throws Exception {
        return cities.stream().filter(c -> cityName.equals(c.getName())).findFirst().orElseThrow(Exception::new);
    }
}
