package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.Train;

public interface TrainsRepository extends ArangoRepository<Train, String> {
}
