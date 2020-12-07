package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Document(value="trainTechnologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainTechnology {

    @Id
    private String id;
    private String name;
    private Integer speed;
    private Integer baseCapacity;
    private Integer baseFuel;
    private Integer peerEngines;
    private Integer fuelCars;
}
