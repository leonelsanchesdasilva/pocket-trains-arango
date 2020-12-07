package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Document(value="trainLines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainLine {

    @Id
    private String id;
    private String name;

    @Ref
    private Collection<TrainEngine> trainEngines;

    @Ref
    private Collection<TrainFuelCar> trainFuelCars;
}
