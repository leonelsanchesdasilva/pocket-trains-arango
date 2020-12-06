package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.CargoItem;

public interface CargoItemsRepository extends ArangoRepository<CargoItem, String> {
}
