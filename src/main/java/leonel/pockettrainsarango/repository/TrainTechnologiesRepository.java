package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainTechnology;

public interface TrainTechnologiesRepository extends ArangoRepository<TrainTechnology, String> {
    TrainTechnology findByName(String name);
}
