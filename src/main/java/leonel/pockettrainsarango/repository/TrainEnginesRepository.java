package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainEngine;

public interface TrainEnginesRepository extends ArangoRepository<TrainEngine, String> {
}
