package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainFuelCar;

public interface TrainFuelCarsRepository extends ArangoRepository<TrainFuelCar, String> {

    @Query("FOR c IN #collection FILTER c._class == \"leonel.pockettrainsarango.model.TrainFuelCar\" RETURN c")
    Iterable<TrainFuelCar> findAll();
}
