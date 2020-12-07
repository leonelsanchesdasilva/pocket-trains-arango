package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Document(value="trainFuelCars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainFuelCar {

    @Id
    private String id;

    @Ref
    private TrainTechnology trainTechnology;
}
