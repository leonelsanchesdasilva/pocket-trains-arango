package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.Route;
import org.springframework.data.repository.query.Param;

public interface RoutesRepository extends ArangoRepository<Route, String> {

    @Query("FOR r in routes FOR cf in cities FOR ct in cities " +
            "FILTER r._from == cf._id FILTER r._to == ct._id " +
            "FILTER cf.name == @cityFrom OR ct.name == @cityFrom " +
            "FILTER cf.name == @cityTo OR ct.name == @cityTo " +
            "RETURN r")
    Route findByCityFromAndCityTo(@Param("cityFrom") String cityFrom, @Param("cityTo") String cityTo);

    @Query("FOR v, e in ANY SHORTEST_PATH @cityFrom to @cityTo ANY routes RETURN e")
    Iterable<Route> findShortestRoute(@Param("cityFrom") String cityFrom, @Param("cityTo") String cityTo);

    /* @Autowired
    private ArangoDatabase arangoDatabase;

    public Collection<String> getAllRoutes() {
        String queryString = "WITH cities FOR v IN 1..3 OUTBOUND 'cities/A' edges RETURN v._key";
        ArangoCursor<String> cursor = arangoDatabase.query(queryString, null, null, String.class);
        return cursor.asListRemaining();
    } */
}
