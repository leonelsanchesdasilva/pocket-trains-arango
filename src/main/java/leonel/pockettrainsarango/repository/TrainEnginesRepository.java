package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainEngine;

public interface TrainEnginesRepository extends ArangoRepository<TrainEngine, String> {

    @Query("FOR c IN #collection FILTER c._class == \"leonel.pockettrainsarango.model.TrainEngine\" RETURN c")
    Iterable<TrainEngine> findAll();
}
