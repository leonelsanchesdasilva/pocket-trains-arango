package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainFuelCar;

public interface TrainFuelCarsRepository extends ArangoRepository<TrainFuelCar, String> {

}
