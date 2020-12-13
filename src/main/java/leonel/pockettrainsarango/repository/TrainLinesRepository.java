package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainLine;

public interface TrainLinesRepository extends ArangoRepository<TrainLine, String> {

}
