package leonel.pockettrainsarango.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import leonel.pockettrainsarango.model.TrainEngine;
import org.springframework.data.repository.query.Param;

public interface TrainEnginesRepository extends ArangoRepository<TrainEngine, String> {

    @Query("FOR c IN #collection FILTER c._class == \"leonel.pockettrainsarango.model.TrainEngine\" RETURN c")
    Iterable<TrainEngine> findAll();

    @Query("FOR te in trainParts FOR tt in trainTechnologies "+
            "FILTER te._class == \"leonel.pockettrainsarango.model.TrainEngine\" " +
            "FILTER te.trainTechnology == tt._id " +
            "FILTER tt.name == @trainTechnology " +
            "RETURN te")
    TrainEngine findByTrainTechnology(@Param("trainTechnology") String trainTechnology);
}
