package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.Route;

public interface RoutesRepository extends ArangoRepository<Route, String> {

    /* @Autowired
    private ArangoDatabase arangoDatabase;

    public Collection<String> getAllRoutes() {
        String queryString = "WITH cities FOR v IN 1..3 OUTBOUND 'cities/A' edges RETURN v._key";
        ArangoCursor<String> cursor = arangoDatabase.query(queryString, null, null, String.class);
        return cursor.asListRemaining();
    } */
}
