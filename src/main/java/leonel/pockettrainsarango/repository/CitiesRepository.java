package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.City;

public interface CitiesRepository extends ArangoRepository<City, String> {
    public City findByName(String name);

    /* @Autowired
    private ArangoDatabase arangoDatabase;

    public Collection<String> getAllCities() {
        // String queryString = "FOR v IN 1..3 OUTBOUND 'cities/Irvine' GRAPH 'worldmap' RETURN v._key";
        String queryString = "FOR x IN cities RETURN x";
        ArangoCursor<String> cursor = arangoDatabase.query(queryString, null, null, String.class);
        return cursor.asListRemaining();
    }

    public String getOneCity(String key) {
        String queryString = "FOR x IN cities FILTER x._key == '" + key + "' RETURN x";
        ArangoCursor<String> cursor = arangoDatabase.query(queryString, null, null, String.class);
        return cursor.asListRemaining().get(0);
    }

    public void addCity(CityPostDto cityPostDto) {
        City newCity = new City();
        newCity.setKey(cityPostDto.getName());
        newCity.setName(cityPostDto.getName());

        arangoDatabase.graph("worldmap")
                .vertexCollection("cities")
                .insertVertex(newCity);
    } */
}
