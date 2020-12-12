package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainEngine;
import leonel.pockettrainsarango.model.TrainFuelCar;
import leonel.pockettrainsarango.model.TrainPart;

public interface TrainPartsRepository extends ArangoRepository<TrainPart, String> {

    @Query("FOR c IN #collection FILTER c._class == \"leonel.pockettrainsarango.model.TrainFuelCar\" RETURN c")
    Iterable<TrainFuelCar> findAllTrainFuelCars();

    @Query("FOR c IN #collection FILTER c._class == \"leonel.pockettrainsarango.model.TrainEngine\" RETURN c")
    Iterable<TrainEngine> findAllTrainEngines();
}
